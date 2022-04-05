package bean;

public class LoginInfo {

	private String userid;
	private String password;

	public LoginInfo() {
		String userid = null;
		String password = null;

	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public String getPassword() {
		return password;
	}
}
