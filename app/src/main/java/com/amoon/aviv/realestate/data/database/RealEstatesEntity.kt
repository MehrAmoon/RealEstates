package com.amoon.aviv.realestate.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RealEstatesEntity(

    @PrimaryKey val id: Int,
    val bedrooms: Int,
    val city: String,
    val area: Int,
    val url: String,
    val price: Int,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
    val rooms: Int

    )