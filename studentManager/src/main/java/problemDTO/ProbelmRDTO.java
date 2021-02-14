package problemDTO;

public class ProbelmRDTO {
	private String mScore = "0"; // 객관식 점수
	private String mPerfectScore; // 객관식 만점점수
	private String sScore = "0"; // 주관식 점수
	private String sPerfectScore; // 주관식 만점점수
	
	public String getmScore() {
		return mScore;
	}
	public void setmScore(String mScore) {
		this.mScore = mScore;
	}
	public String getmPerfectScore() {
		return mPerfectScore;
	}
	public void setmPerfectScore(String mPerfectScore) {
		this.mPerfectScore = mPerfectScore;
	}
	public String getsScore() {
		return sScore;
	}
	public void setsScore(String sScore) {
		this.sScore = sScore;
	}
	public String getsPerfectScore() {
		return sPerfectScore;
	}
	public void setsPerfectScore(String sPerfectScore) {
		this.sPerfectScore = sPerfectScore;
	}
	
	

}
