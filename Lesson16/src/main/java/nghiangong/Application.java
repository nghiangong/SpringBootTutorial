package nghiangong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private AppProperties appProperties;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Chạy khi ứng dụng khởi động
	@Override
	public void run(String... args) {
		System.out.println("Global variable:");
		System.out.println("\t Email: " + appProperties.getEmail());
		System.out.println("\t GA ID: " + appProperties.getGoogleAnalyticsId());
		System.out.println("\t Authors: " + appProperties.getAuthors());
		System.out.println("\t Example Map: " + appProperties.getExampleMap());
	}
}
