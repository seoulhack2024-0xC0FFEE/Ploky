package net.projecttl.ploky.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val LightColorScheme = lightColorScheme(
    background = ColorScheme.Background
)

val DarkColorScheme = darkColorScheme(
    background = ColorScheme.Background
)

@Composable
fun PlokyTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = when {
            isDarkTheme -> DarkColorScheme
            else -> LightColorScheme
        },
        typography = Typography,
        content = content
    )
}