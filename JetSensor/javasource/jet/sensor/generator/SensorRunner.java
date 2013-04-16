package jet.sensor.generator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SensorRunner {

    private final List<AbstractGenerator> generators = new ArrayList<>();
    private SensorConfiguration sensorConfiguration;

    public SensorRunner() {

        readConfiguration();
        createSensors();
        startSensors();

        boolean running = true;
        while (running) {
            if (isWorkDone()) {
                running = false;
            } else {
                try {
                    Thread.sleep(500);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void readConfiguration() {
        try (InputStream inStream = new FileInputStream("sensor.properties")) {
            final Properties properties = new Properties();
            properties.load(inStream);

            this.sensorConfiguration = new SensorConfiguration(properties);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isWorkDone() {
        boolean result = true;
        for (final AbstractGenerator generator : this.generators) {
            final boolean isFinished = generator.isFinished();
            result = result && isFinished;
        }
        return result;
    }

    public void createSensors() {
        this.generators.add(new CosineGenerator(this.sensorConfiguration));
        this.generators.add(new SineGenerator(this.sensorConfiguration));
    }

    public void startSensors() {
        for (final AbstractGenerator generator : this.generators) {
            new Thread(generator).start();
        }
    }

}
