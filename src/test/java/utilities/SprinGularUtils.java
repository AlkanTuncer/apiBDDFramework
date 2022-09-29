package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SprinGularUtils {

    public String TokenGenerator(String username, String password) {
        //Create an object
        pojo.TokenPost tokenPost = new pojo.TokenPost();
        tokenPost.setUsername(username);
        tokenPost.setPassword(password);

        Response response = given().header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .and()
                .body(tokenPost)
                .when()
                .post("/session");

        // response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.getString("item.token");

        return token;
    }

}
