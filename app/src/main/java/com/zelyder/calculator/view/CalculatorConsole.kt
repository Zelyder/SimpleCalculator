package com.zelyder.calculator.view

class CalculatorConsole : ICalculatorView {
    override fun printResult(result: Double) {
        println("Answer: $result")
    }

    override fun displayError(message: String?) {
        println("Error: $message")
    }

    override val firstArgumentAsString: String
        get() {
            println("Введите первое число")
            return readLine() ?: ""
        }
    override val secondArgumentAsString: String
        get(){
            println("Введите второе число")
            return readLine() ?: ""
        }
}