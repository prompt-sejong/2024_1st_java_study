package EspressoMethods.Espresso;

import EspressoMethods.Extraction.AmericanExtraction;
import EspressoMethods.Extraction.AustriaExtraction;
import EspressoMethods.Extraction.EnglandExtraction;
import EspressoMethods.Extraction.Extraction;

public class M1nuEspresso implements Espresso {
    @Override
    public void extractingMethods(Extraction ex) {
        System.out.printf("기본 추출 방식");
    }

    @Override
    public void extractingMethods(EnglandExtraction ex) {
        System.out.println("도징: 19g");
        System.out.println("추출시간: 30s");
        System.out.println("추출양: 40g");
        System.out.println("추출 완료: 영국식");
        System.out.println("Investigated by m1nu");
    }

    @Override
    public void extractingMethods(AustriaExtraction ex) {
        System.out.println("도징: 20g");
        System.out.println("추출시간: 30s");
        System.out.println("추출양: 45g");
        System.out.println("추출 완료: 호주식");
        System.out.println("Investigated by m1nu");
    }

    @Override
    public void extractingMethods(AmericanExtraction ex) {
        System.out.println("도징: 19g");
        System.out.println("추출시간: 27s");
        System.out.println("추출양: 38g");
        System.out.println("추출 완료: 미국식");
        System.out.println("Investigated by m1nu");
    }
}