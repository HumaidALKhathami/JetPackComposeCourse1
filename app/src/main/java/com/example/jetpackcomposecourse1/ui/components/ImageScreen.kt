package com.example.jetpackcomposecourse1.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposecourse1.ui.ImagesViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageScreen(viewModel: ImagesViewModel = hiltViewModel()) {
    val imagesListState = viewModel.imageListState.value

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {

        when {
            imagesListState.isLoading -> {
                Box(contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            imagesListState.error.isNotEmpty() -> {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = imagesListState.error)
                }
            }
            imagesListState.images.isNotEmpty() -> {
                LazyVerticalGrid(cells = GridCells.Adaptive(150.dp)) {
                    item(span = { GridItemSpan(4) }) {
                        Column(
                            modifier = Modifier
                                .size(200.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "New Image")
                            Icon(Icons.Default.Add, contentDescription = "New Image")
                        }
                    }
                    itemsIndexed(imagesListState.images) { index, image ->
                        ImageCard(index = index, image = image)
                    }
                }
            }
        }
    }

}