package br.com.meli.projetointegrador.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author  Edemilson Nobre
 * @version 5.0.0
 * Exception personalizada para cupom
 */
public class CouponException extends DataAccessException {
    public CouponException(String mensage){
        super(mensage);
    }
}
