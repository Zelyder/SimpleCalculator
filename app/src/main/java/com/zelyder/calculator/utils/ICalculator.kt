package com.zelyder.calculator.utils

interface ICalculator {
    /**
     * Вычисляет сумму двух чисел
     */
    fun sum(a: Double, b: Double): Double

    /**
     * Вычисляет разность двух чисел a - b
     */
    fun subtract(a: Double, b: Double): Double

    /**
     * Вычисляет произведение двух чисел
     */
    fun multiply(a: Double, b: Double): Double

    /**
     * Вычисляет отношение числа а к числу b.
     * Должен выбросить [java.lang.ArithmeticException] если |b| < 10e-8
     */
    fun divide(a: Double, b: Double): Double
}