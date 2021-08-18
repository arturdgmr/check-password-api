package br.com.artur.check.password.api.service.password;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;
import br.com.artur.check.password.api.service.password.validates.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordValidateExecutorChainTest {

    private final BlankSpaceValidate blankSpaceValidate = new BlankSpaceValidate();
    private final CharacterQuantityValidate characterQuantityValidate = new CharacterQuantityValidate();
    private final DigitsQuantityValidate digitsQuantityValidate = new DigitsQuantityValidate();
    private final LowerCaseQuantityValidate lowerCaseQuantityValidate = new LowerCaseQuantityValidate();
    private final RepeatedCharactersQuantityValidate repeatedCharactersQuantityValidate = new RepeatedCharactersQuantityValidate();
    private final SpecialCharacterQuantityValidate specialCharacterQuantityValidate = new SpecialCharacterQuantityValidate();
    private final UpperCaseQuantityValidate upperCaseQuantityValidate = new UpperCaseQuantityValidate();
    private final PasswordValidatesFinallyStepOK passwordValidatesFinallyStepOK = new PasswordValidatesFinallyStepOK();

    PasswordValidateExecutorChain passwordValidateExecutorChain =
            new PasswordValidateExecutorChain(
                    blankSpaceValidate,
                    characterQuantityValidate,
                    digitsQuantityValidate,
                    lowerCaseQuantityValidate,
                    repeatedCharactersQuantityValidate,
                    specialCharacterQuantityValidate,
                    upperCaseQuantityValidate,
                    passwordValidatesFinallyStepOK
            );

    @Test
    @DisplayName("should return false when password has blank space")
    public void blankSpaceValidateTest(){
        String passwd = "AbTp9 fok@";
        Assertions.assertEquals(passwordValidateExecutorChain.executeValidations(passwd), PasswordValidationVO.invalidPassword());
    }

    @Test
    @DisplayName("should return false when password is less than nine characters")
    public void characterQuantityValidateTest(){
        String passwd = "Abcd1@lk";
        Assertions.assertEquals(passwordValidateExecutorChain.executeValidations(passwd), PasswordValidationVO.invalidPassword());
    }

    @Test
    @DisplayName("should return false when the password has no digits")
    public void digitsQuantityValidateTest(){
        String passwd = "abcdefGH@!";
        Assertions.assertEquals(passwordValidateExecutorChain.executeValidations(passwd), PasswordValidationVO.invalidPassword());
    }

    @Test
    @DisplayName("should return false when the password has no lowercase letter")
    public void lowerCaseQuantityValidateTest(){
        String passwd = "ABCDEFGH@!1";
        Assertions.assertEquals(passwordValidateExecutorChain.executeValidations(passwd), PasswordValidationVO.invalidPassword());
    }

    @Test
    @DisplayName("should return false when password has repeated characters")
    public void repeatedCharactersQuantityValidateTest(){
        String passwd = "abcDEFGH@!1a";
        Assertions.assertEquals(passwordValidateExecutorChain.executeValidations(passwd), PasswordValidationVO.invalidPassword());
    }

    @Test
    @DisplayName("should return false when the password has no special characters")
    public void specialCharacterQuantityValidateTest(){
        String passwd = "abcDEFGH123";
        Assertions.assertEquals(passwordValidateExecutorChain.executeValidations(passwd), PasswordValidationVO.invalidPassword());
    }

    @Test
    @DisplayName("should return false when the password has no uppercase letter")
    public void upperCaseQuantityValidateValidateTest(){
        String passwd = "abcdefgh!@1";
        Assertions.assertEquals(passwordValidateExecutorChain.executeValidations(passwd), PasswordValidationVO.invalidPassword());
    }
}
