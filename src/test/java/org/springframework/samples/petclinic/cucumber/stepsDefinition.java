package org.springframework.samples.petclinic.cucumber;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cucumber.xml")
@WebAppConfiguration
public class stepsDefinition {
	
	private ResultActions resultActions;
	
	@Autowired
    private MockMvc mockMvc;
	
	@Given("^I am on the owners search page$")
	public void I_am_on_the_owners_search_page() throws Throwable {
        
    }
	
	@When("^I follow \"([^\"]*)\"$")
	public void I_follow(String arg1) throws Throwable {
		resultActions = mockMvc
                .perform(get("/petclinic/owners/new/" ))
                .andExpect(status().isOk());
	}

    @Then("^I should see \"([^\"]*)\" within \"([^\"]*)\"$")
    public void I_should_see_within(String arg1, String arg2) throws Throwable {        
        resultActions.andExpect(content().string(containsString(arg1)));
    }
    
}
