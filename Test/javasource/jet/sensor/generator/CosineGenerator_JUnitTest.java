package jet.sensor.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CosineGenerator_JUnitTest {

    private static final double DELTA = 0.000001;
    private CosineGenerator cosineGenerator;

    @Before
    public void setUp() throws Exception {
        this.cosineGenerator = new CosineGenerator(SensorConfiguration_JUnitTest.getSensorConfiguration());
    }

    @Test
    public void testGetSensorReading() {
        Double result = this.cosineGenerator.getSensorReading(0);
        assertEquals(Double.valueOf(1).doubleValue(), result.doubleValue(), DELTA);
        result = this.cosineGenerator.getSensorReading(CosineGenerator.MEASURES_PER_REVOLUTION / 4);
        assertEquals(Double.valueOf(0).doubleValue(), result.doubleValue(), 0.000001);
        result = this.cosineGenerator.getSensorReading(CosineGenerator.MEASURES_PER_REVOLUTION / 2);
        assertEquals(Double.valueOf(-1).doubleValue(), result.doubleValue(), 0.000001);
        result = this.cosineGenerator.getSensorReading(CosineGenerator.MEASURES_PER_REVOLUTION * 3 / 4);
        assertEquals(Double.valueOf(0).doubleValue(), result.doubleValue(), 0.000001);
        result = this.cosineGenerator.getSensorReading(CosineGenerator.MEASURES_PER_REVOLUTION);
        assertEquals(Double.valueOf(1).doubleValue(), result.doubleValue(), 0.000001);
    }

}
