package challenge.alura.foro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ForoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ForoApplication.class, args);
	}

}
