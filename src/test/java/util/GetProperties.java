package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private static GetProperties getProperties = null;
    private String device;
    private GetProperties(){
        Properties properties = new Properties();
        String fileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream != null) {
            try {
                properties.load(inputStream);
                device = properties.getProperty("device");
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static GetProperties getInstance(){
        if (getProperties == null)
            getProperties = new GetProperties();
        return getProperties;
    }

    public String getDevice() {
        return device;
    }
}
