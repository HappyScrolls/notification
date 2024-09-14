package com.yedongsoon.notification.presentation.extension

import com.yedongsoon.notification.domain.extension.decodeBase64ToDto
import com.yedongsoon.notification.presentation.extension.MemberHeader
import com.yedongsoon.notification.presentation.extension.ServiceHeader
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.queryParamOrNull
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun ServerRequest.extractMemberCodeHeader(): MemberHeader {
    return headers().header("Member-Code").firstOrNull()
            ?.let {
                it.decodeBase64ToDto<MemberHeader>()
            } ?: throw IllegalArgumentException()
}

fun ServerRequest.extractServiceCodeHeader(): ServiceHeader {
    return headers().header("Service-Code").firstOrNull()
            ?.let {
                it.decodeBase64ToDto<ServiceHeader>()
            } ?: throw IllegalArgumentException()
}

fun ServerRequest.intQueryParam(parameter: String): Int {
    return queryParamOrNull(parameter)?.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid or missing 'itemNo' query parameter")
}


fun ServerRequest.localDateQueryParam(parameter: String): LocalDate {
    return queryParamOrNull(parameter)?.let {
        LocalDate.parse(it, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    } ?: throw IllegalArgumentException()
}

fun ServerRequest.extractRawMemberCodeHeader(): String {
    return headers().header("Member-Code").firstOrNull() ?: throw IllegalArgumentException("헤더 없음")
}