//// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
//import androidx.compose.desktop.ui.tooling.preview.Preview
//import androidx.compose.material.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.window.Window
//import androidx.compose.ui.window.application
//import com.zelyder.calculator.presenter.CalculatorPresenter
//import com.zelyder.calculator.view.CalculatorDisplay
//
//@Composable
//@Preview
//fun App() {
//
//    MaterialTheme {
//        CalculatorDisplay(
//            {},
//            {},
//            {},
//            {}
//        )
//
//    }
//}
//
//fun main() = application {
//    Window(onCloseRequest = ::exitApplication) {
//        App()
//    }
//}
////fun main() {
////    run()
////}
//
//fun run() {
//    println("Введите один из опереторов: + - * /")
//    val operator = readLine()?.trim()
//
//    val calculatorPresenter = CalculatorPresenter()
//    when (operator) {
//        "+" -> calculatorPresenter.onPlusClicked()
//        "-" -> calculatorPresenter.onMinusClicked()
//        "*" -> calculatorPresenter.onMultiplyClicked()
//        "/" -> calculatorPresenter.onDivideClicked()
//        else -> println("Некорректный оперетор")
//    }
//    run()
//}