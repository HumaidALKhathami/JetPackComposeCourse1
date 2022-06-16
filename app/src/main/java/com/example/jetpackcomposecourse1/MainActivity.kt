package com.example.jetpackcomposecourse1

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse1.ui.theme.JetPackComposeCourse1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCourse1Theme {
                window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb()
                GridView(imagesList = imagesList)
            }

        }
    }
}

val imagesList = listOf(
    Image(R.drawable.icymountains, "Glaciers", 1),
    Image(R.drawable.beach, "Beach", 2),
    Image(R.drawable.coffee, "Coffee", 3),
    Image(R.drawable.flowers, "Flowers", 4),
    Image(R.drawable.pink, "Pink", 5),
    Image(R.drawable.planet, "Planet", 6),
    Image(R.drawable.umbrellas, "Umbrellas", 7),
    Image(R.drawable.fog, "Fog", 8)
)
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    GridView(imagesList = imagesList)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridView(imagesList: List<Image>) {

    
        Surface{
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
                itemsIndexed(imagesList) { index, image ->
                    ImageCard(index = index,image = image)
                }
            }
        }
    
}

@Composable
fun ImageCard(index: Int,image: Image) {
    Card(
        elevation = 5.dp,
        shape = shapes(index = index),
        modifier = Modifier
            .size(200.dp)
            .padding(8.dp)
    ) {
        Box {
            Image(
                bitmap = ImageBitmap.imageResource(id = image.resource),
                contentDescription = image.Description,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = image.Description,
                Modifier
                    .background(MaterialTheme.colors.primary.copy(0.6f))
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}

@Composable
fun shapes(index: Int): Shape {
    return if (index %2 ==0 ){
        MaterialTheme.shapes.small
    }else {
        MaterialTheme.shapes.medium
    }
}

//
//@Composable
//fun Greeting(name: String) {
//    JetPackComposeCourse1Theme {
//        Surface(
//            shape = RoundedCornerShape(16.dp),
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            elevation = 10.dp,
//            color = MaterialTheme.colors.surface
//        ) {
//            Box {
//                Card(
//                    elevation = 5.dp,
//                    shape = RoundedCornerShape(10.dp),
//                    modifier = Modifier
//                        .size(170.dp)
//                        .align(
//                            Alignment.TopStart
//                        )
//                ) {
//                    Box {
//                        Image(
//                            bitmap = ImageBitmap.imageResource(id = image1.resource),
//                            contentDescription = image1.Description,
//                            contentScale = ContentScale.Crop,
//                        )
//                        Text(
//                            text = image1.Description,
//                            Modifier
//                                .background(Color.Cyan.copy(0.6f))
//                                .fillMaxWidth()
//                                .align(Alignment.BottomCenter),
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//                Card(
//                    elevation = 5.dp,
//                    shape = RoundedCornerShape(10.dp),
//                    modifier = Modifier
//                        .size(170.dp)
//                        .align(
//                            Alignment.TopEnd
//                        )
//                ) {
//                    Box {
//                        Image(
//                            bitmap = ImageBitmap.imageResource(id = R.drawable.beach),
//                            contentDescription = "beach",
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier
//                                .size(170.dp)
//                        )
//                        Text(
//                            text = "Beach",
//                            Modifier
//                                .background(Color.Cyan.copy(0.6f))
//                                .fillMaxWidth()
//                                .align(Alignment.BottomCenter),
//                            textAlign = TextAlign.Center
//                        )
//
//                    }
//                }
//
//                Card(
//                    elevation = 5.dp,
//                    shape = RoundedCornerShape(10.dp),
//                    modifier = Modifier
//                        .size(170.dp)
//                        .align(
//                            Alignment.TopStart
//                        )
//                        .offset(y = 185.dp)
//                ) {
//                    Box {
//                        Image(
//                            bitmap = ImageBitmap.imageResource(id = R.drawable.fog),
//                            contentDescription = "fog",
//                            contentScale = ContentScale.Crop,
//                        )
//                        Text(
//                            text = "Fog",
//                            Modifier
//                                .background(Color.Cyan.copy(0.6f))
//                                .fillMaxWidth()
//                                .align(Alignment.BottomCenter),
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
