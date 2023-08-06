package com.amoon.aviv.realestate.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AreaChart
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amoon.aviv.realestate.R
import com.amoon.aviv.realestate.presentation.screens.navigationparams.DetailParams
import com.amoon.aviv.realestate.presentation.viewmodels.DetailScreenViewModel
import com.amoon.aviv.realestate.ui.theme.SettingsBackground
import com.amoon.aviv.realestate.ui.theme.WhiteBackground
import com.amoon.aviv.realestate.ui.utils.DEFAULT_IMAGE
import com.amoon.aviv.realestate.ui.utils.loadPicture

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailedScreen(
    modifier: Modifier,
    detailedViewModel: DetailScreenViewModel = hiltViewModel(),
    onShareClicked: (String) -> Unit,
    onBackClicked: () -> Unit,
    detailParams: DetailParams
) {
    detailedViewModel.initParams(detailParams = detailParams)
    val pageState = rememberPagerState(initialPage = detailedViewModel.realEstateId)
    val listRealEstate = detailedViewModel.listRealEstateModel.collectAsState()

    Scaffold(topBar = {
        DetailedTopAppBar(
            modifier = modifier,
            title = detailedViewModel.pageTitle,
            onShareClicked = {
                onShareClicked(listRealEstate.value[detailedViewModel.realEstateId].url)
            },
            onBackClicked = {
                onBackClicked()
            }
        )

    }) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(SettingsBackground),
            contentAlignment = Alignment.TopCenter
        ) {
            HorizontalPager(
                pageCount = listRealEstate.value.size,
                state = pageState,
                key = { index -> listRealEstate.value[index].id },
            ) { id ->

                Column(

                ) {
                    detailedViewModel.realEstateId = id
                    val image = listRealEstate.value[id].url.let { img ->
                        loadPicture(
                            url = img,
                            defaultImage = DEFAULT_IMAGE
                        ).value
                    }
                    image?.let { img ->
                        Image(
                            bitmap = img.asImageBitmap(),
                            contentDescription = "Images",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp),
                            contentScale = ContentScale.Crop,
                        )
                    }


                    Column(
                        modifier = Modifier
                            .background(WhiteBackground)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                    ) {
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
                                    text = listRealEstate.value[id].area.toString(),
                                    modifier = Modifier
                                        .padding(start = 5.dp)
                                        .align(Alignment.CenterVertically),
                                    style = MaterialTheme.typography.h6,
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
                                    text = listRealEstate.value[id].price.toString(),
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically),
                                    style = MaterialTheme.typography.h6,
                                    color = Color.Black
                                )
                            }
                        }

                        Text(
                            text = stringResource(
                                R.string.property_type,
                                listRealEstate.value[id].propertyType
                            ),
                            modifier = Modifier
                                .padding(top = 20.dp, start = 5.dp),
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black
                        )



                        Text(
                            text = stringResource(R.string.room, listRealEstate.value[id].rooms),
                            modifier = Modifier
                                .padding(top = 20.dp,start = 5.dp),
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black
                        )


                        Text(
                            text = stringResource(
                                R.string.bedroom,
                                listRealEstate.value[id].bedrooms
                            ),
                            modifier = Modifier
                                .padding(top = 20.dp,start = 5.dp),
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun DetailedTopAppBar(
    modifier: Modifier,
    title: String,
    onShareClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    onBackClicked()
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = stringResource(R.string.back)
                )
            }
        },
        title = {
            Text(
                text = title,
                fontSize = 24.sp, color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        },
        actions = {
            IconButton(onClick = {
                onShareClicked()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_share),
                    contentDescription = stringResource(R.string.share_item)
                )
            }
        },
        backgroundColor = Color.Black,
        elevation = 8.dp,
        contentColor = Color.White
    )
}


