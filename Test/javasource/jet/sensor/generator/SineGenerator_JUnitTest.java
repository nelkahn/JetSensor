package jet.sensor.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SineGenerator_JUnitTest {

    private static final double DELTA = 0.000001;
    private SineGenerator sineGenerator;

    @Before
    public void setUp() throws Exception {
        this.sineGenerator = new SineGenerator(SensorConfiguration_JUnitTest.getSensorConfiguration());
    }

    @Test
    public void testGetSensorReading() {
        Double result = this.sineGenerator.getSensorReading(0);
        assertEquals(Double.valueOf(0).doubleValue(), result.doubleValue(), DELTA);
        result = this.sineGenerator.getSensorReading(CosineGenerator.MEASURES_PER_REVOLUTION / 4);
        assertEquals(Double.valueOf(1).doubleValue(), result.doubleValue(), 0.000001);
        result = this.sineGenerator.getSensorReading(CosineGenerator.MEASURES_PER_REVOLUTION / 2);
        assertEquals(Double.valueOf(0).doubleValue(), result.doubleValue(), 0.000001);
        result = this.sineGenerator.getSensorReading(CosineGenerator.MEASURES_PER_REVOLUTION * 3 / 4);
        assertEquals(Double.valueOf(-1).doubleValue(), result.doubleValue(), 0.000001);
        result = this.sineGenerator.getSensorReading(CosineGenerator.MEASURES_PER_REVOLUTION);
        assertEquals(Double.valueOf(0).doubleValue(), result.doubleValue(), 0.000001);
    }

}
