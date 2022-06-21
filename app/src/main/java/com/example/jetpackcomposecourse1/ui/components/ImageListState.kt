package com.example.jetpackcomposecourse1.ui.components

import com.example.jetpackcomposecourse1.data.domain.Image

data class ImageListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val images: List<Image> = emptyList()
)