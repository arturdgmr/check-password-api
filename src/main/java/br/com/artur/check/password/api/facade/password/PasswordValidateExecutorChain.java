package br.com.artur.check.password.api.facade.password;

import br.com.artur.check.password.api.facade.ValidateExecutor;
import br.com.artur.check.password.api.facade.password.validates.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordValidateExecutorChain implements ValidateExecutor {

    private final BlankSpaceValidate blankSpaceValidate;
    private final CharacterQuantityValidate characterQuantityValidate;
    private final DigitsQuantityValidate digitsQuantityValidate;
    private final LowerCaseQuantityValidate lowerCaseQuantityValidate;
    private final RepeatedCharactersQuantityValidate repeatedCharactersQuantityValidate;
    private final SpecialCharacterQuantityValidate specialCharacterQuantityValidate;
    private final UpperCaseQuantityValidate upperCaseQuantityValidate;

    @Override
    public Boolean executeValidations(String passwdInfoValidate) {
        return blankSpaceValidate
                .nextValidate(characterQuantityValidate
                .nextValidate(digitsQuantityValidate
                .nextValidate(lowerCaseQuantityValidate
                .nextValidate(repeatedCharactersQuantityValidate
                .nextValidate(specialCharacterQuantityValidate
                .doFinally(upperCaseQuantityValidate))))))
                .execute(passwdInfoValidate);
    }
}
