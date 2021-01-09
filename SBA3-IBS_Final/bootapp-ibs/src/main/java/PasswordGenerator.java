import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String Password="admin";
		String encodedPassword=encoder.encode(Password);
		System.out.println(encodedPassword);

	}

}
