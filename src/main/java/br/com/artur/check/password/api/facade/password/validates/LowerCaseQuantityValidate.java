package br.com.artur.check.password.api.facade.password.validates;

import br.com.artur.check.password.api.facade.password.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class LowerCaseQuantityValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return contains(passwd, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    @Override
    public Boolean getReturnNotValid(String passwd) {
        return false;
    }
}
