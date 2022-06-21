package com.example.jetpackcomposecourse1.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposecourse1.R
import com.example.jetpackcomposecourse1.common.Response
import com.example.jetpackcomposecourse1.data.domain.Image
import com.example.jetpackcomposecourse1.data.repository.ImageRepository
import com.example.jetpackcomposecourse1.ui.components.ImageListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val repo: ImageRepository
) : ViewModel() {

    private val _imageListState = mutableStateOf(ImageListState())
    val imageListState: State<ImageListState> = _imageListState

    init {
        getImages()
    }

    private fun getImages(){
        repo.getAllImages().onEach { response ->
            when (response) {
                is Response.Loading -> _imageListState.value = ImageListState(isLoading = true)
                is Response.Success -> _imageListState.value =
                    ImageListState(images = response.data ?: emptyList())
                is Response.Error -> _imageListState.value =
                    ImageListState(error = response.message ?: "")

            }
        }.launchIn(viewModelScope)
    }

}