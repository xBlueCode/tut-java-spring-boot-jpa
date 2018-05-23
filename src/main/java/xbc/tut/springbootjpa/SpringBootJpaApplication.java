package xbc.tut.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xbc.tut.springbootjpa.demo.Demo;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {

	@Autowired @Qualifier("courseDemo")
	Demo demo ;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    demo.startDemo();
  }
}