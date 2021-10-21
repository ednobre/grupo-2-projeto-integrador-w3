package br.com.meli.projetointegrador.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author Jhony Zuim
 * @version 1.0.0
 * @since 15/10/2021
 */

@Data
@Document(collection = "product")
public class Product {

    @MongoId(FieldType.OBJECT_ID)
    @Setter(AccessLevel.NONE)
    private String id;

    private String productCode;
    private String productName;
    private Section section;

    /**
     * @author Jhony Zuim
     * Construcao de construtores fluentes para a classe produto
     */

    public Product id(String id) {
        this.id = id;
        return this;
    }

    public Product productCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public Product productName(String productName) {
        this.productName = productName;
        return this;
    }

    public Product section(Section section) {
        this.section = section;
        return this;
    }

    public Product build(){
        return this;
    }
}
