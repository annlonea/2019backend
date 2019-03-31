package model;
import org.apache.commons.codec.digest.DigestUtils;

public class password {
	
	public static String encPassword (String ogPassword) {
		String password;
		password = DigestUtils.sha256Hex(ogPassword);
		return password;
	} 

	public static boolean matchPassword(String testPw, String truePw) {
		if (testPw != null && !"".equals(testPw)) {
			String password = encPassword(testPw);
			return truePw.equals(password);
		} 
		else{
			return false;
		}
	}


}
