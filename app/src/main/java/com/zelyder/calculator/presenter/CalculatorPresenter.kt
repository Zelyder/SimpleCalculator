package com.zelyder.calculator.presenter

import com.zelyder.calculator.utils.Calculator
import com.zelyder.calculator.utils.Constants.ARITHMETIC_ERROR_MESSAGE
import com.zelyder.calculator.utils.Constants.FORMAT_ERROR_MESSAGE
import com.zelyder.calculator.utils.Constants.UNKNOWN_ERROR_MESSAGE
import com.zelyder.calculator.view.CalculatorConsole
import com.zelyder.calculator.view.ICalculatorView

open class CalculatorPresenter(
    val calculatorView: ICalculatorView = CalculatorConsole()
) : ICalculatorPresenter {
    private val calculator = Calculator()
    private var firstArgument: Double = 0.0
    private var secondArgument: Double = 0.0


    private fun getArguments(){
            if(calculatorView.firstArgumentAsString?.contains(',') == true){
                firstArgument = calculatorView.firstArgumentAsString
                    ?.replace(',', '.')?.toDouble() ?: 0.0
                secondArgument = calculatorView.secondArgumentAsString
                    ?.replace(',', '.')?.toDouble() ?: 0.0
            }else {
                firstArgument = calculatorView.firstArgumentAsString?.toDouble() ?: 0.0
                secondArgument = calculatorView.secondArgumentAsString?.toDouble() ?: 0.0
            }
    }

    override fun onPlusClicked() = wrapTry {
        getArguments()
        calculatorView.printResult(calculator.sum(firstArgument, secondArgument))
    }

    override fun onMinusClicked() = wrapTry {
        getArguments()
        calculatorView.printResult(calculator.subtract(firstArgument, secondArgument))
    }

    override fun onDivideClicked() = wrapTry {
        getArguments()
        calculatorView.printResult(calculator.divide(firstArgument, secondArgument))
    }

    override fun onMultiplyClicked() = wrapTry {
        getArguments()
        calculatorView.printResult(calculator.multiply(firstArgument, secondArgument))
    }

    private fun wrapTry(foo: () -> Unit) {
        try {
            foo()
        } catch (ex: NumberFormatException) {
            calculatorView.displayError(FORMAT_ERROR_MESSAGE)
        } catch (ex: ArithmeticException) {
            calculatorView.displayError(ARITHMETIC_ERROR_MESSAGE)
        } catch (ex: Exception) {
            calculatorView.displayError(UNKNOWN_ERROR_MESSAGE)
            println(ex.message)
        }
    }
}