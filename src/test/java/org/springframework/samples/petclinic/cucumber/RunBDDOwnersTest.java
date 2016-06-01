/**
 * 
 */
package org.springframework.samples.petclinic.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author soundg1
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(monochrome=true, features="classpath:owners.feature", dryRun=false,
glue= "org.springframework.samples.petclinic.cucumber" , format={"pretty"})
public class RunBDDOwnersTest {

}
