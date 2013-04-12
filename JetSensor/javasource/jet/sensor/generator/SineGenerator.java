package jet.sensor.generator;

public class SineGenerator extends AbstractGenerator {

    final static int MEASURES_PER_REVOLUTION = 1000;

    @Override
    public Double getSensorReading(final long readingCount) {

        final double factor = 2.0 * readingCount / MEASURES_PER_REVOLUTION;
        double value = Math.sin(factor * Math.PI);

        // round as I do not want too many decimals
        value = round(value, 9);

        // System.err.println("[SineGenerator] getSensorReading - " + factor + " :: " + value);

        return Double.valueOf(value);
    }

    @Override
    public String getSensorName() {
        return "sin";
    }

}
