package br.com.artur.check.password.api.service.passwordvalitation;

import br.com.artur.check.password.api.controller.vo.PasswordValidationVO;

import java.util.function.IntPredicate;

public abstract class ValidateTemplate implements Validate{

    protected Validate nextValidate;

    public abstract Boolean isValid(String passwd);
    public abstract PasswordValidationVO getReturnNotValid();

    @Override
    public PasswordValidationVO execute(String passwd) {
        if(isValid(passwd))
            return this.nextValidate.execute(passwd);
        return getReturnNotValid();
    }

    @Override
    public ValidateTemplate nextValidate(Validate nextValidate) {
        this.nextValidate = nextValidate;
        return this;
    }

    public ValidateTemplate doFinally(Validate finalOK) {
        this.nextValidate = finalOK;
        return this;
    }

    protected static boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }
}
