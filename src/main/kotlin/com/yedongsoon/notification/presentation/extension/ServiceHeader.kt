package com.yedongsoon.notification.presentation.extension

import com.fasterxml.jackson.annotation.JsonProperty

data class ServiceHeader
(
        @JsonProperty("no")
        val no: Int,
        @JsonProperty("title")
        val title: String,
)

