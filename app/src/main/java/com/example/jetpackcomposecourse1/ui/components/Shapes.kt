package com.example.jetpackcomposecourse1.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape

@Composable
fun shapes(index: Int): Shape {
    return if (index % 2 == 0) {
        MaterialTheme.shapes.small
    } else {
        MaterialTheme.shapes.medium
    }
}