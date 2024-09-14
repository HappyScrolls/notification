package com.yedongsoon.notification.domain.notification

import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository : JpaRepository<Notification,Int>{
    fun findByMemberNo(memberNo:Int):List<Notification>
}