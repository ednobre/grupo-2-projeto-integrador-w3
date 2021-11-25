package br.com.meli.projetointegrador.model.service;

import br.com.meli.projetointegrador.model.dto.CouponDTO;
import br.com.meli.projetointegrador.model.entity.Buyer;
import br.com.meli.projetointegrador.model.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessException;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Edemilson Nobre
 * @version 2.0.0
 * @since 22/11/2021
 * Camada de testes unitarios do service responsavel pela regra de negocio relacionada ao agent
 */
public class CouponServiceTest {

    private final CouponRepository mockCouponRepository = mock(CouponRepository.class);
    private final CouponService couponService = new CouponService(mockCouponRepository);

    @Test
    void validaCouponSalvoTest() {
        Buyer buyerEd = new Buyer()
                .name("ednobre")
                .cpf("33333333333")
                .build();

        CouponDTO couponDTO = new CouponDTO()
                .codCoupon("AnoNovo")
                .percentage(15)
                .validity(LocalDate.now().plusWeeks(1))
                .quantityUse(3)
                .description("CUPOM DE TESTE 15%")
                .build();


        String menssagemEsperada = "Cupom cadastrado, codigo: "
               .concat(couponDTO.getCodCoupon().concat(couponDTO.getPercentage().toString()));

        assertTrue(menssagemEsperada.contains(couponService.save(couponDTO,buyerEd.getCpf())));
    }

    @Test
    void validaExceptionTest() {
        Buyer buyerEd = new Buyer()
                .name("ednobre")
                .cpf("33333333333")
                .build();

        CouponDTO couponDTO = new CouponDTO()
                .codCoupon("AnoNovo")
                .percentage(15)
                .validity(LocalDate.now().plusWeeks(1))
                .quantityUse(3)
                .description("CUPOM DE TESTE 15%")
                .build();

        when(mockCouponRepository.save(any()))
                .thenThrow(new DataAccessException(""){});

        DataAccessException dataAccessException = assertThrows
                (DataAccessException.class,() ->
                        couponService.save(couponDTO,buyerEd.getCpf()));

        String menssagemEsperada = "Este Cupom ja foi cadastrado";

        assertTrue(menssagemEsperada.contains(Objects.requireNonNull(dataAccessException.getMessage())));
    }
}
