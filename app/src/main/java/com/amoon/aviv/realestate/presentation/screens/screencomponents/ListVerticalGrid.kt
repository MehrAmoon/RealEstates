package com.amoon.aviv.realestate.presentation.screens.screencomponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amoon.aviv.realestate.domain.models.RealEstatesModel

@Composable
fun ListVerticalGrid(
    modifier: Modifier,
    listRealEstates: List<RealEstatesModel>,
    onDetailedClicked: (Int) -> Unit,
    initStar: Boolean
) {
    val state = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = modifier, columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(15.dp), state = state
    ) {

        itemsIndexed(items = listRealEstates) { index, listData ->

            ImageCard(
                realEstates = listData,
                onDetailedClicked = {
                    onDetailedClicked(index)
                },
                initStar = initStar
            )
        }
    }
}