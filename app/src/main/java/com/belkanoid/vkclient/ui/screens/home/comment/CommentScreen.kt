package com.belkanoid.vkclient.ui.screens.home.comment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.belkanoid.vkclient.domain.comment.CommentEntity
import com.belkanoid.vkclient.domain.feed.FeedEntity
import com.belkanoid.vkclient.ui.CommentsViewModel

@Composable
fun CommentScreen(
    post: FeedEntity,
    paddingValues: PaddingValues,
    onBackPressed: () -> Unit,
) {

    val viewModel: CommentsViewModel = viewModel()
    val screenState = viewModel.screenState.observeAsState(CommentsScreenState.Initial)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Comments to Post")
                },
                backgroundColor = MaterialTheme.colors.secondary,
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(
                            tint = MaterialTheme.colors.onSecondary,
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "arrow back"
                        )
                    }
                }
            )
        }
    ) {
        when (val currentState = screenState.value) {
            is CommentsScreenState.Initial -> {
                viewModel.loadComments(post)
            }
            is CommentsScreenState.Comment -> {
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = it.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    ),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = currentState.comments,
                        key = { it.id }
                    ) {comment ->
                        CommentItem(comment = comment)
                    }
                }
            }
        }

    }
}


@Preview
@Composable
fun PreviewCommentScreen() {
    CommentScreen(
        post = FeedEntity(),
        paddingValues = PaddingValues(),
        onBackPressed = {}
    )
}



