package net.codejava.my_spring_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import net.codejava.my_spring_app.Entities.Produit;

@SpringBootApplication
public class MySpringAppApplication implements CommandLineRunner{

	//injection de dépendance
	private final RepositoryRestConfiguration repositoryRestConfiguration;

	MySpringAppApplication(RepositoryRestConfiguration repositoryRestConfiguration) {
		this.repositoryRestConfiguration = repositoryRestConfiguration;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
	}

}
