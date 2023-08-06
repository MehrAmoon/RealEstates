package com.amoon.aviv.realestate.usecases


import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.repositores.NetworkRepository
import com.amoon.aviv.realestate.domain.usecases.RealEstatesListingUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RealEstatesListingUseCaseTest {

    // Mock the NetworkRepository dependency
    @Mock
    private lateinit var mockNetworkRepository: NetworkRepository

    // The RealEstatesListingUseCase instance to be tested
    private lateinit var realEstatesListingUseCase: RealEstatesListingUseCase

    @Before
    fun setUp() {
        // Initialize
        MockitoAnnotations.openMocks(this)

        // Create the RealEstatesListingUseCase with the mocked repository
        realEstatesListingUseCase = RealEstatesListingUseCase(mockNetworkRepository)
    }

    @Test
    fun `listRealEstates should return flow of RealEstatesModel list`() = runBlocking {
        // Given: A list of RealEstatesModel returned from the repository
        val realEstatesList = listOf(
            RealEstatesModel(),
            RealEstatesModel()
        )

        // When: Calling the listRealEstates()
        `when`(mockNetworkRepository.getRealEstatesList()).thenReturn(flowOf(realEstatesList))
        val result = realEstatesListingUseCase.listRealEstates()

        // Then: The result should match the expected list
        assertEquals(realEstatesList, result.first())
    }
}
