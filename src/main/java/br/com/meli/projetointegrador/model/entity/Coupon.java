package br.com.meli.projetointegrador.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

/**
 * @author  Edemilson Nobre
 * @version 5.0.0
 * @since 20/11/2021
 * Objeto criado para o Coupon e seus atributos
 */

@Data
@Document(collection = "coupon")
@CompoundIndexes({
        @CompoundIndex(name = "coupon_percentage", def = "{'codCoupon' : 1, 'percentage' : 1}", unique = true)
})
public class Coupon {

    @MongoId(FieldType.OBJECT_ID)
    @Setter(AccessLevel.NONE)
    private String id;

    private String codCoupon;
    private LocalDate validity;
    private Integer percentage;
    private Integer quantityUse;
    private Integer initialQuantity;
    private String description;
    private String cpfAgent;

    public Coupon id(String id) {
        this.id = id;
        return this;
    }

    public Coupon codCoupon(String codCoupon) {
        this.codCoupon = codCoupon;
        return this;
    }

    public Coupon  validity(LocalDate validity) {
        this.validity = validity;
        return this;
    }

    public Coupon percentage(Integer percentage) {
        this.percentage = percentage;
        return this;
    }

    public Coupon quantityUse(Integer quantityUse) {
        this.quantityUse = quantityUse;
        return this;
    }

    public Coupon initialQuantity(Integer initialQuantity) {
        this.initialQuantity = initialQuantity;
        return this;
    }

    public Coupon description(String description) {
        this.description = description;
        return this;
    }

    public Coupon cpfAgent(String cpfAgent) {
        this.cpfAgent = cpfAgent;
        return this;
    }

    public Coupon build(){ return this; }
}
