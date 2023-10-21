package com.dlolhd.a30daysofwellness.ui.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dlolhd.a30daysofwellness.R
import com.dlolhd.a30daysofwellness.model.Curiosity

@Composable
fun WellnessScreen(
    wellnessUiState: WellnessUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (wellnessUiState) {
        is WellnessUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is WellnessUiState.Success -> SuccessScreen(curiosities = wellnessUiState.curiosities, modifier = modifier)
        is WellnessUiState.Error -> ErrorScreen(retryAction = retryAction, modifier = modifier.fillMaxSize())
    }
}

@Composable
fun SuccessScreen(
    curiosities: List<Curiosity>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(curiosities) {
            CuriosityItem(
                curiosity = it,
                modifier = modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun CuriosityItem(
    curiosity: Curiosity,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .sizeIn(minHeight = 300.dp)
        ) {
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = curiosity.day),
                    style = MaterialTheme.typography.displayLarge
                )
                WellnessTitle(curiosity.title, modifier = Modifier)
                /*WellnessImage(
                    curiosity.imgRes,
                    curiosity.title,
                    modifier = Modifier
                )*/
                WellnessImageTwo(
                    imgRes = curiosity.imgRes,
                    title = curiosity.title,
                    modifier = Modifier.fillMaxWidth()
                )
                WellnessDescription(curiosity.description, modifier = Modifier)
            }
        }
    }
}

@Composable
fun WellnessTitle(
    titleRes: Int,
    modifier: Modifier.Companion
) {
    Text(
        text = stringResource(id = titleRes),
        style = MaterialTheme.typography.displayMedium,
        modifier = modifier
    )
}

@Composable
fun WellnessImage(
    @DrawableRes imgRes: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(dimensionResource(id = R.dimen.image_size))
    ) {
        Image(
            modifier = Modifier
                .clip(MaterialTheme.shapes.large),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = imgRes),
            contentDescription = stringResource(id = title)
        )
    }
}
@Composable
fun WellnessImageTwo(
    @DrawableRes imgRes: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .clip(MaterialTheme.shapes.large),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(id = imgRes),
        contentDescription = stringResource(id = title)
    )
}

@Composable
fun WellnessDescription(
    @StringRes descriptionRes: Int,
    modifier: Modifier.Companion
) {
    Text(
        text = stringResource(id = descriptionRes),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}

/**
 * The Wellness screen displaying the loding message.
 */
@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = stringResource(id = R.string.loading)
    )
}

@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier= Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = stringResource(id = R.string.connection_error)
        )
        Text(text = stringResource(id = R.string.loading_failed), modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}
