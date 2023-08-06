package com.amoon.aviv.realestate.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.usecases.RealEstatesListingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.amoon.aviv.realestate.presentation.viewmodels.ScreenState.*
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val realEstatesListingUseCase: RealEstatesListingUseCase
) :
    ViewModel() {

    val listRealStates = mutableStateOf(" ")

    val listingState = MutableStateFlow("")

    val screenState: StateFlow<ScreenState<RealEstatesModel>> = listingState
        .flatMapLatest {
            realEstatesListingUseCase
                .listRealEstates()
                .map<List<RealEstatesModel>, ScreenState<RealEstatesModel>>(::Success)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(500), Loading)

    fun listRealStates() = viewModelScope.launch {
        listingState.emit(listRealStates.value)
    }
}