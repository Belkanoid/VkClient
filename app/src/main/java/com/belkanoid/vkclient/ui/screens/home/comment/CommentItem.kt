package com.belkanoid.vkclient.ui.screens.home.comment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belkanoid.vkclient.domain.comment.CommentEntity
import com.belkanoid.vkclient.ui.theme.VkClientTheme

@Composable
fun CommentItem(
    modifier: Modifier = Modifier,
    comment: CommentEntity
) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 0.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = comment.author)
                Text(text = comment.text)
                Text(text = comment.date, color = MaterialTheme.colors.onSecondary)
            }
        }
    }
}

@Preview()
@Composable
fun PreviewComment() {
   VkClientTheme(
       darkTheme = false
   ) {
       CommentItem(
           comment = CommentEntity()
       )
   }
}

@Preview()
@Composable
fun PreviewDarkComment() {
    VkClientTheme(
        darkTheme = true
    ) {
        CommentItem(
            comment = CommentEntity()
        )
    }
}