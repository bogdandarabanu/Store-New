package Store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "storePackage")
public class StoreProjectNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreProjectNewApplication.class, args);
	}

}
