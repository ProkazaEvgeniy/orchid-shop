package net.www.orchid.form;

import org.hibernate.validator.constraints.SafeHtml;

public class CategoryForm {
	
	@SafeHtml
	private String name;

	@SafeHtml
	private String url;

	public CategoryForm() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
