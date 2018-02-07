package net.www.orchid.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.www.orchid.annotation.constraints.CustomSafeHTML;

public class CustomSafeHTMLConstraintValidator implements ConstraintValidator<CustomSafeHTML, String> {

	private boolean withPunctuations;
	private boolean withSpechSymbols;
	
	@Override
	public void initialize(CustomSafeHTML constraintAnnotation) {
		this.withPunctuations = constraintAnnotation.withPunctuations();
		this.withSpechSymbols = constraintAnnotation.withSpechSymbols();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		String validationTemplate = getValidationTemplate();
		for(int i=0;i<value.length();i++){
			char ch = value.charAt(i);
			if(validationTemplate.indexOf(ch) == -1) {
				return false;
			}
		}
		return true;
	}
	
	private static final String SPETCH_SYMBOLS = "~#$%^&*-+=_\\|/@`!'\";:><,.?{}";
	private static final String PUNCTUATIONS = ".,?!-:()'\"[]{}; \t\n";
	private static final String NUMBERS = "0123456789";
	
	private String getValidationTemplate(){
		StringBuilder template = new StringBuilder(NUMBERS);
		if(withPunctuations) {
			template.append(PUNCTUATIONS);
		}
		if(withSpechSymbols) {
			template.append(SPETCH_SYMBOLS);
		}
		return template.toString();
	}
	
}
