package carreiras.github.com.productapi.config;

import carreiras.github.com.productapi.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
@RequiredArgsConstructor
public class DbConfig {

    private final DbService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }
}
