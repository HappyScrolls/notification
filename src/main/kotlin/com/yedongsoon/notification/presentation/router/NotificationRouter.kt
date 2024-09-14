package com.yedongsoon.notification.presentation.router

import com.yedongsoon.notification.presentation.handler.NotificationHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class NotificationRouter(private val notificationHandler: NotificationHandler) {
    @Bean
    fun notificationRoute(): RouterFunction<ServerResponse> {
        return coRouter {
            (accept(MediaType.APPLICATION_JSON) and "/notification-service").nest {
                POST("", notificationHandler::createNotification)
                GET("", notificationHandler::getNotificationList)
            }
        }
    }
}
