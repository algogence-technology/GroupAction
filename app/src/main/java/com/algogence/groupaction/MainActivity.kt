package com.algogence.groupaction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.algogence.groupaction.ui.theme.GroupActionTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupActionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color(0xff12171D))
                    ){
                        val mySize = remember{ mutableStateOf(IntSize(0,0)) }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .aspectRatio(1f)
                                .background(
                                    brush = Brush.radialGradient(
                                        colors = listOf(
                                            Color(0xff28152C),
                                            Color(0xff12171D)
                                        ),
                                        center = Offset.Zero,
                                        radius = (mySize.value.width.toFloat()).coerceAtLeast(1f)
                                    )
                                )
                                .onGloballyPositioned {
                                    mySize.value = it.size
                                }
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                ,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            EmailField()
                            PasswordField()
                            Text(
                                "Forgot Password?",
                                color = Color(0xff246BFE),
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(end = 36.dp)
                            )
                            Button(
                                modifier = Modifier
                                    .width(170.dp)
                                    .height(50.dp),
                                onClick = {

                                },
                                shape = RoundedCornerShape(6.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xff246BFE)
                                ),
                            ) {
                                Text(
                                    "LOGIN",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                            Box(
                                contentAlignment = Alignment.TopCenter
                            ){
                                Box(
                                    modifier = Modifier
                                        .padding(top = 15.dp)
                                        .fillMaxWidth()
                                        .height(75.dp)
                                        .background(Color(0xff181D24))
                                ) {

                                }

                                Box(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xff181D24))
                                ) {

                                }
                            }
                            Canvas(
                                modifier = Modifier
                                    .size(200.dp)
                                    .background(Color.White),
                                onDraw = {
                                    drawLine(
                                        Color.Red,Offset.Zero,
                                        Offset(250f,250f),
                                        strokeWidth = 15f
                                    )
                                    drawCircle(Color.Blue, radius = size.minDimension/4f)

                                }
                            )
                        }
                    }

                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun EmailField() {
        OutlinedTextField(
            placeholder = {
                Text("Hello world")
            },
            modifier = Modifier
                .width(320.dp),
            colors = TextFieldDefaults
                .textFieldColors(
                    containerColor = Color(0xff1A2027),
                    textColor = Color.White,
                    focusedIndicatorColor = Color(0xff2054BD),
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.Red
                ),
            value = "",
            onValueChange = {},
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Color(0xff246BFE)
                )
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun PasswordField() {
        OutlinedTextField(
            modifier = Modifier
                .width(320.dp),
            colors = TextFieldDefaults
                .textFieldColors(
                    containerColor = Color(0xff1A2027),
                    textColor = Color.White,
                    focusedIndicatorColor = Color(0xff2054BD),
                    unfocusedIndicatorColor = Color.Transparent
                ),
            value = "Hello",
            onValueChange = {},
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Key,
                    contentDescription = "",
                    tint = Color(0xff246BFE),
                    modifier = Modifier
                        .rotate(225.0f)
                )
            }
        )
    }
}

/*
* chat application like mini whatsapp with firebase or agora library or socket
* drawing app
* Ecommerce app
* Calculator
* Fasebok
* Todo app
* */