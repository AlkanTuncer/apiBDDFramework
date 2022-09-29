package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.CustomerPost;
import utilities.ConfigurationReader;
import utilities.SprinGularUtils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class CustomerPostRequest {

    Response response;
    String url;
    String token;

    CustomerPost customer = new CustomerPost();

    @Given("login SprinGular api using username {string} and password {string}")
    public void loginSprinGularApiUsingUsernameAndPassword(String username, String password) {

        token = ConfigurationReader.get("accessTokenSprinGular");

    }

    @Then("add customer payloads")
    public void addCustomerPayloads() {

        customer.setId(153);
        customer.setFirstName("Kobe");
        customer.setLastName("Bryant");
        customer.setAddress1("LA");
        customer.setAddress2("Lakers");
        customer.setCity("Los Angles");
        customer.setCompany("NBA");
        customer.setEmail("kobebryant0824@hotmail.com");
        customer.setPhone("0824");
        customer.setPostalCode("0824");
        customer.setCountry("USA");
        customer.setState("LA");

    }

    @Then("user sends a Post request to {string}")
    public void userSendsAPostRequestTo(String endpoint) {

        url = ConfigurationReader.get("springularURL");

        response = given().header("Authorization",token)
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .and()
                .body(customer)
                .when()
                .post(url + endpoint);

    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String expectedValue) {

        String actualValue = response.path(key);

        assertEquals(expectedValue,actualValue);

    }
}
