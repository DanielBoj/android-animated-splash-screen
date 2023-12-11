package dev.dboj.splashscreen.ui.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.dboj.splashscreen.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.navigate("overview_screen") {
            popUpTo("splash_screen") { inclusive = true }
        }
    }

    Splash()
}

@Composable
private fun Splash() {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF202020),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_logo_round), contentDescription = "Developer Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(20.dp)
                    .scale(scale.value)
            )
            Text(
                "Bienevenid@s a la App de Android",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}