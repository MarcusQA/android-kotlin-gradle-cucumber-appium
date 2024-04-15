package steps

import io.appium.java_client.android.AndroidDriver
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.CalculatorPage

class CalculatorSteps(private val driver: AndroidDriver = Hooks.getDriver()) : BaseSteps() {
    @When("I multiply {int} and {int}")
    fun i_multiply_and(int1: Int, int2: Int) {
        val calculatorPage = CalculatorPage(driver)
        calculatorPage.selectDigit(int1)
        calculatorPage.selectMultiplicationSymbolX()
        calculatorPage.selectDigit(int2)
        calculatorPage.selectEqualsSymbol()
    }

    @Then("the result is {int}")
    fun the_result_is(expectedResult: Int) {
        val calculatorPage = CalculatorPage(driver)
        val actualResult = calculatorPage.getResult()
        kotlin.test.assertEquals("$expectedResult Calculation result", actualResult)
    }
}

