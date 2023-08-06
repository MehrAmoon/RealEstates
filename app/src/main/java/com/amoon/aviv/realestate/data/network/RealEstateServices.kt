package com.amoon.aviv.realestate.data.network

import com.amoon.aviv.realestate.data.network.models.ListingResponse
import retrofit2.http.GET

interface RealEstateServices {

    @GET("/listings.json")
    suspend fun listing(): ListingResponse
}