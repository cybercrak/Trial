package com.example.trial.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme

private val DarkColorPalette = darkColors(
        primary =  Gray,
        primaryVariant = Black,
        onSecondary = Green
)

private val LightColorPalette = lightColors(
        onPrimary = White,
        onSecondary = White,
        secondary = Yellow,

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,

    */
)

@Composable
fun TrialTheme(darkTheme: Boolean = isSystemInDarkTheme(),content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(

            colors = colors,
            shapes = Shapes,
            content = content

    )
}