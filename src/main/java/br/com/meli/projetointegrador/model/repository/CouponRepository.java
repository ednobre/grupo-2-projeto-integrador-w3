package br.com.meli.projetointegrador.model.repository;

import br.com.meli.projetointegrador.model.entity.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Edemilson Nobre
 * @version 2.0.0
 * @since 22/11/2021
 * Repository para trabalhar como uma porta ou janela de acesso a
 * camada do banco da entity CouponRepository
 */
@Repository
public interface CouponRepository extends MongoRepository<Coupon, String> {
}
