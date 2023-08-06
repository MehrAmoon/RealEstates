package com.amoon.aviv.realestate.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RealEstatesModel(
    val id: Int= 0,
    val bedrooms: Int= 0,
    val city: String= "",
    val area: Int= 0,
    val url: String= "",
    val price: Int= 0,
    val professional: String= "",
    val propertyType: String= "",
    val offerType: Int= 0,
    val rooms: Int= 0
):Parcelable