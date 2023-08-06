package com.amoon.aviv.realestate.repositories

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.repositores.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeNetworkRepository : NetworkRepository {

    // Simulate the network response with a MutableStateFlow
    private val fakeResponse = MutableStateFlow<List<RealEstatesModel>>(emptyList())

    // Helper function to set the fake network response
    fun setFakeResponse(realEstatesList: List<RealEstatesModel>) {
        fakeResponse.value = realEstatesList
    }

    override fun getRealEstatesList(): Flow<List<RealEstatesModel>> {
        return fakeResponse
    }
}
