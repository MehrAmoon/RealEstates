package com.amoon.aviv.realestate.domain.repositores

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    fun getAll(): List<RealEstatesModel>

    suspend fun insert(realEstatesModel: List<RealEstatesModel>)

}