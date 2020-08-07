package io.com.github.leodqb.model.excepionsapi;

public class ErroNoProcessoDeSalvamentoException extends RuntimeException {
    public ErroNoProcessoDeSalvamentoException() {
        super("erro Ao Realizar processo de salvamento da entidade no Bd");
    }

    public ErroNoProcessoDeSalvamentoException(String message) {
        super(message);
    }
}
