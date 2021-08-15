package br.com.artur.check.password.api.facade.password;

import java.util.function.IntPredicate;

public abstract class ValidateTemplate implements Validate{

    protected Validate nextValidate;

    public abstract Boolean isValid(String passwd);
    public abstract Boolean getReturnNotValid(String passwd);

    @Override
    public Boolean execute(String passwd) {
        if(isValid(passwd))
            return this.nextValidate.execute(passwd);
        return getReturnNotValid(passwd);
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
