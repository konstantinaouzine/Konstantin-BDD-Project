import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
/*import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;*/
import org.testng.annotations.*;
import pageobjects.BasePage;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs"},
        tags = {"not @Ignore"},
        dryRun = false,
        strict = true
        )


public class RunTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
