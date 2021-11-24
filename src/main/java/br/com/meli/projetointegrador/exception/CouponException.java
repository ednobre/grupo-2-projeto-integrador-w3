package br.com.meli.projetointegrador.exception;

/**
 * @author  Edemilson Nobre
 * @version 5.0.0
 * Exception personalizada para cupom
 */
public class CouponException extends RuntimeException {
    public CouponException(String mensage){
        super(mensage);
    }
}
