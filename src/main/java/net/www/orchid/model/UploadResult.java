package net.www.orchid.model;

import java.io.Serializable;

import net.www.orchid.model.AbstractModel;

public class UploadResult extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 6777278132063596897L;

	private String url;

	public UploadResult() {
		super();
	}

	public UploadResult(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
