package com.example.networkstudy

import com.google.gson.annotations.SerializedName
data class Root(
    val errorMessage: ErrorMessage,
    val realtimeArrivalList: List<RealtimeArrivalList>?,
)

data class ErrorMessage(
    val status: Long,
    val code: String,
    val message: String,
    val link: String,
    val developerMessage: String,
    val total: Long,
)
data class RealtimeArrivalList(
    val beginRow: String?,
    val endRow: String?,
    val curPage: String?,
    val pageRow: String?,
    val totalCount: Long?,
    val rowNum: Long?,
    val selectedCount: Long?,
    val subwayId: String?,
    val subwayNm: String?,
    val updnLine: String?,
    val trainLineNm: String?,
    val subwayHeading: String?,
    val statnFid: String?,
    val statnTid: String?,
    val statnId: String?,
    val statnNm: String?,
    val trainCo: Long?,
    val trnsitCo: String?,
    val ordkey: String?,
    val subwayList: String?,
    val statnList: String?,
    val btrainSttus: String?,
    val barvlDt: String?,
    val btrainNo: String?,
    val bstatnId: String?,
    val bstatnNm: String?,
    val recptnDt: String?,
    val arvlMsg2: String?,
    val arvlMsg3: String?,
    val arvlCd: String?
)