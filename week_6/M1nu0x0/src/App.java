import java.util.ArrayList;
import java.util.List;

import EspressoMethods.Espresso.Espresso;
import EspressoMethods.Espresso.M1nuEspresso;
import EspressoMethods.Espresso.Num1Espresso;
import EspressoMethods.Extraction.AmericanExtraction;
import EspressoMethods.Extraction.AustriaExtraction;
import EspressoMethods.Extraction.EnglandExtraction;
import EspressoMethods.Extraction.Extraction;


public class App {
    public static void main(String[] args) throws Exception {
        // 미누와 누미의 추출법
        Espresso m1nu = new M1nuEspresso();
        Espresso num1 = new Num1Espresso();

        // 에스프레소 종류
        List<Extraction> espressoTypes = new ArrayList<>();
        espressoTypes.add(new EnglandExtraction());
        espressoTypes.add(new AustriaExtraction());
        espressoTypes.add(new AmericanExtraction());

        // 미누가 조사한 방식대로 추출
        for (Extraction espressoType : espressoTypes) {
            espressoType.extraction(m1nu);
            System.out.println();
        }

        // 누미가 조사한 방식대로 추출
        for (Extraction espressoType : espressoTypes) {
            espressoType.extraction(num1);
            System.out.println();
        }
    }
}