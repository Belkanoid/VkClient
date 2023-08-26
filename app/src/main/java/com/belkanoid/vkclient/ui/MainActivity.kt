package com.belkanoid.vkclient.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.belkanoid.vkclient.ui.screens.main.MainScreen
import com.belkanoid.vkclient.ui.theme.VkClientTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkClientTheme {
                MainScreen(viewModel)
            }
        }
    }
}