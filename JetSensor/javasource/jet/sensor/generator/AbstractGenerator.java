package jet.sensor.generator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract generator.
 * 
 * @author daniel
 * 
 */
public abstract class AbstractGenerator implements Runnable {

    private boolean isFinished = false;

    /**
     * Get the sensor reading.
     * 
     * @param readingCount
     * @return sensor reading for count
     */
    public abstract Double getSensorReading(final long readingCount);

    /**
     * Get the sensor name.
     * 
     * @return Sensor name
     */
    public abstract String getSensorName();

    /**
     * Round to a given number of decimal places
     * 
     * @param val Value to round
     * @param places Decimal places
     * @return Rounded value
     */
    protected double round(final double val, final int places) {
        BigDecimal bd = new BigDecimal(Double.toString(val));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            final Double result = getSensorReading(i);
            System.err.println("[AbstractGenerator] run - " + getSensorName() + " :: " + i + " :: " + result);
        }
        this.isFinished = true;
    }

    /**
     * Has the sensor finished its work.
     * 
     * @return <code>true</code> if is finished
     */
    public boolean isFinished() {
        return this.isFinished;
    }
}
