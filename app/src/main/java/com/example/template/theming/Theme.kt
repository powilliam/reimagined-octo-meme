package com.example.template.theming

import android.content.Context
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable

private val isDynamicColorSchemeSupported = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

@Composable
fun ApplicationTheme(
    context: () -> Context,
    isDarkModeEnabled: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val ctx = context()
    val colorScheme = when {
        !isDarkModeEnabled and isDynamicColorSchemeSupported -> dynamicLightColorScheme(ctx)
        isDarkModeEnabled and isDynamicColorSchemeSupported -> dynamicDarkColorScheme(ctx)
        isDarkModeEnabled and !isDynamicColorSchemeSupported -> applicationDarkColors
        else -> applicationLightColors
    }

    MaterialTheme(colorScheme) {
        content()
    }
}