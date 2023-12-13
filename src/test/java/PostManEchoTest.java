import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Request;

import java.net.http.HttpResponse;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class PostManEchoTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        RestAssured.
                when().get("/get?foo1=bar1&foo2=bar2").
                then().assertThat().statusCode(200).
                and().body("args.foo1", is("bar1"))
                .body("args.foo2", is("bar2"))
                .body("headers.x-forwarded-proto", is("https"));
    }

    @Test
    public void testPostRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        RestAssured
                .given()
                .log().all()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data",is("This is expected to be sent back as part of response body."))
                .log().all();
    }

    @Test
    public void testPutRequest() {

        String requestBody = "This is expected to be sent back as part of response body.";

        RestAssured
                .given()
                .log().all()
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data",is("This is expected to be sent back as part of response body."))
        .log().all();

    }

    @Test
    public void testPatchRequest() {
        String requestBody = "{\"key\": \"value\"}";

        RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.key",is("value"))
                .log().all();
    }

    @Test
    public void testDeleteRequest() {
        RestAssured
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .log().all();
    }
}