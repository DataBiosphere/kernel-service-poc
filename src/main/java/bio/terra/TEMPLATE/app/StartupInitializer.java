package bio.terra.TEMPLATE.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public final class StartupInitializer {
    private static final Logger logger = LoggerFactory.getLogger(StartupInitializer.class);

    private StartupInitializer() {
    }

    public static void initialize(ApplicationContext applicationContext) {
        // TODO: Fill in this method with any initialization that needs to happen
        //  between the point of having the entire application initialized and
        //  the point of opening the port to start accepting REST requests.
    }
}
