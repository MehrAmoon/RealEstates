package com.amoon.aviv.realestate.repositories

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.repositores.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeDatabaseRepository : DatabaseRepository {

    // Simulate the database with a MutableStateFlow
    private val database = MutableStateFlow<List<RealEstatesModel>>(emptyList())

    override fun getAll(): Flow<List<RealEstatesModel>> {
        return database
    }

    override suspend fun insert(realEstatesModel: RealEstatesModel) {
        // Add the new RealEstatesModel to the database
        database.value = database.value + realEstatesModel
    }

}
