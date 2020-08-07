package io.com.github.leodqb.model.excepionsapi.erros;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ErroClass {
    private List<String> erro;

    public ErroClass(List<String> erro) {
        this.erro = erro;
    }

    public ErroClass(String erro) {
        this.erro = Arrays.asList(erro);
    }
}
