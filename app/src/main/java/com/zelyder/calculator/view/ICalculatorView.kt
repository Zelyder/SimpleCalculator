package com.zelyder.calculator.view


interface ICalculatorView {
    /**
     * Отображает результат вычисления
     */
    fun printResult(result: Double)

    /**
     * Показывает ошибку, например деление на 0, пустые аргументы и прочее
     */
    fun displayError(message: String?)

    /**
     * Возвращает значение, введенное в поле первого аргументы
     */
    val firstArgumentAsString: String?

    /**
     * Возвращает значение, введенное в поле второго аргументы
     */
    val secondArgumentAsString: String?
}
