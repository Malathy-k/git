package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() throws Exception {

        prop = new Properties();

        prop.load(new FileInputStream("src/test/resources/config.properties"));

    }

    public String getProperty(String key) {

        return prop.getProperty(key);

    }

}
