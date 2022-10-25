package com.zelyder.calculator

import com.zelyder.calculator.presenter.CalculatorPresenter
import com.zelyder.calculator.presenter.ICalculatorPresenter
import com.zelyder.calculator.view.CalculatorViewStab
import org.junit.Test
import com.zelyder.calculator.utils.Constants.ARITHMETIC_ERROR_MESSAGE
import com.zelyder.calculator.utils.Constants.FORMAT_ERROR_MESSAGE
import junit.framework.TestCase.assertEquals

class CalculatorPresenterTest {
    private lateinit var presenter: ICalculatorPresenter

    private fun calculate(first: String, second: String, expect: Double, presenterFunc: () -> Unit) {
        val calculatorViewStab = CalculatorViewStab(first, second)
        presenter = CalculatorPresenter(
            calculatorViewStab
        )
        presenterFunc()
        assertEquals(expect, calculatorViewStab.result)
    }

    private fun checkErrorMessage(first: String, second: String, expectMessage: String, presenterFunc: () -> Unit) {
        val calculatorViewStab = CalculatorViewStab(first, second)
        presenter = CalculatorPresenter(
            calculatorViewStab
        )
        presenterFunc()
        assertEquals(expectMessage, calculatorViewStab.errorMessage)
    }

    @Test
    fun onPlusClicked() {
        calculate("2", "2", 4.0) {
            presenter.onPlusClicked()
        }
    }
    @Test
    fun onPlusDouble() {
        calculate("2", "2.5", 4.5) {
            presenter.onPlusClicked()
        }
    }

    @Test
    fun onPlusByNegative() {
        calculate("2", "-5", -3.0) {
            presenter.onPlusClicked()
        }
    }

    @Test
    fun onPlusByTwoNegative() {
        calculate("-2", "-5", -7.0) {
            presenter.onPlusClicked()
        }
    }

    @Test
    fun onMinusClicked() {
        calculate("2", "2", 0.0) {
            presenter.onMinusClicked()
        }
    }

    @Test
    fun onMinusByNegative() {
        calculate("2", "-2", 4.0) {
            presenter.onMinusClicked()
        }
    }

    @Test
    fun onMinusByTwoNegative() {
        calculate("-2", "-2", 0.0) {
            presenter.onMinusClicked()
        }
    }

    @Test
    fun onDivideClicked() {
        calculate("2", "2", 1.0) {
            presenter.onDivideClicked()
        }
    }

    @Test
    fun onMultiplyClicked() {
        calculate("3", "2", 6.0) {
            presenter.onMultiplyClicked()
        }
    }

    @Test
    fun onMultiplyByNegative() {
        calculate("3", "-1", -3.0) {
            presenter.onMultiplyClicked()
        }
    }

    @Test
    fun onMultiplyByTwoNegative() {
        calculate("-3", "-2", 6.0) {
            presenter.onMultiplyClicked()
        }
    }

    @Test
    fun onDivideByZero() {
        calculate("2", "0", Double.POSITIVE_INFINITY) {
            presenter.onDivideClicked()
        }
    }

    @Test
    fun onDivideByNegative() {
        calculate("2", "-1", -2.0) {
            presenter.onDivideClicked()
        }
    }

    @Test
    fun onDivideByDouble() {
        calculate("2", "0.5", 4.0) {
            presenter.onDivideClicked()
        }
    }

    @Test
    fun onDivideByLittleVal() {
        checkErrorMessage("2", "0.000000005", ARITHMETIC_ERROR_MESSAGE) {
            presenter.onDivideClicked()
        }
    }

    @Test
    fun onInputLiterals() {
        checkErrorMessage("fdsdfa", "1", FORMAT_ERROR_MESSAGE) {
            presenter.onDivideClicked()
        }
    }

    @Test
    fun onInputComma() {
        calculate("4,5", "2", 2.25) {
            presenter.onDivideClicked()
        }
    }

    @Test
    fun onInputDouble() {
        calculate("4.5", "2", 2.25) {
            presenter.onDivideClicked()
        }
    }

    @Test
    fun onInputMultipleDots() {
        checkErrorMessage("4.5.5.5", "2", FORMAT_ERROR_MESSAGE) {
            presenter.onDivideClicked()
        }
    }
}