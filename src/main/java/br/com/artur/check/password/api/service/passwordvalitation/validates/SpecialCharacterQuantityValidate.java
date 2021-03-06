package br.com.artur.check.password.api.service.passwordvalitation.validates;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.passwordvalitation.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpecialCharacterQuantityValidate extends ValidateTemplate {

    public static final String SPECIAL_CHARACTER = "!@#$%^&*()-+";

    @Override
    public Boolean isValid(String passwd) {
        return contains(passwd, i -> SPECIAL_CHARACTER.contains(Character.toString(i)));
    }

    @Override
    public PasswordValidationVO getReturnNotValid() {
        return PasswordValidationVO.invalidPassword();
    }
}
