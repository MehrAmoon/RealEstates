package com.amoon.aviv.realestate.screencomponents

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.presentation.screens.screencomponents.ImageCard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ImageCardUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testImageCardContent() {
        // Given: A RealEstatesModel with sample properties
        val realEstate = RealEstatesModel()

        // When: Composing the ImageCard
        composeTestRule.setContent {
            ImageCard(
                realEstates = realEstate,
                onDetailedClicked = {},
                initStar = false
            )
        }

        // Then: Verify the content in the ImageCard
        composeTestRule.onNodeWithText(realEstate.city).assertIsDisplayed()
        composeTestRule.onNodeWithText(realEstate.propertyType).assertIsDisplayed()
        composeTestRule.onNodeWithText(realEstate.rooms.toString()).assertIsDisplayed()
        composeTestRule.onNodeWithText(realEstate.bedrooms.toString()).assertIsDisplayed()
        composeTestRule.onNodeWithText(realEstate.area.toString()).assertIsDisplayed()
        composeTestRule.onNodeWithText(realEstate.price.toString()).assertIsDisplayed()
    }
}
