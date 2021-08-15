package br.com.artur.check.password.api.facade.impl;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.facade.PasswordFacade;
import br.com.artur.check.password.api.facade.ValidateExecutor;
import org.springframework.stereotype.Component;

@Component
public class PasswordFacadeImpl implements PasswordFacade {

    ValidateExecutor validateExecutor;

    public PasswordFacadeImpl(ValidateExecutor validateExecutor){
        this.validateExecutor = validateExecutor;
    }

    @Override
    public PasswordValidationVO getPasswordConstraints(String passwd) {
        return validateExecutor.executeValidations(passwd);
    }
}
