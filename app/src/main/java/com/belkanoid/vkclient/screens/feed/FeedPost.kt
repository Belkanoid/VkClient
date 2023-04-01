package com.belkanoid.vkclient.screens.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.belkanoid.vkclient.domain.feed.PostEntity
import com.belkanoid.vkclient.domain.feed.PostStatistics
import com.belkanoid.vkclient.screens.components.IconWithText
import com.belkanoid.vkclient.screens.components.noIndicationClickable
import com.belkanoid.vkclient.ui.theme.VkClientTheme

@Composable
fun FeedPost(
    modifier: Modifier = Modifier,
    postData: PostEntity,
    onLikeClick: (Int) -> Unit,
    onCommentClick: (Int) -> Unit,
    onShareClick: (Int) -> Unit
) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column {
            FeedHeader(
                communityName = postData.postCommunityName,
                postDate = postData.postDate
            )
            FeedContent(
                postText = postData.postText,
                imageResId = postData.postImageResId
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
    postStatistics: PostStatistics,
    onLikeClick: (Int)->Unit,
    onCommentClick: (Int)->Unit,
    onShareClick: (Int)->Unit,
) {
    val backgroundColor = Color(235, 237, 240)
    val likes = postStatistics.likes
    val comments = postStatistics.comments
    val shares = postStatistics.shares
    val views = postStatistics.views

    Row(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {

            IconWithText(
                modifier = Modifier.noIndicationClickable {
                    onLikeClick(likes)
                },
                iconResId = R.drawable.ic_like_outline_16,
                text = likes.toString(),
                backgroundColor = backgroundColor
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconWithText(
                modifier = Modifier.noIndicationClickable {
                    onCommentClick(comments)
                },
                iconResId = R.drawable.ic_comment_outline_16,
                text = comments.toString(),
                backgroundColor = backgroundColor
            )
            Spacer(modifier = Modifier.width(8.dp))

            IconWithText(
                modifier = Modifier.noIndicationClickable {
                    onShareClick(shares)
                },
                iconResId = R.drawable.ic_share_outline_20,
                text = shares.toString(),
                backgroundColor = backgroundColor
            )
        }

        Row(
            horizontalArrangement = Arrangement.End
        ) {
            IconWithText(
                iconResId = R.drawable.ic_view_16,
                text = views.toString(),
            )
        }
    }
}


@Preview
@Composable
fun PreviewLight() {
    VkClientTheme(darkTheme = false) {
        FeedPost(
            postData = PostEntity(),
            onLikeClick = {},
            onCommentClick = {},
            onShareClick = {}
        )
    }
}

@Preview
@Composable
fun PreviewDark() {
    VkClientTheme(darkTheme = true) {
        FeedPost(
            postData = PostEntity(),
            onLikeClick = {},
            onCommentClick = {},
            onShareClick = {}
        )
    }
}
