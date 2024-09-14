package com.yedongsoon.notification.presentation.handler.model

import com.yedongsoon.notification.domain.notification.model.NotificationCreateCommand

data class NotificationCreateRequest(
        val title: String,
        val body: String,
        val link: String,
)
{
    fun toCommand(memberNo:Int)=NotificationCreateCommand(
            memberNo=memberNo,
            title=title,
            body=body,
            link=link,
    )
}