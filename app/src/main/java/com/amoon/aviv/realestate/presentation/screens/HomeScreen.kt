package com.amoon.aviv.realestate.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amoon.aviv.realestate.presentation.screens.navigationparams.*

@Composable
fun HomeScreen(onShareClicked: (String) -> Unit) {
    val navController = rememberNavController()
    Scaffold() {
        Box(Modifier.padding(bottom = it.calculateBottomPadding())) {
            NavHost(navController = navController, startDestination = Screens.MAIN.route) {
                composable(Screens.MAIN.route) {
                    MainScreen(
                        modifier = Modifier,
                        onDetailedClicked = { detailParams ->
                            navController.navigate(Screens.DETAILED.route, detailParams.toBundle())
                        })
                }
                composable(Screens.DETAILED.route) { host ->
                    val detailParams = host.arguments?.toDetailParams()!!
                    DetailedScreen(
                        modifier = Modifier,
                        onShareClicked = { url -> onShareClicked(url) },
                        onBackClicked = {navController.navigateUp()} ,
                        detailParams = detailParams
                    )
                }
            }
        }
    }
}

