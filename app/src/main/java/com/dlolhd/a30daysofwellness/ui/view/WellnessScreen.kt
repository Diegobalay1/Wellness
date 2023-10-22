package com.dlolhd.a30daysofwellness.ui.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier,
        //colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                //.sizeIn(minHeight = 300.dp)
        ) {
            //Column(Modifier.fillMaxWidth()) {
            Column(Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(id = curiosity.day),
                    style = MaterialTheme.typography.displayLarge
                )
                WellnessTitle(curiosity.title, modifier = Modifier)
                WellnessImageCard(
                    imgRes = curiosity.imgRes,
                    title = curiosity.title,
                    expanded = expanded,
                    onClick = {
                        expanded = !expanded
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.image_size))
                )
            }
            if (expanded) {
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
fun WellnessImageCard(
    @DrawableRes imgRes: Int,
    @StringRes title: Int,
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Image(
            modifier = modifier
                .clip(MaterialTheme.shapes.large),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = imgRes),
            alpha = if (expanded) 0.5f else 1f,
            contentDescription = stringResource(id = title)
        )
    }
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
