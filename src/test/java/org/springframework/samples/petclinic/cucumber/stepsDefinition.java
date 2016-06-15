package org.springframework.samples.petclinic.cucumber;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:cucumber.xml",
	"classpath:spring/business-config.xml", 
	"classpath:spring/tools-config.xml", 
	"classpath:spring/mvc-core-config.xml"})
@WebAppConfiguration
@ActiveProfiles("spring-data-jpa")
public class stepsDefinition {
	
	private ResultActions resultActions;
	private Owner owner = new Owner();
	
	@Autowired
	private OwnerRepository  ownerRepository;
	
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
	
	@When("^I fill in the following:$")
	public void I_fill_in_the_following(DataTable arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
		List<String> dataList = arg1.asList(String.class);		
		owner.setFirstName(dataList.get(1));
		owner.setLastName(dataList.get(3));
		owner.setAddress(dataList.get(5));
		owner.setCity(dataList.get(7));
		owner.setTelephone(dataList.get(9));
	}

	@When("^I press \"([^\"]*)\"$")
	public void I_press(String arg1) throws Throwable {
	    ownerRepository.save(owner);
	}
	

	@Then("^I should see \"([^\"]*)\"$")
	public void I_should_see(String content) throws Throwable {
	    Collection<Owner> ownerData = ownerRepository.findByLastName(owner.getLastName());
	    for (Owner owner_fetched : ownerData) {
	    	if (owner_fetched.getLastName().equals(owner.getLastName())) {
	    		owner.setId(owner_fetched.getId());
	    		assert(owner_fetched.getLastName().equals(content));
	    		break;
	    	}
	    }
	    resultActions = mockMvc
                .perform(get("/petclinic/owners/"+owner.getId() ))
                .andExpect(status().isOk());
	}


}
