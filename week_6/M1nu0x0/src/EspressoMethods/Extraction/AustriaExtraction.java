package EspressoMethods.Extraction;

import EspressoMethods.Espresso.Espresso;

public class AustriaExtraction implements Extraction {
    @Override
    public void extraction(Espresso espresso) {
        espresso.extractingMethods(this);
    }
}
