package com.vic.sb07.validator.constraints;

import com.vic.sb07.validator.constantvalidators.GenderValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 性别校验
 * @author Victor
 * date: 2019/5/8 18:59
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {GenderValidator.class})
public @interface Gender {

    String message() default "{com.vic.sb07.validator.constraints.Gender.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    // 允许值(默认1男2女)。若使用方的性别枚举不同，可以通过该字段指定校验通过的值。
    int[] allowed() default {1, 2};

}
