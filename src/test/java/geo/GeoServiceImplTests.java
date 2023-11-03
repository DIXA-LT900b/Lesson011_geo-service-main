package geo;

import entity.Country;
import entity.Location;
import org.junit.jupiter.api.Test;

public class GeoServiceImplTests {

    @Test
    void test_location_by_IP() {

        GeoServiceImpl geoService = new GeoServiceImpl();
        Location resultRU = geoService.byIp("172.199.1.54");

        Location expectedRU = new Location("Moscow", Country.RUSSIA, null, 0);

        assert expectedRU.getCountry().equals(resultRU.getCountry());
        assert expectedRU.getCity().equals(resultRU.getCity());
        assert resultRU.getStreet() == null;              // не смог сравнить через equals два null почему-то
        assert expectedRU.getBuiling() == resultRU.getBuiling();


        Location resultUSA = geoService.byIp("96.44.183.149");

        Location expectedUSA = new Location("New York", Country.USA, " 10th Avenue", 32);

        assert expectedUSA.getCountry().equals(resultUSA.getCountry());
        assert expectedUSA.getCity().equals(resultUSA.getCity());
        assert expectedUSA.getStreet().equals(resultUSA.getStreet());
        assert expectedUSA.getBuiling() == resultUSA.getBuiling();
    }
}
