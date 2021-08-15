package br.com.artur.check.password.api.facade.password.validates;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.facade.password.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class DigitsQuantityValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return contains(passwd, Character::isDigit);
    }

    @Override
    public PasswordValidationVO getReturnNotValid() {
        return PasswordValidationVO.invalidPassword();
    }
}
