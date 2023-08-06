package com.amoon.aviv.realestate.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.presentation.screens.navigationparams.DetailParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor() : ViewModel() {
    var pageTitle = ""
        private set
    var realEstateId: Int = 0
    val _listRealEstateModel = MutableStateFlow<List<RealEstatesModel>>(emptyList())
    val listRealEstateModel: StateFlow<List<RealEstatesModel>> = _listRealEstateModel


    fun initParams(detailParams: DetailParams) {
        pageTitle = detailParams.list[detailParams.index].city
        realEstateId = detailParams.index
        _listRealEstateModel.value = detailParams.list
    }

}