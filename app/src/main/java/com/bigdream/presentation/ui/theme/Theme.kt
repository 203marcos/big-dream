package com.bigdream.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Blue600,
    onPrimary = Color.White,
    primaryContainer = Blue50,
    onPrimaryContainer = Blue700,
    secondary = Slate600,
    onSecondary = Color.White,
    secondaryContainer = Slate100,
    onSecondaryContainer = Slate800,
    tertiary = Orange500,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFFF7ED),
    onTertiaryContainer = Orange600,
    background = Slate50,
    onBackground = Slate800,
    surface = Color.White,
    onSurface = Slate800,
    surfaceVariant = Slate100,
    onSurfaceVariant = Slate600,
    outline = Slate300,
    outlineVariant = Slate200,
    error = Error,
    onError = Color.White,
    errorContainer = Color(0xFFFEE2E2),
    onErrorContainer = Color(0xFF991B1B),
)

private val DarkColors = darkColorScheme(
    primary = Blue400,
    onPrimary = Color(0xFF003258),
    primaryContainer = Blue700,
    onPrimaryContainer = Blue50,
    secondary = Slate400,
    onSecondary = Slate900,
    secondaryContainer = Slate700,
    onSecondaryContainer = Slate200,
    tertiary = Orange400,
    onTertiary = Color(0xFF4A2000),
    tertiaryContainer = Orange600,
    onTertiaryContainer = Color(0xFFFFF7ED),
    background = Slate900,
    onBackground = Slate100,
    surface = Slate800,
    onSurface = Slate100,
    surfaceVariant = Slate700,
    onSurfaceVariant = Slate300,
    outline = Slate500,
    outlineVariant = Slate700,
    error = ErrorDark,
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = ErrorLight,
)

@Composable
fun BigDreamTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = BigDreamTypography,
        shapes = BigDreamShapes,
        content = content,
    )
}
