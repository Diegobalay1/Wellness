package com.dlolhd.a30daysofwellness.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dlolhd.a30daysofwellness.R
import com.dlolhd.a30daysofwellness.WellnessAppViewModelProvider
import com.dlolhd.a30daysofwellness.ui.view.WellnessScreen
import com.dlolhd.a30daysofwellness.ui.view.WellnessViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessApp() {
    Scaffold(
        topBar = { WellnessTopAppBar() }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val wellnessViewModel: WellnessViewModel =
                viewModel(factory = WellnessAppViewModelProvider.Factory)
            WellnessScreen(
                wellnessUiState = wellnessViewModel.wellnessUiState,
                retryAction = wellnessViewModel::getAllCuriosities
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge
        ) },
        modifier = modifier
    )
}