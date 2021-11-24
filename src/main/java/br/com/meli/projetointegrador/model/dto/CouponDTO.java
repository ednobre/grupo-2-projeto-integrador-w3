package br.com.meli.projetointegrador.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author  Edemilson Nobre
 * @version 5.0.0
 * @since 20/11/2021
 * Objeto de Transferência de Dados do CouponDTO
*/
@Data
public class CouponDTO {

    @NotNull(message = "codCoupon cannot be null")
    @NotBlank(message = "codCoupon cannot be blank")
    @Size(min = 1, message = "codCoupon most be minimum size 1")
    private String codCoupon;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
    private LocalDate validity;
    private Integer percentage;
    private Integer quantityUse;

    private String description;

    public CouponDTO codCoupon(String codCoupon) {
        this.codCoupon = codCoupon;
        return this;
    }

    public CouponDTO validity(LocalDate validity) {
        this.validity = validity;
        return this;
    }

    public CouponDTO percentage(Integer percentage) {
        this.percentage = percentage;
        return this;
    }

    public CouponDTO quantityUse(Integer quantityUse) {
        this.quantityUse = quantityUse;
        return this;
    }

    public CouponDTO description(String description) {
        this.description = description;
        return this;
    }

    public CouponDTO build(){ return this; }
}
