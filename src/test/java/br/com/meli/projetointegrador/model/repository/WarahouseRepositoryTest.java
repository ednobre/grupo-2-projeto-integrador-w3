package br.com.meli.projetointegrador.model.repository;

import br.com.meli.projetointegrador.model.entity.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
public class WarahouseRepositoryTest {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @BeforeEach
    void setUp() {
        Warehouse warehouse = new Warehouse()
                .warehouseCode("SP")
                .warehouseName("sao paulo")
                .build();
        warehouseRepository.save(warehouse);
    }

    @AfterEach
    void cleanUpDatabase() {
        warehouseRepository.deleteAll();
    }

    @Test
    void findByWarehouseCodeTest() {
        final Optional<Warehouse> warehouse = warehouseRepository.findByWarehouseCode("SP");
        assertEquals(warehouse.orElse(new Warehouse()).getWarehouseCode(), "SP");
    }

    @Test
    void existsSectionBySectionCode() {
        assertTrue(warehouseRepository.existsByWarehouseCode("SP"));
    }

}