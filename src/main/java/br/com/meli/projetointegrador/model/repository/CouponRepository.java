package br.com.meli.projetointegrador.model.repository;

import br.com.meli.projetointegrador.model.entity.Coupon;
import br.com.meli.projetointegrador.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends MongoRepository<Coupon, String>{

    Optional<Coupon> findByCouponCod(String couponCod);
    List<Coupon> findListCouponCod(String couponCod);
}
