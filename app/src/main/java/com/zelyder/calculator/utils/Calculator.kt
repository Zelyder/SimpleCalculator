package com.zelyder.calculator.utils

import kotlin.math.abs

class Calculator : ICalculator {
    override fun sum(a: Double, b: Double): Double = a + b
    override fun subtract(a: Double, b: Double): Double = a - b
    override fun multiply(a: Double, b: Double): Double = a * b
    override fun divide(a: Double, b: Double): Double {
        if (abs(b) < 10e-8 && b != 0.0){
            throw ArithmeticException()
        }
        return a / b
    }
}