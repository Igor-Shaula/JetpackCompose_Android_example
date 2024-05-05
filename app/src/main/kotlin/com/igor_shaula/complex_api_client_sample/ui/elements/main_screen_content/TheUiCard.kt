package com.igor_shaula.complex_api_client_sample.ui.elements.main_screen_content

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.models.TheUiModel
import com.igor_shaula.complex_api_client_sample.ui.theme.DEFAULT_PADDING
import com.igor_shaula.complex_api_client_sample.ui.theme.IMAGE_HEIGHT
import com.igor_shaula.complex_api_client_sample.ui.theme.IMAGE_WIDTH
import com.igor_shaula.complex_api_client_sample.ui.theme.SMALL_ELEVATION
import com.igor_shaula.complex_api_client_sample.ui.theme.TINY_ELEVATION
import com.igor_shaula.complex_api_client_sample.ui.theme.TINY_PADDING

@Composable
fun TheUiCard(theUiModel: TheUiModel) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = SMALL_ELEVATION),
        shape = MaterialTheme.shapes.small,
//        modifier = Modifier.padding(
//            bottom = DEFAULT_PADDING // 2dp - for top shadow, white on white!
//        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            AsyncImage(
                model = theUiModel.image,
                placeholder = painterResource(
                    id = if (isSystemInDarkTheme()) {
                        R.drawable.placeholder_loading_dark
                    } else {
                        R.drawable.placeholder_loading
                    }
                ),
                error = painterResource(
                    id = if (isSystemInDarkTheme()) {
                        R.drawable.placeholder_no_picture_dark
                    } else {
                        R.drawable.placeholder_no_picture
                    }
                ),
                contentDescription = stringResource(id = R.string.vehicleImageDescription),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(IMAGE_HEIGHT)
                    .width(IMAGE_WIDTH)
                    .padding(all = TINY_PADDING)
                    .shadow(shape = MaterialTheme.shapes.extraSmall, elevation = TINY_ELEVATION)
            )
            Text(
                text = theUiModel.name,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                modifier = Modifier.padding(start = DEFAULT_PADDING, end = DEFAULT_PADDING)
            )
        }
    }
}
