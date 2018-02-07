package net.www.orchid.form;

import org.hibernate.validator.constraints.SafeHtml;

public class ProducerForm {

	@SafeHtml
	private String name;
	
	public ProducerForm() {
		super();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
