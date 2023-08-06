package com.amoon.aviv.realestate.screencomponents

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.presentation.screens.screencomponents.ListVerticalGrid
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListVerticalGridUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testListVerticalGridContent() {
        // Given: A list of RealEstatesModel with sample properties
        val realEstatesList = listOf(
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
                id = 7,
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

        // When: Composing the ListVerticalGrid
        composeTestRule.setContent {
            ListVerticalGrid(
                modifier = Modifier,
                listRealEstates = realEstatesList,
                onDetailedClicked = { },
                initStar = false
            )
        }

        // Then: Verify the content in the ListVerticalGrid
        for ((index, _) in realEstatesList.withIndex()) {
            // Verify each ImageCard in the grid
            composeTestRule.onNodeWithText(realEstatesList[index].city).assertIsDisplayed()
        }
    }
}
