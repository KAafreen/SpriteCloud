package api.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import restapi.createusers.UsersApi;
import utils.TestGroups;


@Slf4j
public class UsersApiTest extends TestBase
{
    UsersApi usersApi = new UsersApi();

    @Test(enabled = true, groups = {TestGroups.API, TestGroups.CREATE_USERS, TestGroups.SANITY}, priority = 1)
    public void CreateUser_PostApi()
    {
        log.info("-------Executing test to create new user.--------");
        log.info("Before creating new user check if user exists.");
        Response getUserResponse = usersApi.executeGetUsersApi(Integer.parseInt(configReader.getProperty("user.id")));
        if (getUserResponse.getStatusCode() == 200 && !getUserResponse.jsonPath().getString("data.id").isEmpty()
            && getUserResponse.jsonPath().getString("data.id").equalsIgnoreCase(configReader.getProperty("user.id")))
        {
            log.info("User exists. Hence deleting it.");
            Response deleteUserResponse = usersApi.executeDeleteUsersApi(Integer.parseInt(configReader.getProperty("user.id")));
            assertEquals(204, deleteUserResponse.getStatusCode(), "Status code should be 201");
            log.info("Creating new user.");
            Response createUserResponse =
                usersApi.executePostCreateUsersApi(configReader.getProperty("user.name1"), configReader.getProperty("user.job1"));
            assertEquals(201, createUserResponse.getStatusCode(), "Status code should be 201");
            assertEquals(configReader.getProperty("user.name1"),
                createUserResponse.jsonPath().getString("name"),
                "User is created with incorrect name.");
            assertEquals(configReader.getProperty("user.job1"),
                createUserResponse.jsonPath().getString("job"),
                "User is created with incorrect job.");
            assertNotNull(createUserResponse.jsonPath().getString("id"), "Response does not have user id created.");
            assertNotNull(createUserResponse.jsonPath().getString("createdAt"), "Response does not have createdAt date and time.");
        }

    }

    @Test(enabled = true, groups = {TestGroups.API, TestGroups.REGRESSION, TestGroups.GET_USERS}, priority = 2)
    public void userNotFound_GetApi()
    {
        log.info("-------Executing test to execute GET user api for invalid userId.--------");
        Response getUserResponse = usersApi.executeGetUsersApi(23);
        assertEquals(404, getUserResponse.getStatusCode(), "Status code is not 404.");
    }

    @Test(enabled = true, groups = {TestGroups.API, TestGroups.UPDATE_USERS, TestGroups.SANITY}, dependsOnMethods = "CreateUser_PostApi")
    public void updateUser_PutApi()
    {
        log.info("-------Executing test to update user api for existing userId.--------");
        Response updateUserResponse = usersApi.executePutUpdateUsersApi(configReader.getProperty("user.name1"),
            configReader.getProperty("user.job2"),
            Integer.parseInt(configReader.getProperty("user.id")));
        assertEquals(200, updateUserResponse.getStatusCode(), "Status code should be 200");
        assertEquals(configReader.getProperty("user.name1"), updateUserResponse.jsonPath().getString("name"), "User is created with incorrect name.");
        assertEquals(configReader.getProperty("user.job2"), updateUserResponse.jsonPath().getString("job"), "User is created with incorrect job.");
        assertNotNull(updateUserResponse.jsonPath().getString("updatedAt"), "Response does not have updatedAt.");

    }

}
