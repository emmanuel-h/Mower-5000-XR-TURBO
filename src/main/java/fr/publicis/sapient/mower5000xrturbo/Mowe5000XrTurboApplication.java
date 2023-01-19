package fr.publicis.sapient.mower5000xrturbo;

import fr.publicis.sapient.mower5000xrturbo.game.FileReader;

import java.io.IOException;

public class Mowe5000XrTurboApplication {

    public static void main(String[] args) throws IOException {
        new FileReader().read("src/main/resources/input");
    }

}
