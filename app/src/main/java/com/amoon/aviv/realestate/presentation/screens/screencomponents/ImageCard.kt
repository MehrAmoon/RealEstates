package com.amoon.aviv.realestate.presentation.screens.screencomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.ui.theme.GRAY_TRANSPARENT
import com.amoon.aviv.realestate.ui.theme.Purple500
import com.amoon.aviv.realestate.ui.utils.DEFAULT_IMAGE
import com.amoon.aviv.realestate.ui.utils.loadPicture
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally

@Composable
fun ImageCard(
    realEstates: RealEstatesModel,
    onDetailedClicked: (RealEstatesModel) -> Unit,
    initStar: Boolean
) {
    val starState = remember {
        mutableStateOf(initStar)
    }
    LaunchedEffect(realEstates) {
        starState.value = initStar
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(460.dp)
        .padding(top = 5.dp, bottom = 5.dp)
        .border(
            BorderStroke(1.dp, Purple500),
            RoundedCornerShape(15.dp)
        )
        .clickable {
            onDetailedClicked(realEstates)
        }
        .clip(RoundedCornerShape(15.dp)), contentAlignment = Alignment.TopEnd)
    {

        Column(

        ) {

            val image = realEstates.url.let {
                loadPicture(
                    url = it,
                    defaultImage = DEFAULT_IMAGE
                ).value
            }
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "Images",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = Modifier
                    .background(GRAY_TRANSPARENT)
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .align(CenterHorizontally)
                ) {

                    Icon(
                        imageVector = Icons.Rounded.Room,
                        contentDescription = "Icon",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .wrapContentHeight(Alignment.CenterVertically),
                        tint = Color.Black
                    )
                    Text(
                        text = realEstates.city,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h6,
                        color = Color.Black
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                            .weight(2f)
                    ) {

                        Icon(
                            imageVector = Icons.Rounded.Apartment,
                            contentDescription = "Icon",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .wrapContentHeight(Alignment.CenterVertically),
                            tint = Color.Black
                        )
                        Text(
                            text = realEstates.propertyType.toString(),
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.body1,
                            color = Color.Black
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 20.dp)
                            .weight(1f)
                    ) {

                        Icon(
                            imageVector = Icons.Rounded.RoomPreferences,
                            contentDescription = "Icon",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .wrapContentHeight(Alignment.CenterVertically),
                            tint = Color.Black
                        )
                        Text(
                            text = realEstates.rooms.toString(),
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.body1,
                            color = Color.Black
                        )
                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 60.dp)
                            .weight(2f)
                    ) {

                        Icon(
                            imageVector = Icons.Rounded.BedroomParent,
                            contentDescription = "Icon",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .wrapContentHeight(Alignment.CenterVertically),
                            tint = Color.Black
                        )
                        Text(
                            text = realEstates.bedrooms.toString(),
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.body1,
                            color = Color.Black
                        )
                    }
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                            .weight(2f)
                    ) {

                        Icon(
                            imageVector = Icons.Rounded.AreaChart,
                            contentDescription = "Icon",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .wrapContentHeight(Alignment.CenterVertically),
                            tint = Color.Black
                        )
                        Text(
                            text = realEstates.area.toString(),
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.body1,
                            color = Color.Black
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 10.dp)
                            .weight(1f)
                    ) {

                        Icon(
                            imageVector = Icons.Rounded.AttachMoney,
                            contentDescription = "Icon",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .wrapContentHeight(Alignment.CenterVertically),
                            tint = Color.Black
                        )
                        Text(
                            text = realEstates.price.toString(),
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.body1,
                            color = Color.Black
                        )
                    }
                }

            }
        }
    }
}