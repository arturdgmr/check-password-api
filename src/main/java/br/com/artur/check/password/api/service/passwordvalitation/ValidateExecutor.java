package br.com.artur.check.password.api.service.passwordvalitation;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;

public interface ValidateExecutor {
    PasswordValidationVO executeValidations(String passwdInfoValidate);
}
