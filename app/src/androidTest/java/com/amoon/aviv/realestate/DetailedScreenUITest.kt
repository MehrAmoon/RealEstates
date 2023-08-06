package com.amoon.aviv.realestate

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.presentation.screens.DetailedScreen
import com.amoon.aviv.realestate.presentation.screens.navigationparams.DetailParams
import com.amoon.aviv.realestate.presentation.viewmodels.DetailScreenViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class DetailedScreenUITest {

    // The MainScreenViewModel instance to be tested
    private lateinit var detailsScreenViewModel: DetailScreenViewModel

    // Given: A RealEstatesModel with sample properties
    private val realEstatesList = listOf(
        RealEstatesModel(
            id = 5,
            bedrooms = 0,
            city = "Berlin",
            area = 0,
            url = "",
            price = 1500000,
            professional = "",
            propertyType = "Maison - Villa",
            offerType = 0,
            rooms = 0
        )
    )


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        // Create the MainScreenViewModel with the mocked use case
        detailsScreenViewModel = DetailScreenViewModel()
    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testDetailedScreenContent() {

        // When: Composing the DetailedScreen
        composeTestRule.setContent {
            DetailedScreen(
                modifier = Modifier,
                detailedViewModel = detailsScreenViewModel,
                onShareClicked = {  },
                detailParams = DetailParams(realEstatesList)
            )
        }

        // Then: Verify the content in the DetailedScreen
        composeTestRule.onNodeWithText("Berlin", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("1500000", useUnmergedTree = true).assertIsDisplayed()

    }
}
