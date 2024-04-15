package steps

import io.appium.java_client.android.AndroidDriver
import io.cucumber.java.After
import io.cucumber.java.AfterStep
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.time.Duration.ofSeconds

class Hooks {
    companion object {
        private lateinit var driver: AndroidDriver

        fun getDriver(): AndroidDriver {
            return this.driver
        }
    }

    private val activityName = "com.sec.android.app.popupcalculator.Calculator"
    private val appPackage = "com.sec.android.app.popupcalculator"
    private val automationName = "UiAutomator2"
    private val platformName = "Android"
    private val serverUrl = "http://localhost:4723"
    private val caps = DesiredCapabilities()

    @Before
    fun beforeEachScenario() {
        caps.setCapability("platformName", platformName)
        caps.setCapability("automationName", automationName)
        caps.setCapability("appPackage", appPackage)
        caps.setCapability("appActivity", activityName)

        driver = AndroidDriver(URL(serverUrl), caps)
        driver.manage().timeouts().implicitlyWait(ofSeconds(10))
    }

    @AfterStep
    fun afterEachStep(scenario: Scenario) {
        if (scenario.isFailed) {
            val screenshot = (driver as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
            scenario.attach(
                screenshot,
                "image/png",
                scenario.getName() + ": page where failure occurred"
            )

            driver.navigate().back()
            val previousScreenshot = (driver as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
            scenario.attach(
                previousScreenshot,
                "image/png",
                scenario.name + ": page before failure"
            )
        }
    }

    @After
    fun afterEachScenario() {
        driver.quit()
    }
}