package support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class Hooks {

    @Before(order = 0)
    public void scenarioStart() throws Exception {
        TestContext.initialize();
        TestContext.getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) TestContext.getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        TestContext.close();
    }
}
