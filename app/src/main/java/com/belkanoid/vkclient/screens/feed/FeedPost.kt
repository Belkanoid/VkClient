package com.belkanoid.vkclient.screens.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belkanoid.vkclient.R
import com.belkanoid.vkclient.screens.components.IconWithText
import com.belkanoid.vkclient.ui.theme.VkClientTheme

@Composable
fun FeedPost() {
    Card(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column {
            FeedHeader()
            FeedContent()
            FeedStatistics()
        }
    }
}
@Composable
private fun FeedHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp),
            painter = painterResource(id = R.drawable.ic_community_image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "innocence",
                color = MaterialTheme.colors.onPrimary,
            )
            Text(
                text = "7 Dec 2023",
                color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
private fun FeedContent() {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "ты всего лишь облик под видом человека",
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colors.onPrimary
    )
    Spacer(modifier = Modifier.height(8.dp))

    Image(
        painter = painterResource(id = R.drawable.ic_post_image),
        modifier = Modifier.fillMaxWidth(),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun FeedStatistics(

) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            val color = Color(235, 237, 240)
            IconWithText(
                iconResId = R.drawable.ic_like_outline_16,
                text = "403",
                backgroundColor = color
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconWithText(
                iconResId = R.drawable.ic_comment_outline_16,
                text = "44",
                backgroundColor = color
            )
            Spacer(modifier = Modifier.width(8.dp))

            IconWithText(
                iconResId = R.drawable.ic_share_outline_20,
                text = "63",
                backgroundColor = color
            )
        }

        Row(
            horizontalArrangement = Arrangement.End
        ) {
            IconWithText(
                iconResId = R.drawable.ic_view_16,
                text = "38,2K",
            )
        }
    }
}


@Preview
@Composable
fun PreviewLight() {
    VkClientTheme(darkTheme = false) {
        FeedPost()
    }
}

@Preview
@Composable
fun PreviewDark() {
    VkClientTheme(darkTheme = true) {
        FeedPost()
    }
}
