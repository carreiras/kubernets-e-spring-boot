package carreiras.github.com.productapi.config;

import java.text.ParseException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import carreiras.github.com.productapi.service.DbService;
import lombok.RequiredArgsConstructor;

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
