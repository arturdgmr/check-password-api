package br.com.artur.check.password.api.service.passwordvalitation.validates;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.passwordvalitation.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class BlankSpaceValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return !passwd.contains(" ");
    }

    @Override
    public PasswordValidationVO getReturnNotValid() {
        return PasswordValidationVO.invalidPassword();
    }
}
