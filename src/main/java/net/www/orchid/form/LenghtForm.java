package net.www.orchid.form;

import org.hibernate.validator.constraints.SafeHtml;

public class LenghtForm {

	@SafeHtml
	private Integer name;
	
	public LenghtForm() {
		super();
	}
	
	public Integer getName() {
		return name;
	}
	
	public void setName(Integer name) {
		this.name = name;
	}
}
