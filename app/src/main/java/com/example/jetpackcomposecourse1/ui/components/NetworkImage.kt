package com.example.jetpackcomposecourse1.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.example.jetpackcomposecourse1.R

@Composable
fun NetworkImage(
    url: String,
    author: String,
    modifier: Modifier
) {
    Box(modifier = modifier) {
        val painter = rememberImagePainter(data = url, builder = {
            placeholder(R.drawable.place_holder)
            crossfade(true)
        })

        Image(
            painter = painter,
            contentDescription = author,
            contentScale = ContentScale.None,
            modifier = modifier.fillMaxSize()
        )
    }
}