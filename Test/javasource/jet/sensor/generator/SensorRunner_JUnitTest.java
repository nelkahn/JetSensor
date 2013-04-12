package jet.sensor.generator;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SensorRunner_JUnitTest {

    @Test
    public void testSensorRunner() {
        final SensorRunner sr = new SensorRunner();
        assertNotNull(sr);
    }

}
