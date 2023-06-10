package com.algogence.groupaction

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.algogence.groupaction.ui.theme.GroupActionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupActionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        Text("Vishal")
                        Button(onClick = {

                        }) {
                            Row() {
                                Text("Vishal")
                                Text(".")
                                Text("Vishal1")
                            }
                        }
                        val interactionSource = remember { MutableInteractionSource() }
                        val isPressed by interactionSource.collectIsPressedAsState()
                        val startColor by animateColorAsState(targetValue = if(isPressed) Color(0xffff0090) else  Color(0xfff200ff))
                        val endColor by animateColorAsState(targetValue = if(isPressed) Color(0xfff200ff) else  Color(0xffff0090))
                        val text by remember {
                            derivedStateOf {
                                if(isPressed)
                                {
                                    "pressed"
                                }
                                else{
                                    "not pressed"
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .width(250.dp)
                                .height(50.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {
                                    Log.d("lfjlfdslkf", "Clicked")
                                }
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            startColor,
                                            endColor
                                        )
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
/*
* Containers
*   1. Row: Side by side arrangement
*   2. Column: Top to bottom arrangement
*   3. Box: Stack arrangement
*
* dog.bark()
* man.sleep()
* you.go()
* */