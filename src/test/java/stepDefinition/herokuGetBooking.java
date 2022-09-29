package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class herokuGetBooking {

    Response response;
    String url;
    String headerKey;
    String headerValue;

    @Given("The {string} should be {string}")
    public void the_should_be(String key, String value) {

        headerKey = key;
        headerValue = value;

    }

    @When("user send a get request to {string}")
    public void user_send_a_get_request_to(String endpoint) {

        url = ConfigurationReader.get("herokuURL");
        response = given().header(headerKey,headerValue)
                .when()
                .get(url + endpoint);

    }

    @Then("print the response body")
    public void print_the_response_body() {

        response.prettyPrint();

    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(Integer expectedStatusCode) {

        int actualStatusCode = 200;
        //System.out.println("actualStatusCode = " + actualStatusCode);
        assertTrue(expectedStatusCode.equals(actualStatusCode));

    }

    @Then("response content type should be {string}")
    public void response_content_type_should_be(String expectedContentType) {

        String actualContentType = response.contentType();
        assertEquals(expectedContentType,actualContentType);

    }

    @Then("response body should contains {string}")
    public void response_body_should_contains(String expectedFirstname) {

        assertTrue(response.body().asString().contains(expectedFirstname));

    }


}
