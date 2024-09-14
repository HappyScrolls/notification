package com.yedongsoon.notification.presentation.handler

import com.yedongsoon.notification.presentation.extension.extractMemberCodeHeader
import com.yedongsoon.notification.application.notification.NotificationCommandService
import com.yedongsoon.notification.application.notification.NotificationQueryService
import com.yedongsoon.notification.presentation.handler.model.NotificationCreateRequest
import com.yedongsoon.notification.presentation.handler.model.NotificationDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.*

@Service
class NotificationHandler(
        private val notificationQueryService: NotificationQueryService,
        private val notificationCommandService: NotificationCommandService,
) {
    suspend fun createNotification(request: ServerRequest): ServerResponse = withContext(Dispatchers.IO) {
        val memberHeader = request.extractMemberCodeHeader()
        val command = request.awaitBodyOrNull<NotificationCreateRequest>()?.toCommand(memberHeader.no)
                ?: throw IllegalArgumentException()

        notificationCommandService.createNotification(command)
        ServerResponse.noContent().buildAndAwait()
    }

    suspend fun getNotificationList(request: ServerRequest): ServerResponse = withContext(Dispatchers.IO) {
        val memberHeader = request.extractMemberCodeHeader()
        val result = notificationQueryService.getNotificationList(memberHeader.no)
        ServerResponse.ok().bodyValueAndAwait(result.map { NotificationDetailResponse.from(it) })
    }
}