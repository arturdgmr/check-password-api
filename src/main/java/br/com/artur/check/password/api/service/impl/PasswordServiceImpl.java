package br.com.artur.check.password.api.service.impl;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.PasswordService;
import br.com.artur.check.password.api.service.passwordvalitation.ValidateExecutor;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    ValidateExecutor validateExecutor;

    public PasswordServiceImpl(ValidateExecutor validateExecutor){
        this.validateExecutor = validateExecutor;
    }

    @Override
    public PasswordValidationVO getPasswordConstraints(String passwd) {
        return validateExecutor.executeValidations(passwd);
    }
}
