package br.com.artur.check.password.api.facade.password.validates;

import br.com.artur.check.password.api.facade.password.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class BlankSpaceValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return !passwd.contains(" ");
    }

    @Override
    public Boolean getReturnNotValid(String passwd) {
        return false;
    }
}