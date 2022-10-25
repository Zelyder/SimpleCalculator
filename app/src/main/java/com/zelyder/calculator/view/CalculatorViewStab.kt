package com.zelyder.calculator.view

class CalculatorViewStab(private val firstArgument: String, private val secondArgument: String) : ICalculatorView {
    var result: Double = 0.0
    var errorMessage = ""

    override fun printResult(result: Double) {
        this.result = result
    }

    override fun displayError(message: String?) {
        this.errorMessage = message ?: ""
    }

    override val firstArgumentAsString: String
        get() = firstArgument
    override val secondArgumentAsString: String
        get() = secondArgument
}