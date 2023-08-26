package com.belkanoid.vkclient.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belkanoid.vkclient.R

@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    iconResId: Int,
    text: String,
    backgroundColor: Color = Color.Unspecified,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.noIndicationClickable {
            onClick()
        },
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(45),
        elevation = 0.dp

    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = iconResId),
                contentDescription = null,
                tint = MaterialTheme.colors.onSecondary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = text,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}

@Preview
@Composable
fun PreviewWithBackground() {
    IconWithText(
        iconResId = R.drawable.ic_like_outline_16,
        text = "544",
        backgroundColor = Color.White.copy(alpha = 0.8f)
    ) {

    }
}

@Preview
@Composable
fun PreviewWithoutBackground() {
    IconWithText(
        iconResId = R.drawable.ic_like_outline_16,
        text = "544",
    ) {

    }
}

