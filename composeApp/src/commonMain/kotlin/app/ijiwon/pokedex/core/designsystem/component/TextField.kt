package app.ijiwon.pokedex.core.designsystem.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import app.ijiwon.pokedex.core.designsystem.theme.Gray100
import app.ijiwon.pokedex.core.designsystem.theme.Gray50
import app.ijiwon.pokedex.core.designsystem.theme.Gray500
import app.ijiwon.pokedex.core.designsystem.theme.Gray900

@Composable
fun TextField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    inputTransformation: InputTransformation? = null,
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onKeyboardAction: KeyboardActionHandler? = null,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    onTextLayout: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    cursorBrush: Brush = SolidColor(Color.Black),
    outputTransformation: OutputTransformation? = null,
    scrollState: ScrollState = rememberScrollState(),
    shape: Shape = RoundedCornerShape(8.dp),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        textColor = Gray900,
        containerColor = Gray50,
        placeholderColor = Gray500,
        borderColor = Gray100,
    ),
    contentPadding: PaddingValues = PaddingValues(16.dp),
) {
    BasicTextField(
        state,
        modifier.fillMaxWidth(),
        enabled,
        readOnly,
        inputTransformation,
        textStyle,
        keyboardOptions,
        onKeyboardAction,
        lineLimits,
        onTextLayout,
        interactionSource,
        cursorBrush,
        outputTransformation,
        decorator = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(state.text.toString(),
                innerTextField,
                enabled,
                singleLine = lineLimits == TextFieldLineLimits.SingleLine,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                isError = isError,
                placeholder = placeholder,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                supportingText = supportingText,
                colors = colors,
                contentPadding = contentPadding,
                container = {
                    OutlinedTextFieldDefaults.Container(
                        enabled,
                        isError,
                        interactionSource,
                        Modifier.fillMaxWidth(),
                        colors,
                        shape,
                        focusedBorderThickness = 2.dp,
                        unfocusedBorderThickness = 2.dp,
                    )
                })
        },
        scrollState,
    )
}

@Composable
internal fun OutlinedTextFieldDefaults.colors(
    textColor: Color,
    containerColor: Color,
    placeholderColor: Color,
    borderColor: Color,
): TextFieldColors = colors(
    focusedTextColor = textColor,
    unfocusedTextColor = textColor,
    disabledTextColor = textColor,
    errorTextColor = textColor,
    focusedContainerColor = containerColor,
    unfocusedContainerColor = containerColor,
    disabledContainerColor = containerColor,
    errorContainerColor = containerColor,
    focusedPlaceholderColor = placeholderColor,
    unfocusedPlaceholderColor = placeholderColor,
    disabledPlaceholderColor = placeholderColor,
    errorPlaceholderColor = placeholderColor,
    focusedBorderColor = borderColor,
    unfocusedBorderColor = borderColor,
    disabledBorderColor = borderColor,
    errorBorderColor = borderColor,
)