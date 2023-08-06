package com.amoon.aviv.realestate.viewmodels

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.presentation.screens.navigationparams.DetailParams
import com.amoon.aviv.realestate.presentation.viewmodels.DetailScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class DetailScreenViewModelTest {


    // The DetailScreenViewModel instance to be tested
    private lateinit var detailScreenViewModel: DetailScreenViewModel

    @Before
    fun setUp() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this)

        // Create the DetailScreenViewModel
        detailScreenViewModel = DetailScreenViewModel()
    }

    @Test
    fun `initParams should initialize properties correctly`() {
        // Given: A list of RealEstatesModel and a detailParams
        val realEstatesList = listOf(
            RealEstatesModel(city = "Berlin", ),
            RealEstatesModel(city = "Paris",)
        )
        val detailParams = DetailParams(list = realEstatesList, index = 1)

        // When: Calling initParams with the detailParams
        detailScreenViewModel.initParams(detailParams)

        // Then: The properties should be initialized correctly
        assertEquals("Paris", detailScreenViewModel.pageTitle)
        assertEquals(1, detailScreenViewModel.realEstateId)
        assertEquals(realEstatesList, detailScreenViewModel.listRealEstateModel.value)
    }

    @Test
    fun `listRealEstateModel should emit the correct list of RealEstatesModel`() = runTest {
        // Given: A list of RealEstatesModel
        val realEstatesList = listOf(
            RealEstatesModel(city = "Tehran",),
            RealEstatesModel(city = "Yazd", )
        )

        // When: Setting the value of listRealEstateModel using _listRealEstateModel
        detailScreenViewModel.run {
            _listRealEstateModel.value = realEstatesList
        }

        // Then: listRealEstateModel should emit the correct list of RealEstatesModel
        assertEquals(realEstatesList, detailScreenViewModel.listRealEstateModel.first())
    }
}
