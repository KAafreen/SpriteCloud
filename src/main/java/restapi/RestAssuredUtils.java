package restapi;

public class RestAssuredUtils
{
    public static String username;
    public static String password;
    private static String baseUrl;

    public static String getUsername()
    {
        return username;
    }

    public static void setUsername(final String username)
    {
        RestAssuredUtils.username = username;
    }

    public static String getPassword()
    {
        return password;
    }

    public static void setPassword(final String password)
    {
        RestAssuredUtils.password = password;
    }

    public static String getBaseUrl()
    {
        return baseUrl;
    }

    public static void setBaseUrl(final String baseUrl)
    {
        RestAssuredUtils.baseUrl = baseUrl;
    }
}
