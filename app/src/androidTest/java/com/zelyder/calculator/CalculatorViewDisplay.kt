package com.zelyder.calculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.zelyder.calculator.presenter.CalculatorPresenter
import com.zelyder.calculator.view.CalculatorView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class CalculatorViewDisplay {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val presenter: CalculatorPresenter = CalculatorPresenter()

    @Before
    fun setup(){
        composeTestRule.setContent {
            CalculatorView().DisplayCalculator(
                onPlusClicked = presenter::onPlusClicked,
                onMinusClicked = presenter::onMinusClicked,
                onMultiplyClicked = presenter::onMultiplyClicked,
                onDivideClicked = presenter::onDivideClicked
            )
        }
    }

    @Test
    fun testPlus() {

        composeTestRule.onNodeWithText("+")
            .performClick()
        Mockito.verify(presenter, Mockito.times(1)).onPlusClicked()
    }

    @Test
    fun testMinus() {
        composeTestRule.onNodeWithText("-")
            .performClick()
        Mockito.verify(presenter, Mockito.times(1)).onMinusClicked()
    }

    @Test
    fun testMultiply() {
        composeTestRule.onNodeWithText("*")
            .performClick()
        Mockito.verify(presenter, Mockito.times(1)).onMultiplyClicked()
    }

    @Test
    fun testDivide() {
        composeTestRule.onNodeWithText("/")
            .performClick()
        Mockito.verify(presenter, Mockito.times(1)).onDivideClicked()
    }
}