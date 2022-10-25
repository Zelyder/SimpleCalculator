package com.zelyder.calculator

import androidx.compose.ui.test.assertIsDisplayed
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
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class CalculatorViewKtTest {


    @get:Rule
    val composeTestRule = createComposeRule()
    private val presenter: CalculatorPresenter = Mockito.mock(CalculatorPresenter::class.java)

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
    fun testIfCalculatorExists(){
        composeTestRule.onNodeWithText("Answer: 0.0")
            .assertIsDisplayed()
    }

    @Test
    fun testPlus() {
        composeTestRule.onNodeWithText("+")
            .performClick()
        verify(presenter, times(1)).onPlusClicked()
    }

    @Test
    fun testMinus() {
        composeTestRule.onNodeWithText("-")
            .performClick()
        verify(presenter, times(1)).onMinusClicked()
    }

    @Test
    fun testMultiply() {
        composeTestRule.onNodeWithText("*")
            .performClick()
        verify(presenter, times(1)).onMultiplyClicked()
    }

    @Test
    fun testDivide() {
        composeTestRule.onNodeWithText("/")
            .performClick()
        verify(presenter, times(1)).onDivideClicked()
    }
}