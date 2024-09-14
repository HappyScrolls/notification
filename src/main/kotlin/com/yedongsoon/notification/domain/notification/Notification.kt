package com.yedongsoon.notification.domain.notification

import com.yedongsoon.notification.domain.extension.BooleanToYNConverter
import com.yedongsoon.notification.domain.notification.model.NotificationCreateCommand
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "notification")
class Notification(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "notification_no")
        val no: Int = 0,

        @Column(name = "member_no")
        val memberNo: Int,

        @Column(name = "notification_title")
        val title: String,

        @Column(name = "notification_body")
        val body: String,

        @Column(name = "notification_link")
        val link: String,
) {
    @Convert(converter = BooleanToYNConverter::class)
    @Column(name = "is_read")
    val isRead: Boolean = false

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun create(command: NotificationCreateCommand) = Notification(
                memberNo = command.memberNo,
                title = command.title,
                body = command.body,
                link = command.link,
        )
    }
}