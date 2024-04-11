package pages

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By

class CalculatorPage(private val driver: AndroidDriver) {
    fun selectDigit(digit: Int) {
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_0$digit")).click()
    }

    fun selectMultiplicationSymbolX() {
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul")).click()
    }

    fun selectEqualsSymbol() {
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click()
    }

    fun getResult(): String {
        return driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).text
    }
}