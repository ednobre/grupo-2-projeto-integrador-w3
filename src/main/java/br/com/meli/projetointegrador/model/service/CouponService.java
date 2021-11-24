package br.com.meli.projetointegrador.model.service;

import Utils.ConstantsUtil;
import br.com.meli.projetointegrador.exception.CouponException;
import br.com.meli.projetointegrador.model.dto.CouponDTO;
import br.com.meli.projetointegrador.model.entity.Coupon;
import br.com.meli.projetointegrador.model.repository.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;



/**
 * @author  Edemilson Nobre
 * @version 5.0.0
 * Camada service responsavel pela regra de negocio relacionada a PromotionService
 * */
@Service
public class CouponService {

    private static final Logger logger = LoggerFactory.getLogger(CouponService.class);
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
    /**
     * @param couponDTO;
     * @param cpf, batchNumber;
     * @return String: se o cupom foi cadastrado con sucesso ou nao;
     */
    public String save(CouponDTO couponDTO, String cpf){
        Coupon coupon = new Coupon();

        coupon.codCoupon(couponDTO.getCodCoupon());
        coupon.validity(couponDTO.getValidity());
        coupon.percentage(couponDTO.getPercentage());
        coupon.quantityUse(couponDTO.getQuantityUse());
        coupon.initialQuantity(0);
        coupon.description(couponDTO.getDescription());
        coupon.cpfAgent(cpf);
        try {
            couponRepository.save(coupon);
        }catch (DataAccessException e){
            logger.error(ConstantsUtil.PERSISTENCE_ERROR, e);
            throw new CouponException("Este Cupom ja foi cadastrado");
        }
        return "Cupom cadastrado, codigo: ".concat(couponDTO.getCodCoupon().concat(couponDTO.getPercentage().toString()));
    }

}
