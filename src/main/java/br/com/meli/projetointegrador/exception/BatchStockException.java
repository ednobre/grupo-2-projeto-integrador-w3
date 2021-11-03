package br.com.meli.projetointegrador.exception;

/**
 * @author Jhony Zuim / Lucas Pereira / Edmilson Nobre / Rafael Vicente
 * @version 1.0.0
 * @since 15/10/2021
 * Exception personalizada para batchStock
 */

public class BatchStockException extends RuntimeException {

    public BatchStockException(String message) {
        super(message);
    }

}
