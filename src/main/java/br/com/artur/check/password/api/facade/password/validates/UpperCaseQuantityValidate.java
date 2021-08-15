package br.com.artur.check.password.api.facade.password.validates;

import br.com.artur.check.password.api.facade.password.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseQuantityValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return true;
    }

    @Override
    public Boolean getReturnNotValid(String passwd) {
        return false;
    }

    @Override
    public Boolean execute(String passwd) {
        return contains(passwd, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }
}
