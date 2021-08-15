package br.com.artur.check.password.api.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordValidationVO implements Serializable {
    private Boolean isValid;

    public static PasswordValidationVO validPassword(){
        return PasswordValidationVO.builder()
                .isValid(true)
                .build();
    }

    public static PasswordValidationVO invalidPassword(){
        return PasswordValidationVO.builder()
                .isValid(false)
                .build();
    }
}
