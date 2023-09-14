package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    Column {
                        Spacer(modifier = Modifier.height(70.dp))
                        Text("관리중인 자녀 4")
                        ChildProfile()

                    }
                }

            }
        }
    }
    @Composable
    fun ChildProfile() {
        var mainImage by remember { mutableStateOf(R.drawable.karina) }
        var mainName by remember { mutableStateOf("카리나")}

        var image1 by remember { mutableStateOf(R.drawable.karina2) }
        var name1 by remember { mutableStateOf("윈터")}

        var image2 by remember { mutableStateOf(R.drawable.karina3) }
        var name2 by remember { mutableStateOf("지젤")}

        var image3 by remember { mutableStateOf(R.drawable.karina4) }
        var name3 by remember { mutableStateOf("닝닝")}

        fun swapImages(imageRes: Int, newName: String){
            val tempImage = mainImage
            val tempName = mainName

            mainImage = imageRes
            mainName = newName

            when (imageRes) {
                image1 -> {
                    image1 = tempImage
                    name1 = tempName
                }

                image2 -> {
                    image2 = tempImage
                    name2 = tempName
                }

                image3 -> {
                    image3 = tempImage
                    name3 = tempName
                }

            }
        }

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()


        ){
            Column (
                horizontalAlignment  = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .border(1.dp, Color(0xFFB4EBF7), CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = mainImage),
                        contentDescription = "Main Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                }
                Text(mainName)
            }
            Row (
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ){
                CircleWithImageAndBorder(image1, name1) {swapImages(image1, name1)}
                Spacer(Modifier.width(8.dp) )
                CircleWithImageAndBorder(image2, name2) {swapImages(image2, name2)}
                Spacer(Modifier.width(8.dp) )
                CircleWithImageAndBorder(image3, name3) {swapImages(image3, name3)}

            }
        }
        ChildCard(mainImage = mainImage, mainName = mainName)
    }
    @Composable
    fun CircleWithImageAndBorder(imageRes: Int, name: String, onClick: () -> Unit) {
        Column (
            horizontalAlignment  = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .border(1.dp, Color.Black, CircleShape)
                    .clickable(onClick = onClick)
            ){
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }
            Text(name)
        }
    }
    @Composable
    fun ChildCard(mainImage: Int, mainName: String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF5FCFEF))
        ){
            Column (
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = mainImage),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                    Spacer(Modifier.width(16.dp))
                    Text("자녀 $mainName 님의\n지갑을 관리하고 있습니다.")
                }
                Text("신용점수")
//                Text("$creditScore")
            }
        }
    }
//    @Composable
//    fun ChildWallet() {
//        Box(
//            modifier = Modifier
//                .
//
//        )
//    }

}
