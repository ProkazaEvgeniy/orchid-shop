package net.www.orchid.annotation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import net.www.orchid.validator.CustomSafeHTMLConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { CustomSafeHTMLConstraintValidator.class })
public @interface CustomSafeHTML {
		
		//.,?!-:()'"[]{}; \t\n
		boolean withPunctuations() default true;
		
		//~#$%^&*-+=_\\|/@`!'\";:><,.?{}
		boolean withSpechSymbols() default true;
}
