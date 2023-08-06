package com.amoon.aviv.realestate.domain.usecases

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.repositores.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {

    fun getAll(): List<RealEstatesModel> {
        return databaseRepository.getAll()
    }

    suspend fun insert(realEstatesModel: List<RealEstatesModel>) {
        return databaseRepository.insert(realEstatesModel = realEstatesModel)

    }

}