package io.com.github.leodqb.controler.erroscontroler;

import io.com.github.leodqb.model.excepionsapi.ErroNoProcessoDeSalvamentoException;
import io.com.github.leodqb.model.excepionsapi.erros.ErroClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExepitionCotrollerAdvice {

    @ExceptionHandler(ErroNoProcessoDeSalvamentoException.class)
    @ResponseStatus(HttpStatus.CREATED)
    public ErroClass handleErroNoProcessoDeSalvamentoException(ErroNoProcessoDeSalvamentoException erro) {
        return new ErroClass(erro.getMessage());
    }

}
