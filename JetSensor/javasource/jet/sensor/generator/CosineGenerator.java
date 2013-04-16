package jet.sensor.generator;

public class CosineGenerator extends AbstractGenerator {

    final static int MEASURES_PER_REVOLUTION = 1000;

    public CosineGenerator(final SensorConfiguration sensorConfiguration) {
        super(sensorConfiguration);
    }

    @Override
    public Double getSensorReading(final long readingCount) {

        final double factor = 2.0 * readingCount / MEASURES_PER_REVOLUTION;
        double value = Math.cos(factor * Math.PI);

        // round as I do not want too many decimals
        value = round(value, 9);

        // System.err.println("[CosineGenerator] getSensorReading - " + factor + " :: " + value);

        return Double.valueOf(value);
    }

    @Override
    public String getSensorName() {
        return "cos";
    }

}
