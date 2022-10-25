package com.zelyder.calculator.presenter


interface ICalculatorPresenter {
    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '+'
     */
    fun onPlusClicked()

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '-'
     */
    fun onMinusClicked()

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '/'
     */
    fun onDivideClicked()

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '*'
     */
    fun onMultiplyClicked()
}
