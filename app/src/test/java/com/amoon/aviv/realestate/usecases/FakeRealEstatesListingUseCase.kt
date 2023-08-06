package com.amoon.aviv.realestate.usecases

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.usecases.RealEstatesListingUseCase
import com.amoon.aviv.realestate.repositories.FakeNetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeRealEstatesListingUseCase(private val fakeNetworkRepository: FakeNetworkRepository) :  RealEstatesListingUseCase(fakeNetworkRepository) {

    override fun listRealEstates(): Flow<List<RealEstatesModel>> {
        return fakeNetworkRepository.getRealEstatesList()
    }
}