package pl.pwr.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by SQUIER on 2015-11-20.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConfigServiceTest {

    @Mock
    private Properties properties;

    private ConfigService config;

    @Before
    public void initConfig() {
        when(properties.getProperty("pathToCSVFile")).thenReturn("pathToFile");
        when(properties.getProperty("errors")).thenReturn("pathToErrors");
        when(properties.getProperty("outputFileName")).thenReturn("outputFileName");
        when(properties.getProperty("rowsPerFile")).thenReturn("rowsPerFile");

        config = new ConfigService(properties);
    }

    @After
    public void tearDown() {
        config = null;
    }

    @Test
    public void shouldReturnValidProperties() {
        assertEquals(config.getProperty("pathToCSVFile"), "pathToFile");
        assertEquals(config.getProperty("errors"), "pathToErrors");
        assertEquals(config.getProperty("outputFileName"), "outputFileName");
        assertEquals(config.getProperty("rowsPerFile"), "rowsPerFile");
    }

}
