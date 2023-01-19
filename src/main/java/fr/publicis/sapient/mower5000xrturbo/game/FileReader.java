package fr.publicis.sapient.mower5000xrturbo.game;

import fr.publicis.sapient.mower5000xrturbo.exceptions.CoordinatesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MowerFileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(MowerFileReader.class);

    public void read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input"))) {
            String line = reader.readLine();
            String[] gardenLength = line.split(" ");
            if (gardenLength.length != 2) {
                throw new CoordinatesException("First line of input should contains 2 elements, not " + gardenLength.length);
            }
            int xMax = Integer.parseInt(gardenLength[0]);
            int yMax = Integer.parseInt(gardenLength[1]);

            while ((line = reader.readLine()) != null) {
                String movements = reader.readLine();
                Mower mower = initializeMower(line, xMax, yMax);
                mower.move(movements);
                LOGGER.info(mower.toString());
            }
        }
    }

    private Mower initializeMower(String line, int xMax, int yMax) {
        String[] initialPosition = line.split(" ");
        if (initialPosition.length != 3) {
            throw new CoordinatesException("Initial position of a mower should contains 3 elements, not " + initialPosition.length);
        }
        int x = Integer.parseInt(initialPosition[0]);
        int y = Integer.parseInt(initialPosition[1]);
        char direction = initialPosition[2].charAt(0);
        return new Mower(xMax, yMax, x, y, direction);
    }
}
