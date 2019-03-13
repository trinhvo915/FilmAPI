package enclave.com.dto;

public class RateDTO {
	private float score;

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public RateDTO(float score) {
		super();
		this.score = score;
	}

	public RateDTO() {
	}
}