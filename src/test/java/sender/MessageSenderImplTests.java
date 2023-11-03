package sender;

import entity.Country;
import entity.Location;
import geo.GeoService;
import i18n.LocalizationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTests {

    @Test
    void test_if_ip_172() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.168.12.85"))
                .thenReturn(new Location("Sochi", Country.RUSSIA, "Roz", 117));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> params = new HashMap<>();
        params.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.168.12.85");

        String result = messageSender.send(params);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, result);

    }

    @Test
    void test_if_ip_is_not_172() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, "Broadway", 5));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> params = new HashMap<>();
        params.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String result = messageSender.send(params);
        String expected = "Welcome";
        Assertions.assertEquals(expected, result);
    }

}
