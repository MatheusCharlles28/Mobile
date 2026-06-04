package br.com.carmelsystem.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val XpBlue           = Color(0xFF003C74)
val XpBlueLight      = Color(0xFF2278D7)
val XpBlueMid        = Color(0xFF1253A4)
val XpGray           = Color(0xFFD4D0C8)
val XpGrayDark       = Color(0xFF808080)
val XpGrayLight      = Color(0xFFF0EFE7)
val XpGreen          = Color(0xFF3A7734)
val XpGreenLight     = Color(0xFF64B05A)
val XpWhite          = Color(0xFFFFFFFF)
val XpBorder         = Color(0xFF919B9C)
val XpText           = Color(0xFF000000)
val XpTextLight      = Color(0xFF333333)
val XpRed            = Color(0xFFCC0000)
val XpHighlight      = Color(0xFF316AC5)

private val XpColorScheme = lightColorScheme(
    primary             = XpBlue,
    onPrimary           = XpWhite,
    primaryContainer    = XpBlueLight,
    onPrimaryContainer  = XpWhite,
    secondary           = XpGreen,
    onSecondary         = XpWhite,
    background          = XpGrayLight,
    onBackground        = XpText,
    surface             = XpGray,
    onSurface           = XpText,
    error               = XpRed,
    onError             = XpWhite,
    outline             = XpBorder
)

@Composable
fun CarmelSystemTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = XpColorScheme,
        typography = Typography(),
        content = content
    )
}
