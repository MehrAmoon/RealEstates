package com.amoon.aviv.realestate.usecases

import com.amoon.aviv.realestate.domain.models.RealEstatesModel
import com.amoon.aviv.realestate.domain.repositores.DatabaseRepository
import com.amoon.aviv.realestate.domain.usecases.DatabaseUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class DatabaseUseCaseTest {

    // Mock the DatabaseRepository dependency
    @Mock
    private lateinit var mockDatabaseRepository: DatabaseRepository

    // The DatabaseUseCase instance to be tested
    private lateinit var databaseUseCase: DatabaseUseCase

    @Before
    fun setUp() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this)

        // Create the DatabaseUseCase with the mocked repository
        databaseUseCase = DatabaseUseCase(mockDatabaseRepository)
    }

    @Test
    fun `getAll should return flow of RealEstatesModel list`() = runBlocking {
        // Given: A list of RealEstatesModel returned from the repository
        val realEstatesList = listOf(
            RealEstatesModel(),
            RealEstatesModel()
        )

        // When: Calling the getAll() method on the use case
        `when`(mockDatabaseRepository.getAll()).thenReturn(flowOf(realEstatesList))
        val result = databaseUseCase.getAll()

        // Then: The result should match the expected list
        assertEquals(realEstatesList, result.first())
    }

    @Test
    fun `insert should call repository insert method`() = runBlocking {
        // Given: A RealEstatesModel object to insert
        val realEstatesModel = RealEstatesModel()

        // When: Calling the insert method on the use case
        databaseUseCase.insert(realEstatesModel)

        // Then: The repository's insert method should be called with the same object
         verify(mockDatabaseRepository).insert(realEstatesModel)
    }
}
