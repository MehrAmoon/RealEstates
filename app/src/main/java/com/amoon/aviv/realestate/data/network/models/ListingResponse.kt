package com.amoon.aviv.realestate.data.network.models

import com.google.gson.annotations.SerializedName

data class ListingResponse(

    @field:SerializedName("items")
    val items: List<ListingsDetails>,

    @field:SerializedName("totalCount")
    val totalCount: Int
)



data class ListingsDetails(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("bedrooms")
    val bedrooms: Int,

    @field:SerializedName("city")
    val city: String,

    @field:SerializedName("area")
    val area: Int,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("price")
    val price: Int,

    @field:SerializedName("professional")
    val professional: String,

    @field:SerializedName("propertyType")
    val propertyType: String,

    @field:SerializedName("offerType")
    val offerType: Int,

    @field:SerializedName("rooms")
    val rooms: Int
    )