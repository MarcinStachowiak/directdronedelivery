package directdronedelivery.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import directdronedelivery.configuration.keys.ProfileKey;
import directdronedelivery.dao.CargoDao;
import directdronedelivery.dao.DroneDao;
import directdronedelivery.dao.FlightDao;
import directdronedelivery.dao.WeatherDao;
import directdronedelivery.dao.impl.JpaCargoDaoImpl;
import directdronedelivery.dao.impl.JpaDroneDaoImpl;
import directdronedelivery.dao.impl.JpaFlightDaoImpl;
import directdronedelivery.dao.impl.JpaWeatherDaoImpl;

@Profile(ProfileKey.MOCK_DAO)
@Configuration
public class DaoMockConfiguration {

    @Bean
    @Primary
    public DroneDao prepareDroneDaoMock() {
        return Mockito.mock(JpaDroneDaoImpl.class);
    }

    @Bean
    @Primary
    public FlightDao prepareFlightDaoMock() {
        return Mockito.mock(JpaFlightDaoImpl.class);
    }

    @Bean
    @Primary
    public CargoDao prepareCargoDaoMock() {
        return Mockito.mock(JpaCargoDaoImpl.class);
    }

    @Bean
    @Primary
    public WeatherDao prepareWeatherDaoMock() {
        return Mockito.mock(JpaWeatherDaoImpl.class);
    }
}
