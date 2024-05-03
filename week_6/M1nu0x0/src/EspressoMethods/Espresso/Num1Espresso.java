package EspressoMethods.Espresso;

import EspressoMethods.Extraction.AmericanExtraction;
import EspressoMethods.Extraction.AustriaExtraction;
import EspressoMethods.Extraction.EnglandExtraction;
import EspressoMethods.Extraction.Extraction;

public class Num1Espresso implements Espresso {
    @Override
    public void extractingMethods(Extraction ex) {
        System.out.printf("기본 추출 방식");
    }

    @Override
    public void extractingMethods(EnglandExtraction ex) {
        System.out.println("도징: 19g");
        System.out.println("추출시간: 26s");
        System.out.println("추출양: 34g");
        System.out.println("추출 완료: 영국식");
        System.out.println("Investigated by num1");
    }

    @Override
    public void extractingMethods(AustriaExtraction ex) {
        System.out.println("도징: 23g");
        System.out.println("추출시간: 30s");
        System.out.println("추출양: 25g");
        System.out.println("추출 완료: 호주식");
        System.out.println("Investigated by num1");
    }

    @Override
    public void extractingMethods(AmericanExtraction ex) {
        System.out.println("도징: 21g");
        System.out.println("추출시간: 25s");
        System.out.println("추출양: 32g");
        System.out.println("추출 완료: 미국식");
        System.out.println("Investigated by num1");
    }
}

