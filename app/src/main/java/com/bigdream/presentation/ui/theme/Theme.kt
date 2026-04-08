package com.bigdream.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Blue = Color(0xFF1A73E8)
private val BlueDark = Color(0xFF4DA3FF)
private val Background = Color(0xFFF5F5F5)
private val BackgroundDark = Color(0xFF121212)

private val LightColors = lightColorScheme(
    primary = Blue,
    onPrimary = Color.White,
    background = Background,
    surface = Color.White,
)

private val DarkColors = darkColorScheme(
    primary = BlueDark,
    onPrimary = Color.Black,
    background = BackgroundDark,
    surface = Color(0xFF1E1E1E),
)

@Composable
fun BigDreamTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content,
    )
}
