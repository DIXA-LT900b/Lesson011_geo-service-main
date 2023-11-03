package i18n;

import entity.Country;
import org.junit.jupiter.api.Test;

public class LocalizationServiceImplTests {

    @Test
    void test_locale(){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String resultRU = localizationService.locale(Country.RUSSIA);
        String resultUSA = localizationService.locale(Country.USA);
        String resultBRA = localizationService.locale(Country.BRAZIL);

        String expectedRU = "Добро пожаловать";
        String expectedEN = "Welcome";

        assert resultRU.equals(expectedRU);
        assert resultUSA.equals(expectedEN);
        assert resultBRA.equals(expectedEN);

    }
}
