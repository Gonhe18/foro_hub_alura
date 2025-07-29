package challenge.alura.foro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ForoApplication {
	public static void main(String[] args) {
		String rawPassword = "123456";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode(rawPassword);
		System.out.println(hashedPassword);

		SpringApplication.run(ForoApplication.class, args);
	}

}
