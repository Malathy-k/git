package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)

    @CucumberOptions(

            features = {"src/test/resources/features/Login.feature",
                    "src/test/resources/features/Login1.feature"},
//            features = "@target/failed_scenarios.txt",
            glue = {
                    "stepdefinitions",
                    "hooks"
            },

            plugin = {

                    "pretty",

                    "html:target/cucumber-report.html",

                    "json:target/cucumber.json",

                    "junit:target/cucumber.xml",

                    "rerun:target/failed_scenarios.txt"

            },

            monochrome = true,

            publish = true,

            dryRun = false



    )

    public class TestRunner {



    }

