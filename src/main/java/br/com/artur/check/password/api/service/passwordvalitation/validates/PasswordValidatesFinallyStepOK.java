package br.com.artur.check.password.api.service.passwordvalitation.validates;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.passwordvalitation.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidatesFinallyStepOK extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return true;
    }

    @Override
    public PasswordValidationVO getReturnNotValid() {
        return PasswordValidationVO.invalidPassword();
    }

    @Override
    public PasswordValidationVO execute(String passwd) {
        return PasswordValidationVO.validPassword();
    }
}
