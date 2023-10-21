package com.dlolhd.a30daysofwellness.ui.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dlolhd.a30daysofwellness.model.Curiosity
import com.dlolhd.a30daysofwellness.model.WellnessRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * UI state for the Wellness screen
 */
sealed interface WellnessUiState {
    data class Success(val curiosities: List<Curiosity>) : WellnessUiState
    object Error : WellnessUiState
    object Loading : WellnessUiState
}

class WellnessViewModel(
    private val wellnessRepository: WellnessRepository
) : ViewModel() {
    /**
     * The mutable State that stores the status of the most recent request
     */
    var wellnessUiState: WellnessUiState by mutableStateOf(WellnessUiState.Loading)
        private set

    /**
     * Call getAllCuriosities() on init so we can display status immediately.
     */
    init {
        getAllCuriosities()
    }

    fun getAllCuriosities() {
        viewModelScope.launch {
            wellnessUiState = WellnessUiState.Loading
            delay(250)
            wellnessUiState = try {
                val listResult = wellnessRepository.getAllItems()
                WellnessUiState.Success(listResult)
            } catch (e: IOException) {
                WellnessUiState.Error
            } catch (e: Exception) {
                WellnessUiState.Error
            }
        }
    }
}









