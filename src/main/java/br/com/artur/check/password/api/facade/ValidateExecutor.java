package br.com.artur.check.password.api.facade;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;

public interface ValidateExecutor {
    PasswordValidationVO executeValidations(String passwdInfoValidate);
}
