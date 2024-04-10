package steps

import io.appium.java_client.android.AndroidDriver
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.openqa.selenium.By
import pages.CalculatorPage


class CalculatorSteps(private val driver: AndroidDriver = Hooks.driver) {
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
        val actualResult = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).text
        kotlin.test.assertEquals("$expectedResult Calculation result", actualResult)
    }
}

