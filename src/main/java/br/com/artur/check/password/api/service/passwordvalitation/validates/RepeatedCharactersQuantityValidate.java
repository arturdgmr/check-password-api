package br.com.artur.check.password.api.service.passwordvalitation.validates;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.passwordvalitation.ValidateTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class RepeatedCharactersQuantityValidate extends ValidateTemplate {
    @Override
    public Boolean isValid(String passwd) {
        return !hasRepeatedCharacter(passwd);
    }

    @Override
    public PasswordValidationVO getReturnNotValid() {
        return PasswordValidationVO.invalidPassword();
    }

    public static Boolean hasRepeatedCharacter(String passwd) {
        Map<String, Integer> letters = new HashMap<>();
        for (int i = 0; i < passwd.length(); i++){
            char c = passwd.charAt(i);
            letters.merge(Character.toString(c), 1, Integer::sum);
        }
        return letters.values().stream().anyMatch(i -> i > 1);
    }
}
