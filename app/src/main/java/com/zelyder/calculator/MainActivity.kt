package com.zelyder.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zelyder.calculator.presenter.CalculatorPresenter
import com.zelyder.calculator.ui.theme.CalculatorTheme
import com.zelyder.calculator.view.CalculatorView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val calculatorView = CalculatorView()
        val presenter = CalculatorPresenter(calculatorView)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    calculatorView.DisplayCalculator(
                        onPlusClicked = presenter::onPlusClicked,
                        onMinusClicked = presenter::onMinusClicked,
                        onDivideClicked = presenter::onDivideClicked,
                        onMultiplyClicked = presenter::onMultiplyClicked
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        CalculatorView()
    }
}