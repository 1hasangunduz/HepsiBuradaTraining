package com.Api;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndpoints {

    public static Response createUser(String payload) {

        RestAssured.baseURI = Routes.base_url;

        Response response = RestAssured.

                given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).

                when().post(Routes.post_url);

        return response;

    }

    public static Response readUser(String userName) {

        RestAssured.baseURI = Routes.base_url;

        Response response = RestAssured.

                given().pathParam("username", userName).

                when().get(Routes.get_put_delete_url);

        return response;

    }

    public static Response updateUser(String userName, String payload) {

        RestAssured.baseURI = Routes.base_url;

        Response response = RestAssured.

                given().contentType(ContentType.JSON).accept(ContentType.JSON).

                pathParam("username", userName).body(payload).

                when().put(Routes.get_put_delete_url);

        return response;

    }

    public static Response deleteUser(String userName) {

        RestAssured.baseURI = Routes.base_url;

        Response response = RestAssured.

                given().pathParam("username", userName).

                when().delete(Routes.get_put_delete_url);
        return response;

    }
}