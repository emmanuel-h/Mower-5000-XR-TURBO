package fr.publicis.sapient.mower5000xrturbo.game;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileReaderTest {

    @Test
    void whenInputFileShouldBeRead_thenMowersShouldGoToTheirFinalDestinations() throws Exception {
        String text = tapSystemOut(() -> new FileReader().read("src/main/resources/input"));
        assertTrue(text.contains("1 3 N") && text.contains("5 1 E"));
    }

}
