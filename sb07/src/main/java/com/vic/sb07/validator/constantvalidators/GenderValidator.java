package com.vic.sb07.validator.constantvalidators;

import com.vic.sb07.validator.constraints.Gender;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Victor
 * date: 2019/5/8 19:03
 */
public class GenderValidator implements ConstraintValidator<Gender, Integer> {
    private Set<Integer> allowed = new HashSet<>(2);

    // 初始化允许校验通过的值
    @Override
    public void initialize(Gender gender) {
        for (int i : gender.allowed()) {
            allowed.add(i);
        }
    }
    // 执行校验
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return allowed.contains(value);
    }

}
