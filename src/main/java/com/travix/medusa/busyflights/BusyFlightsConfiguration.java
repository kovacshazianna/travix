import com.travix.medusa.busyflights.service.FlightService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Anna on 2017.08.20..
 */
@Configuration
public class BusyFlightsConfiguration {
    @Bean
    public FlightService flightService() {
        return new FlightService();
    }
}
