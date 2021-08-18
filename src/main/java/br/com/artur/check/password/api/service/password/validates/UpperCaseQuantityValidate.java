package br.com.artur.check.password.api.service.password.validates;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.password.ValidateTemplate;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseQuantityValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return contains(passwd, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    @Override
    public PasswordValidationVO getReturnNotValid() {
        return PasswordValidationVO.invalidPassword();
    }
}
