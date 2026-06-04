package br.com.carmelsystem.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.carmelsystem.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XpTopAppBar(title: String, onBack: (() -> Unit)? = null) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = XpWhite
            )
        },
        navigationIcon = {
            if (onBack != null) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = XpWhite)
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
        modifier = Modifier
            .background(
                Brush.verticalGradient(listOf(XpBlueLight, XpBlue))
            )
            .border(1.dp, XpBlueMid)
    )
}

@Composable
fun XpWindow(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(4.dp))
            .border(1.dp, XpBorder, RoundedCornerShape(4.dp))
            .background(XpGray, RoundedCornerShape(4.dp))
            .padding(8.dp),
        content = content
    )
}

@Composable
fun XpGroupBox(label: String, modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(label, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = XpText)
            Spacer(Modifier.width(4.dp))
            Divider(modifier = Modifier.weight(1f), color = XpGrayDark, thickness = 1.dp)
        }
        Spacer(Modifier.height(6.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, XpBorder, RoundedCornerShape(2.dp))
                .background(Color.White, RoundedCornerShape(2.dp))
                .padding(8.dp),
            content = content
        )
    }
}

@Composable
fun XpButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isDanger: Boolean = false
) {
    val bgColor = when {
        !enabled -> XpGray
        isDanger -> XpRed
        else -> XpGray
    }
    val textColor = if (isDanger && enabled) XpWhite else if (!enabled) XpGrayDark else XpText

    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        shape = RoundedCornerShape(3.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = textColor,
            disabledContainerColor = XpGray,
            disabledContentColor = XpGrayDark
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp, pressedElevation = 0.dp)
    ) {
        Text(text, fontSize = 12.sp, fontWeight = FontWeight.Normal, color = textColor)
    }
}

@Composable
fun XpPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier.height(36.dp),
        shape = RoundedCornerShape(3.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = XpBlue,
            contentColor = XpWhite,
            disabledContainerColor = XpGray,
            disabledContentColor = XpGrayDark
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp, pressedElevation = 0.dp)
    ) {
        Text(text, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun XpTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    supportingText: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        Text(label, fontSize = 11.sp, color = if (isError) XpRed else XpText, fontWeight = FontWeight.Normal)
        Spacer(Modifier.height(2.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            isError = isError,
            enabled = enabled,
            readOnly = readOnly,
            trailingIcon = trailingIcon,
            singleLine = true,
            shape = RoundedCornerShape(2.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = XpHighlight,
                unfocusedBorderColor = XpGrayDark,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                errorBorderColor = XpRed,
                disabledContainerColor = XpGray,
                disabledBorderColor = XpBorder
            ),
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 13.sp, color = XpText)
        )
        if (isError && supportingText.isNotEmpty()) {
            Text(supportingText, fontSize = 10.sp, color = XpRed)
        }
    }
}

@Composable
fun XpInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 12.sp, color = XpTextLight, modifier = Modifier.weight(0.4f))
        Text(value, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = XpText, modifier = Modifier.weight(0.6f))
    }
}

@Composable
fun XpStatusBadge(text: String, color: Color = XpBlue) {
    Box(
        modifier = Modifier
            .border(1.dp, color, RoundedCornerShape(2.dp))
            .background(color.copy(alpha = 0.10f), RoundedCornerShape(2.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(text, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = color)
    }
}
