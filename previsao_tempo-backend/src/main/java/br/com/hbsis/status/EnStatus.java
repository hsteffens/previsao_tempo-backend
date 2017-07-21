package br.com.hbsis.status;

public enum EnStatus {

	SUCCESS("success"),
	WARNING("warning"),
	ERROR("error");
	
	private String status;

	private EnStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	
}
