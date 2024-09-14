package com.yedongsoon.notification.presentation.handler.model
import com.yedongsoon.notification.domain.notification.Notification
import java.time.LocalDateTime

data class NotificationDetailResponse(
        val notificationNo:Int,
        val title: String,
        val body: String,
        val link: String,
        val isRead: Boolean,
        val createdAt: LocalDateTime,
){
    companion object{
        fun from(notification: Notification)=NotificationDetailResponse(
                notificationNo=notification.no,
                title = notification.title,
                body = notification.body,
                link = notification.link,
                isRead = notification.isRead,
                createdAt = notification.createdAt,
        )
    }
}