package configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader
{
    private static final String PROPERTIES_FILE_EXTENSION = ".properties";
    private static Properties properties = new Properties();

    /**
     * Class to read data from property files
     *
     * @param fileName
     */
    public static Properties readPropertiesFromFile(final String fileName) throws IOException
    {
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/" + fileName + PROPERTIES_FILE_EXTENSION);
        properties.load(input);
        input.close();
        return properties;
    }

    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
