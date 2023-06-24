package carreiras.github.com.productapi.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import carreiras.github.com.productapi.domain.entity.Category;
import carreiras.github.com.productapi.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DbService {

    private final CategoryRepository categoryRepository;

    public void instantiateTestDatabase() throws ParseException {
        Category category1 = Category.builder().id(1L).name("Eletrônico").build();
        Category category2 = Category.builder().id(2L).name("Móveis").build();
        Category category3 = Category.builder().id(3L).name("Brinquedos").build();
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    }
}
