package br.com.artur.check.password.api.controller;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.exceptions.BusinessException;
import br.com.artur.check.password.api.exceptions.ErrorCodes;
import br.com.artur.check.password.api.facade.PasswordFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PasswordController.URL_API)
@AllArgsConstructor
public class PasswordController {
    public static final String URL_API = "/password";

    private final PasswordFacade passwordFacade;

    @GetMapping(path = {"/validation/{passwd}"})
    public ResponseEntity<PasswordValidationVO> isValidPassword(@PathVariable final String passwd){
        try {
            return ResponseEntity.ok(passwordFacade.getPasswordConstraints(passwd));
        } catch (Exception error) {
            throw new BusinessException("Não foi possível realizar a validação.", ErrorCodes.GENERIC_ERROR);
        }
    }
}
