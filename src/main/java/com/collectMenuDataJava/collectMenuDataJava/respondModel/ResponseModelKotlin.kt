package com.collectMenuDataJava.collectMenuDataJava.respondModel

data class ResponseModelKotlin(
        val MenuImageUrl: String?,
        var menuName: String?,
        val price: String?,
        val rating: Int?,
        val spicy: Int?,
        val tag: List<Int?>?
)