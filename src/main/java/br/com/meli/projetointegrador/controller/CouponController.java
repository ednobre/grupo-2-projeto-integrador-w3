package br.com.meli.projetointegrador.controller;


import br.com.meli.projetointegrador.model.dto.AgentDTO;
import br.com.meli.projetointegrador.model.dto.CouponDTO;
import br.com.meli.projetointegrador.model.service.AgentService;
import br.com.meli.projetointegrador.model.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


/**
 * @author  Edemilson Nobre
 * @version 5.0.0
 * Camada de controller responsavel pela regra de negocio relacionada ao CouponController
 */
@Controller
@RestController
@RequestMapping("/api/v1/fresh-products")
public class CouponController {

    private final CouponService couponService;
    private final AgentService agentService;

    public CouponController(CouponService couponService, AgentService agentService) {
        this.couponService = couponService;
        this.agentService = agentService;
    }

    /**
     * @param couponDTO, dados da coupon
     * @param uriComponentsBuilder
     * @return ResponseEntity.created com valor total e status 201, caso nao exista notifique a situacao.
     * requisito 6 - endpoint 1: Registre uma cupom.
     */
    @PostMapping(value = "/coupon", produces = "application/json")
    public ResponseEntity<String> post(@Valid @RequestBody CouponDTO couponDTO, UriComponentsBuilder uriComponentsBuilder){
        final AgentDTO agentDTO = agentService.findByCpf("33333333333");
        String retorno = couponService.save(couponDTO,"33333333333");
        URI uri = uriComponentsBuilder.path("/coupon/1").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }

}
