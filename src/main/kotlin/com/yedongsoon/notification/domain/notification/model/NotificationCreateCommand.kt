package com.yedongsoon.notification.domain.notification.model

import jakarta.persistence.Column

data class NotificationCreateCommand(
        val memberNo: Int,
        val title: String,
        val body: String,
        val link: String,
)