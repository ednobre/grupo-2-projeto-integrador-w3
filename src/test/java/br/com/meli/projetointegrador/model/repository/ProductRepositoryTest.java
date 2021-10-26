package br.com.meli.projetointegrador.model.repository;

import br.com.meli.projetointegrador.model.entity.Product;
import br.com.meli.projetointegrador.model.entity.Section;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jhony Zuim / Lucas Pereira / Edmilson Nobre / Rafael Vicente
 * @version 1.0.0
 * @since 15/10/2021
 * Repository de teste para trabalhar como uma porta ou janela de acesso a camada do banco da entity product
 */

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SectionRepository sectionRepository;

    @BeforeEach
    void setUp() {
//        Section section = new Section()
//                .sectionCode("LA")
//                .sectionName("Laticionios")
//                .maxLength(10)
//                .build();
//
//        Product product = new Product()
//                .productCode("LEI")
//                .productName("Leite")
//                .section(section)
//                .build();
//
//        sectionRepository.save(section);
//        productRepository.save(product);
    }

    @AfterEach
    void cleanUpDataBase(){
//        sectionRepository.deleteAll();
//        productRepository.deleteAll();
    }

    @Test
    void findBySection(){
        Optional<Section> section = sectionRepository.findBySectionCode("LA");
//        Optional<Product> productOptional = productRepository.findBySection(section.get());
//        assertTrue(productOptional.isPresent());
    }

//    @Test
//    void existsProductBySectionTest() {
//        final Optional<Section> section = sectionRepository.findBySectionCode("FR");
//        final Boolean existProduct = productRepository.existsProductBySection(section.orElse(new Section()));
//        assertTrue(existProduct);
//    }
}