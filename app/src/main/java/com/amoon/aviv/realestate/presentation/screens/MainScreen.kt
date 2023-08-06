package com.amoon.aviv.realestate.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amoon.aviv.realestate.R
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.presentation.screens.navigationparams.DetailParams
import com.amoon.aviv.realestate.presentation.screens.screencomponents.ListVerticalGrid
import com.amoon.aviv.realestate.presentation.viewmodels.MainScreenViewModel
import com.amoon.aviv.realestate.presentation.viewmodels.ScreenState
import com.amoon.aviv.realestate.ui.theme.WhiteBackground
import kotlinx.coroutines.coroutineScope

@Composable
fun MainScreen(
    modifier: Modifier,
    mainViewModel: MainScreenViewModel = hiltViewModel(),
    onDetailedClicked: (DetailParams) -> Unit
) {
    val screenState = mainViewModel.screenState.collectAsState()
    when (screenState.value) {
        is ScreenState.Success -> {
            val listRealEstate = (screenState.value as ScreenState.Success<RealEstatesModel>).value

            if (listRealEstate.isNotEmpty()) {

                mainViewModel.listRealStates()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = stringResource(R.string.app_name)
                        )
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .background(WhiteBackground),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        Box(
                            modifier = modifier.weight(1f),
                            contentAlignment = Alignment.TopCenter
                        ) {

                            ListVerticalGrid(
                                modifier = Modifier,
                                listRealEstates = listRealEstate,
                                onDetailedClicked = { index ->
                                    onDetailedClicked(
                                        DetailParams(
                                            list = listRealEstate,
                                            index = index,
                                            title = mainViewModel.listRealStates.value
                                        )
                                    )
                                },
                                initStar = false
                            )
                        }
                    }
                }
            } else {
                val errorMessage = stringResource(R.string.something_went_wrong)
                ErrorScreen(message = errorMessage,
                    onClickRetry = {
                        mainViewModel.listRealStates()
                    })
            }
        }

        is ScreenState.Loading -> {
            LoadingScreen()
        }

        else -> {}
    }

}


@Composable
fun TopAppBar(
    title: String,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 24.sp, color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        },
        backgroundColor = Color.Black,
        elevation = 8.dp,
        contentColor = Color.White
    )
}


