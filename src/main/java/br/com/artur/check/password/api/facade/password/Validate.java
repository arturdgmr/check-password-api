package br.com.artur.check.password.api.facade.password;

public interface Validate {
    Boolean isValid(String passwd);
    Boolean getReturnNotValid(String passwd);
    Boolean execute(String passwd);
    Validate nextValidate(Validate nextValidate);
}
