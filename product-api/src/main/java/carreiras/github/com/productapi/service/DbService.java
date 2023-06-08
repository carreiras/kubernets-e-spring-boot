package carreiras.github.com.productapi.service;

import carreiras.github.com.productapi.entity.Category;
import carreiras.github.com.productapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class DbService {

    private final CategoryRepository categoryRepository;

    public void instantiateTestDatabase() throws ParseException {
        Category category1 = Category.builder().id(1L).nome("Eletrônico").build();
        Category category2 = Category.builder().id(2L).nome("Móveis").build();
        Category category3 = Category.builder().id(3L).nome("Brinquedos").build();

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    }
}
