package passwordencoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

  public static void main(String[] args) {
	String password = "qqqqqqqq";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		for(int i = 1; i< 10; i++) {
			String hashedPassword = passwordEncoder.encode(password);
	
			System.out.println(hashedPassword);
		}
	
		
		String encode = "$2a$10$iZIk3FMSY09Eq2nSEKfpTOxm8aG8QXqAgHoYyIvtLIGgdNfzc.URm";
		
		System.out.println(passwordEncoder.matches("12345678", encode));
  }
}