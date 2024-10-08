package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resource/features",
                  glue= {"stepdefinition","hooks"},
                  publish=true,
                  plugin = {"pretty","html:target/CucumberReport/Cucumber.html"})



public class TestRunner {

}
