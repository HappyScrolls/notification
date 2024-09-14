package com.yedongsoon.notification.application.notification

import com.yedongsoon.example_project.application.exception.ExampleNotFoundException
import com.yedongsoon.notification.domain.notification.Notification
import com.yedongsoon.notification.domain.notification.NotificationRepository
import com.yedongsoon.notification.domain.notification.model.NotificationCreateCommand
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificationCommandService(
        private val notificationRepository: NotificationRepository,
) {
    fun createNotification(command: NotificationCreateCommand) {
        notificationRepository.save(Notification.create(command))
    }
}