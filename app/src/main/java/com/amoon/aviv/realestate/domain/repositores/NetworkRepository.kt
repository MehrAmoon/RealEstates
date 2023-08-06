package com.amoon.aviv.realestate.domain.repositores

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    fun getRealEstatesList(): Flow<List<RealEstatesModel>>
}