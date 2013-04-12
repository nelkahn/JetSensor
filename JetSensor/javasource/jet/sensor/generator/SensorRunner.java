package jet.sensor.generator;

import java.util.ArrayList;
import java.util.List;

public class SensorRunner {

    private final List<AbstractGenerator> generators = new ArrayList<>();

    public SensorRunner() {
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

    private boolean isWorkDone() {
        boolean result = true;
        for (final AbstractGenerator generator : this.generators) {
            final boolean isFinished = generator.isFinished();
            result = result && isFinished;
        }
        return result;
    }

    public void createSensors() {
        this.generators.add(new CosineGenerator());
        this.generators.add(new SineGenerator());
    }

    public void startSensors() {
        for (final AbstractGenerator generator : this.generators) {
            new Thread(generator).start();
        }
    }

}
