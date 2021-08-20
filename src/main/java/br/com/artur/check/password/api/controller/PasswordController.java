package br.com.artur.check.password.api.controller;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.exceptions.BusinessException;
import br.com.artur.check.password.api.exceptions.ErrorCodes;
import br.com.artur.check.password.api.service.PasswordService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PasswordController.URL_API)
@AllArgsConstructor
public class PasswordController {
    public static final String URL_API = "/password";

    private final PasswordService passwordService;

    @GetMapping(path = {"/validation/{passwd}"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "502", description = "Falha de conex\u00E3o com o servi\u00E7o")
    })
    public ResponseEntity<PasswordValidationVO> isValidPassword(@PathVariable final String passwd){
        try {
            return ResponseEntity.ok(passwordService.getPasswordConstraints(passwd));
        } catch (Exception error) {
            throw new BusinessException("Não foi possível realizar a validação.", ErrorCodes.GENERIC_ERROR);
        }
    }
}
