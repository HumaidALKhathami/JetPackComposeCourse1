package com.example.jetpackcomposecourse1.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetpackcomposecourse1.data.domain.Image

@Composable
fun ImageCard(index: Int, image: Image) {
    Card(
        elevation = 5.dp,
        shape = shapes(index = index),
        modifier = Modifier
            .size(200.dp)
            .padding(8.dp)
    ) {
        Box {
            NetworkImage(url = image.downloadUrl, author = image.author, modifier = Modifier )
            Text(
                text = image.author,
                Modifier
                    .background(MaterialTheme.colors.primary.copy(0.6f))
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}
