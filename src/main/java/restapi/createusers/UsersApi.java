package restapi.createusers;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import restapi.ApiConstants;
import restapi.RestAssuredUtils;


@Slf4j
public class UsersApi
{
    public Response response;
    public RequestSpecification httpRequest;

    /**
     * Api to create new users.
     *
     * @param name
     * @param job
     */
    public Response executePostCreateUsersApi(String name, String job)
    {
        httpRequest = given();
        User user = new User(name, job);
        response = httpRequest.auth().basic(RestAssuredUtils.getUsername(), RestAssuredUtils.getPassword()).header(ApiConstants.CONTENT_TYPE,
            ApiConstants.APPLICATION_JSON).header(ApiConstants.ACCEPT,
            ApiConstants.APPLICATION_JSON).body(user).post(RestAssuredUtils.getBaseUrl() + ApiConstants.USERS_API);
        log.info("=> response of POST users api is : " + response.getBody().asString());
        log.info("=> code of POST users api is : " + response.getStatusCode());
        return response;
    }

    /**
     * Api to update existing users.
     *
     * @param name
     * @param job
     */
    public Response executePutUpdateUsersApi(String name, String job, int userId)
    {
        httpRequest = given();
        User user = new User(name, job);
        response = httpRequest.auth().basic(RestAssuredUtils.getUsername(), RestAssuredUtils.getPassword()).header(ApiConstants.CONTENT_TYPE,
            ApiConstants.APPLICATION_JSON).header(ApiConstants.ACCEPT,
            ApiConstants.APPLICATION_JSON).body(user).put(RestAssuredUtils.getBaseUrl() + ApiConstants.USERS_API + "/" + userId);
        log.info("=> response of PUT users is : " + response.getBody().asString());
        log.info("=> code of PUT users is : " + response.getStatusCode());
        return response;
    }

    /**
     * Api to delete users.
     *
     * @param userId
     */
    public Response executeDeleteUsersApi(int userId)
    {
        httpRequest = given();
        response = httpRequest.auth().basic(RestAssuredUtils.getUsername(), RestAssuredUtils.getPassword()).header(ApiConstants.CONTENT_TYPE,
            ApiConstants.APPLICATION_JSON).header(ApiConstants.ACCEPT,
            ApiConstants.APPLICATION_JSON).delete(RestAssuredUtils.getBaseUrl() + ApiConstants.USERS_API + "/" + userId);
        log.info("=> response of DELETE users is : " + response.getBody().asString());
        log.info("=> code of DELETE users is : " + response.getStatusCode());
        return response;
    }

    /**
     * Api to get existing user by userId.
     *
     * @param userId
     */
    public Response executeGetUsersApi(int userId)
    {
        httpRequest = given();
        response = httpRequest.auth().basic(RestAssuredUtils.getUsername(), RestAssuredUtils.getPassword()).header(ApiConstants.CONTENT_TYPE,
            ApiConstants.APPLICATION_JSON).header(ApiConstants.ACCEPT,
            ApiConstants.APPLICATION_JSON).get(RestAssuredUtils.getBaseUrl() + ApiConstants.USERS_API + "/" + userId);
        log.info("=> response of GET users is : " + response.getBody().asString());
        log.info("=> code of GET users is : " + response.getStatusCode());
        return response;
    }

}
