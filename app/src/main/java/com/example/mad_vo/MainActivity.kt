package com.example.mad_vo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.mad_vo.ui.theme.MAD_VOTheme
import com.example.mad_vo.navigation.MyNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    MAD_VOTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MAD_VOTheme {
        
    }
}