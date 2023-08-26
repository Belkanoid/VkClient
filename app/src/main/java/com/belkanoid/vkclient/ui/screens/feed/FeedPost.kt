package com.belkanoid.vkclient.ui.screens.feed

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
import com.belkanoid.vkclient.domain.feed.FeedEntity
import com.belkanoid.vkclient.domain.feed.PostStatistics
import com.belkanoid.vkclient.domain.feed.StatisticsType
import com.belkanoid.vkclient.domain.feed.getItemByType
import com.belkanoid.vkclient.ui.components.IconWithText
import com.belkanoid.vkclient.ui.theme.VkClientTheme

@Composable
fun FeedPost(
    modifier: Modifier = Modifier,
    postData: FeedEntity,
    onLikeClick: (PostStatistics) -> Unit,
    onCommentClick: (PostStatistics) -> Unit,
    onShareClick: (PostStatistics) -> Unit
) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column {
            FeedHeader(
                communityName = postData.postCommunityName,
                postDate = postData.postDate,
            )
            FeedContent(
                postText = postData.postText,
                imageResId = postData.postImageResId,
            )
            FeedStatistics(
                postStatistics = postData.postStatistics,
                onLikeClick = onLikeClick,
                onCommentClick = onCommentClick,
                onShareClick = onShareClick
            )
        }
    }
}
@Composable
private fun FeedHeader(
    communityName: String,
    postDate: Long,
) {
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
                text = communityName,
                color = MaterialTheme.colors.onPrimary,
            )
            Text(
                text = postDate.toString(),
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
private fun FeedContent(
    postText: String,
    imageResId: Int,
) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = postText,
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colors.onPrimary
    )

    Spacer(modifier = Modifier.height(8.dp))
    Image(
        painter = painterResource(id = imageResId),
        modifier = Modifier.fillMaxWidth(),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun FeedStatistics(
    postStatistics: List<PostStatistics>,
    onLikeClick: (PostStatistics)->Unit,
    onCommentClick: (PostStatistics)->Unit,
    onShareClick: (PostStatistics)->Unit,
) {
    val backgroundColor = Color(235, 237, 240)

    Row(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            val likes = postStatistics.getItemByType(StatisticsType.LIKE)
            val comments = postStatistics.getItemByType(StatisticsType.COMMENT)
            val shares = postStatistics.getItemByType(StatisticsType.SHARE)
            IconWithText(
                iconResId = R.drawable.ic_like_outline_16,
                text = likes.value.toString(),
                backgroundColor = backgroundColor,
                onClick =  {
                    onLikeClick(likes)
                }
            )

            Spacer(modifier = Modifier.width(8.dp))
            IconWithText(
                iconResId = R.drawable.ic_comment_outline_16,
                text = comments.value.toString(),
                backgroundColor = backgroundColor,
                onClick = {
                    onCommentClick(comments)
                }

            )

            Spacer(modifier = Modifier.width(8.dp))
            IconWithText(
                iconResId = R.drawable.ic_share_outline_20,
                text = shares.value.toString(),
                backgroundColor = backgroundColor,
                onClick = {
                    onShareClick(shares)
                }
            )
        }
        Row(
            horizontalArrangement = Arrangement.End
        ) {
            val views = postStatistics.getItemByType(StatisticsType.LIKE)
            IconWithText(
                iconResId = R.drawable.ic_view_16,
                text = views.value.toString(),
                onClick = {

                }
            )
        }
    }
}


@Preview
@Composable
fun PreviewLight() {
    VkClientTheme(darkTheme = false) {
        FeedPost(
            postData = FeedEntity(),
            onLikeClick = {},
            onCommentClick = {},
            onShareClick = {},
        )
    }
}

@Preview
@Composable
fun PreviewDark() {
    VkClientTheme(darkTheme = true) {
        FeedPost(
            postData = FeedEntity(),
            onLikeClick = {},
            onCommentClick = {},
            onShareClick = {},
        )
    }
}
