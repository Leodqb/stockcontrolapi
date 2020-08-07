package io.com.github.leodqb.model.excepionsapi;

public class FornecedorServiceErroException extends RuntimeException {
    public FornecedorServiceErroException(String s) {
        super(s);
    }

    public FornecedorServiceErroException() {
        super("erro de regra de negocio");
    }
}
