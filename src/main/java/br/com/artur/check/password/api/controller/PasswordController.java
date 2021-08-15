package br.com.artur.check.password.api.controller;

import br.com.artur.check.password.api.facade.PasswordFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PasswordController.URL_API)
@AllArgsConstructor
public class PasswordController {

    public static final String URL_API = "/password";

    private final PasswordFacade passwordFacade;

    @GetMapping("/teste")
    public boolean isValidPassword(){
        return passwordFacade.getPasswordConstraints("aAaaaa1aa@");
    }
}
