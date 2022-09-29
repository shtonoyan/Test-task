package gui.core;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

@UtilityClass
public class TestDataReader {
    private final Properties properties = new Properties();
    private final FileReader reader;

    static {
        try {
            reader = new FileReader("src/main/resources/data.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public String getProperty(String name) {
        properties.load(reader);
        return properties.getProperty(name);
    }
}
