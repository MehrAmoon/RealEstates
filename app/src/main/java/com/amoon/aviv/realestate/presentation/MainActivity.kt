package com.amoon.aviv.realestate.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.amoon.aviv.realestate.presentation.screens.HomeScreen
import com.amoon.aviv.realestate.ui.theme.RealEstatesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealEstatesTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray
                ) {
                    HomeScreen(onShareClicked = {url->
                        shareRealEstate(url)
                    })
                }
            }
        }
    }
    private fun shareRealEstate(realEstateUrl: String) {
        val realStates = "Real State"
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, realStates)
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            realEstateUrl
        )
        startActivity(Intent.createChooser(shareIntent, realStates))
    }
}

