package br.com.artur.check.password.api.service.password.validates;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.password.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class CharacterQuantityValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return passwd.length() > 8;
    }

    @Override
    public PasswordValidationVO getReturnNotValid() {
        return PasswordValidationVO.invalidPassword();
    }
}
