package EspressoMethods.Espresso;

import EspressoMethods.Extraction.AmericanExtraction;
import EspressoMethods.Extraction.AustriaExtraction;
import EspressoMethods.Extraction.EnglandExtraction;
import EspressoMethods.Extraction.Extraction;

public interface Espresso {
    public void extractingMethods(Extraction ex);
    public void extractingMethods(EnglandExtraction ex);
    public void extractingMethods(AustriaExtraction ex);
    public void extractingMethods(AmericanExtraction ex);
}