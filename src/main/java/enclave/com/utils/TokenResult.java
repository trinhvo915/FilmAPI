package enclave.com.utils;

public class TokenResult {
	private String success;
	private String error;

	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public TokenResult(String success, String error) {
		super();
		this.success = success;
		this.error = error;
	}
	public TokenResult(String success) {
		super();
		this.success = success;
	}

	public TokenResult() {
		super();
	}
}
