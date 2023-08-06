package com.amoon.aviv.realestate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.usecases.RealEstatesListingUseCase
import com.amoon.aviv.realestate.presentation.screens.MainScreen
import com.amoon.aviv.realestate.presentation.viewmodels.MainScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Mock
    private lateinit var mockRealEstatesListingUseCase: RealEstatesListingUseCase

    @Mock
    private lateinit var mainScreenViewModel: MainScreenViewModel

    private val realEstatesList = listOf(
        RealEstatesModel(
            id = 5,
            bedrooms = 0,
            city = "Berlin",
            area = 0,
            url = "",
            price = 0,
            professional = "",
            propertyType = "",
            offerType = 0,
            rooms = 0
        ),
        RealEstatesModel(
            id = 3,
            bedrooms = 0,
            city = "Paris",
            area = 0,
            url = "",
            price = 0,
            professional = "",
            propertyType = "",
            offerType = 0,
            rooms = 0
        )
    )

    @Before
    fun setUp() {

        mockRealEstatesListingUseCase = mock(RealEstatesListingUseCase::class.java)

        // Create the MainScreenViewModel with the mocked use case
        mainScreenViewModel = MainScreenViewModel(mockRealEstatesListingUseCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun mainScreen_SuccessState_DisplayContent() = runTest {

        // Mock the ViewModel behavior with a MutableStateFlow
        `when`(mockRealEstatesListingUseCase.listRealEstates()).thenReturn(
            flow {
                emit(realEstatesList)
            }
        )

        // When: Composing the MainScreen
        composeTestRule.setContent {
            MaterialTheme {
                MainScreen(
                    modifier = Modifier.fillMaxSize(),
                    mainViewModel = mainScreenViewModel,
                    onDetailedClicked = {}
                )
            }
        }

        // Then: The content should be displayed correctly
        composeTestRule.onNodeWithText("Real Estate", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("Berlin", useUnmergedTree = true).assertIsDisplayed()
    }
}
