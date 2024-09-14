package com.yedongsoon.notification.application.notification

import com.yedongsoon.example_project.application.exception.ExampleNotFoundException
import com.yedongsoon.notification.domain.notification.Notification
import com.yedongsoon.notification.domain.notification.NotificationRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class NotificationQueryService(
        private val notificationRepository: NotificationRepository,
) {
    suspend fun getNotificationList(memberNo:Int): List<Notification> {

        return notificationRepository.findByMemberNo(memberNo)
    }
}

