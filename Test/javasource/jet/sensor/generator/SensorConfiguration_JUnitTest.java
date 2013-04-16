package jet.sensor.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import jet.sensor.generator.SensorConfiguration.DropBox;

import org.junit.Before;
import org.junit.Test;

public class SensorConfiguration_JUnitTest {

    private static final String PATH = "e:/Photos/Dropbox/JetSensor";

    public static final SensorConfiguration getSensorConfiguration() {
        final Properties properties = new Properties();
        properties.setProperty(SensorConfiguration.DROPBOX_PATH, PATH);
        return new SensorConfiguration(properties);
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSensorConfiguration() {
        final SensorConfiguration sensorConfiguration = getSensorConfiguration();
        assertNotNull(sensorConfiguration);
    }

    @Test
    public void testGetDropBox() {
        final SensorConfiguration sensorConfiguration = getSensorConfiguration();
        final DropBox dropBox = sensorConfiguration.getDropBox();
        assertNotNull(dropBox);
        assertEquals(PATH, dropBox.getPath());
    }

}
