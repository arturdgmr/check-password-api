package br.com.artur.check.password.api.service.password;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;

public interface Validate {
    Boolean isValid(String passwd);
    PasswordValidationVO getReturnNotValid();
    PasswordValidationVO execute(String passwd);
    Validate nextValidate(Validate nextValidate);
}
