package com.zelyder.calculator.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zelyder.calculator.utils.Constants.UNKNOWN_ERROR_MESSAGE

class CalculatorView : ICalculatorView {

    private val result = mutableStateOf(0.0)
    private val first = mutableStateOf("")
    private val second = mutableStateOf("")
    private val errorMessage = mutableStateOf("")
    override fun printResult(result: Double) {
        this.result.value = result
    }

    override fun displayError(message: String?) {
        errorMessage.value = message ?: UNKNOWN_ERROR_MESSAGE
    }


    override val firstArgumentAsString: String
        get() = first.value
    override val secondArgumentAsString: String
        get() = second.value


    @Composable
    fun DisplayDialog() {
        val openDialog = remember { mutableStateOf(false) }
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = { Text(text = "Ошибка") },
            text = { Text(errorMessage.value) },
            buttons = {
                Button(
                    onClick = { openDialog.value = false }
                ) {
                    Text("OK", fontSize = 22.sp)
                }
            }
        )
    }

    @Composable
    fun DisplayCalculator(
        @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
        onPlusClicked: () -> Unit = {},
        onMinusClicked: () -> Unit = {},
        onDivideClicked: () -> Unit = {},
        onMultiplyClicked: () -> Unit = {},
    ) {
        val firstArgument = remember { first }
        val secondArgument = remember { second }
        val answer = remember { result }
        Column(modifier = modifier) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(Modifier.width(8.dp))
                TextField(
                    value = firstArgument.value,
                    onValueChange = { newValue ->
                        this@CalculatorView.first.value = newValue
                    },
                    Modifier.weight(1.0f)
                )
                Spacer(Modifier.width(16.dp))
                TextField(
                    value = secondArgument.value,
                    onValueChange = { newValue ->
                        this@CalculatorView.second.value = newValue
                    },
                    Modifier.weight(1.0f)
                )
                Spacer(Modifier.width(8.dp))
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    errorMessage.value = ""
                    onPlusClicked()
                }
                ) {
                    Text("+")
                }

                Button(onClick = {
                    errorMessage.value = ""
                    onMinusClicked()
                }) {
                    Text("-")
                }

                Button(onClick = {
                    errorMessage.value = ""
                    onMultiplyClicked()
                }) {
                    Text("*")
                }

                Button(onClick = {
                    errorMessage.value = ""
                    onDivideClicked()
                }
                ) {
                    Text("/")
                }
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Answer: ${answer.value}")
            }
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                if (errorMessage.value != "") {
                    Text(
                        "Error: ${errorMessage.value}",
                        color = Color.Red
                    )
                }
            }
        }
    }

}


@Preview
@Composable
private fun CalculatorPreview() {
    CalculatorView()
}