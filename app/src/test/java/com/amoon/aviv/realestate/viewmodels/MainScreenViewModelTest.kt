import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amoon.aviv.realestate.DispatcherProvider
import com.amoon.aviv.realestate.utils.MainCoroutineRule
import com.amoon.aviv.realestate.utils.TestDispatcherProvider
import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.presentation.viewmodels.MainScreenViewModel
import com.amoon.aviv.realestate.usecases.FakeRealEstatesListingUseCase
import com.nhaarman.mockito_kotlin.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainScreenViewModelTest {

    // Use InstantTaskExecutorRule to enable work with test coroutines
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    // Mock the RealEstatesListingUseCase dependency
    @Mock
    private lateinit var mockRealEstatesListingUseCase: FakeRealEstatesListingUseCase


    // The MainScreenViewModel instance to be tested
    private lateinit var mainScreenViewModel: MainScreenViewModel

    private lateinit var dispatcherProvider: DispatcherProvider


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        dispatcherProvider = TestDispatcherProvider()

        // Create the MainScreenViewModel with the mocked use case
        mainScreenViewModel = MainScreenViewModel(mockRealEstatesListingUseCase)
    }


    @Test
    fun `Testing a RealEstatesModel state flow`() = runTest {

        // Given: A value to emit
        val _intSharedFlow = MutableStateFlow(
            RealEstatesModel(
                id = 5,
                bedrooms = 0,
                city = "",
                area = 0,
                url = "",
                price = 0,
                professional = "",
                propertyType = "",
                offerType = 0,
                rooms = 0
            )
        )
        val intSharedFlow = _intSharedFlow.asStateFlow()
        val testResults = mutableListOf<RealEstatesModel>()

        // Emitting the new value
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            intSharedFlow.toList(testResults)
        }


        _intSharedFlow.value = RealEstatesModel(
            id = 1,
            bedrooms = 0,
            city = "Berlin",
            area = 0,
            url = "",
            price = 0,
            professional = "",
            propertyType = "",
            offerType = 0,
            rooms = 0
        )

        // Then: The testResults should emit the correct value
        assertEquals(2, testResults.size)
        assertEquals(5, testResults.first().id)
        assertEquals("Berlin", testResults.last().city)
    }


    @Test
    fun `listRealStates should emit correct value to listingState`() = runTest {
        // Given: A value to emit
        val realEstateMocksList = mock<List<RealEstatesModel>>()
        val fakeValues = mutableListOf("Berlin")

        // When: Calling listRealStates method
        `when`(mockRealEstatesListingUseCase.listRealEstates()).thenReturn(
            flow {
                emit(realEstateMocksList)
            }
        )

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            mainScreenViewModel.listingState.toList(fakeValues)
        }

        mainScreenViewModel.listRealStates()

        // Then: The listingState should emit the correct value
        assertEquals("Berlin", fakeValues[0])
        assertEquals(2, fakeValues.size)
    }

}
