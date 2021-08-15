package br.com.artur.check.password.api.facade.password.validates;

import br.com.artur.check.password.api.facade.password.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpecialCharacterQuantityValidate extends ValidateTemplate {

    public static final String SPECIAL_CHARACTER = "!@#$%^&*()-+";

    @Override
    public Boolean isValid(String passwd) {
        return contains(passwd, i -> SPECIAL_CHARACTER.contains(Character.toString(i)));
    }

    @Override
    public Boolean getReturnNotValid(String passwd) {
        return false;
    }


}
