package br.com.artur.check.password.api.service;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;

public interface PasswordService {
    PasswordValidationVO getPasswordConstraints(String passwd);
}
