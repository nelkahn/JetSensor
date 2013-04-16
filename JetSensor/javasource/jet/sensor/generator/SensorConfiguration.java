package jet.sensor.generator;

import java.util.Properties;

import javax.annotation.Nonnull;

/**
 * Sensor configuration object.
 * 
 * @author daniel
 */
public class SensorConfiguration {

    public static final String DROPBOX_PATH = "dropbox.path";
    private final DropBox dropBox;

    /**
     * DropBox configuration element.
     */
    public static class DropBox {

        private final String path;

        /**
         * Constructor.
         * 
         * @param properties Properties where the configuration is to be found.
         */
        public DropBox(@Nonnull final Properties properties) {
            this.path = properties.getProperty(DROPBOX_PATH);
        }

        /**
         * Get the path to the dropbox folder.
         * 
         * @return path to the dropbox folder
         */
        public String getPath() {
            return this.path;
        }

    }

    /**
     * Constructor.
     * 
     * @param properties Properties where the configuration is to be found.
     */
    public SensorConfiguration(@Nonnull final Properties properties) {
        this.dropBox = new DropBox(properties);
    }

    /**
     * Get the dropbox configuration.
     * 
     * @return dropbox configuration
     */
    public DropBox getDropBox() {
        return this.dropBox;
    }

}
