package br.com.artur.check.password.api.service.passwordvalitation;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.passwordvalitation.validates.*;
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
    private final PasswordValidatesFinallyStepOK passwordValidatesFinallyStepOK;

    @Override
    public PasswordValidationVO executeValidations(String passwdInfoValidate) {
        return blankSpaceValidate
                .nextValidate(characterQuantityValidate
                .nextValidate(digitsQuantityValidate
                .nextValidate(lowerCaseQuantityValidate
                .nextValidate(repeatedCharactersQuantityValidate
                .nextValidate(specialCharacterQuantityValidate
                .nextValidate(upperCaseQuantityValidate
                .doFinally(passwordValidatesFinallyStepOK)))))))
                .execute(passwdInfoValidate);
    }
}
