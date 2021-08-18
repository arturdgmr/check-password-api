package br.com.artur.check.password.api.service;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;

public interface ValidateExecutor {
    PasswordValidationVO executeValidations(String passwdInfoValidate);
}
