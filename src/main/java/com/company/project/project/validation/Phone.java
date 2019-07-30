package com.company.project.project.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
public @interface Phone {
	String message() default "{constraint.not.phone}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String field() default "";
	
	String regex() default "^1[3|4|5|6|7|8|9]\\d{9}$";
	/**
	 * 是否判断空值
	 * @return
	 */
	boolean checkBlank() default false;
}
