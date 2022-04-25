import java.util.HashMap;
import java.util.Map;

import com.utility.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.Api.UserEndpoints;
import com.Api.User;
import io.restassured.response.Response;

public class TestEndpoints {

    Faker faker;
    User userPayload;

    @BeforeTest
    public void beforeTest() {

        Log.pass("________________________________USERNAME________________________________");
        faker = new Faker();
        userPayload = new User();
        userPayload.setUserId(faker.idNumber().hashCode());
        userPayload.setUserName(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        Log.pass("Some Random username genereated by Faker:\t" + userPayload.getUserName());
        Log.pass("________________________________________________________________________________________________");

    }

    @Test(priority = 1)
    public void testPostUser() {

        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("id", userPayload.getUserId());
        bodyParams.put("username", userPayload.getUserName());
        bodyParams.put("firstName", userPayload.getFirstName());
        bodyParams.put("lastName", userPayload.getLastName());
        bodyParams.put("email", userPayload.getEmail());
        bodyParams.put("password", userPayload.getPassword());
        bodyParams.put("phone", userPayload.getPhone());
        bodyParams.put("userStatus", 0);
        String payload = new Gson().toJson(bodyParams);
        Log.pass("________________________________{POST}________________________________");
        Response response = UserEndpoints.createUser(payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getStatusLine().contains("OK"));
        Log.pass("________________________________" + this.userPayload.getUserName() + " is created ________________________________");

    }

    @Test(priority = 2)
    public void testGetUserByName() {

        Log.pass("________________________________{GET}________________________________");
        Response response = UserEndpoints.readUser(this.userPayload.getUserName());
        response.then().log().body().statusCode(200);
        Log.pass("________________________________" + this.userPayload.getUserName() + " is fetched ________________________________");
    }

    @Test(priority = 3)
    public void testUpdateUserByName() {

        Map<String, Object> bodyParams = new HashMap<String, Object>();
        bodyParams.put("id", userPayload.getUserId());
        bodyParams.put("username", userPayload.getUserName());
        bodyParams.put("firstName", userPayload.getFirstName() + " is my first name");
        bodyParams.put("lastName", userPayload.getLastName() + " is my last name");
        bodyParams.put("email", userPayload.getEmail() + " is my email");
        bodyParams.put("password", userPayload.getPassword() + " is my password");
        bodyParams.put("phone", userPayload.getPhone() + " is my phone number");
        bodyParams.put("userStatus", 1);

        String payload = new Gson().toJson(bodyParams);
        Log.pass("________________________________{UPDATE}________________________________");
        Response response = UserEndpoints.updateUser(this.userPayload.getUserName(), payload);
        response.then().log().body().statusCode(200);
        Response afterUpdateResponse = UserEndpoints.readUser(this.userPayload.getUserName());
        afterUpdateResponse.then().log().body().statusCode(200);
        Log.pass("________________________________" + this.userPayload.getUserName() + " is updated ________________________________");

    }

    @Test(priority = 4)
    public void testDeleteUserByName() {
        Log.pass("________________________________{DELETE}________________________________");
        Response response = UserEndpoints.deleteUser(this.userPayload.getUserName());
        response.then().log().body().statusCode(200);
        Log.pass("________________________________" + this.userPayload.getUserName() + " is deleted ________________________________");

    }
}
