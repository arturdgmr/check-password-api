package br.com.artur.check.password.api.facade.password.validates;

import br.com.artur.check.password.api.facade.password.ValidateTemplate;
import org.springframework.stereotype.Component;


@Component
public class RepeatedCharactersQuantityValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        //TODO implementar logica caracters repetidos
        return true;
    }

    @Override
    public Boolean getReturnNotValid(String passwd) {
        return false;
    }
}
