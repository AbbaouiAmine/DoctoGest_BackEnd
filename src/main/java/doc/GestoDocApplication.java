package doc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import doc.dao.RoleRepository;
import doc.entities.Role;
import doc.service.AccountService;

@SpringBootApplication
public class GestoDocApplication implements CommandLineRunner{

	@Autowired
	AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestoDocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===============================START=======================================");
		accountService.save(new Role(null,"ADMIN"));
		accountService.save(new Role(null,"USER"));
		accountService.saveUser("user","user","user@mail.com", "1234","USER",true,new Date(),"","","","","");
		accountService.saveUser("admin","admin","admin@gmail.com","1234","ADMIN",true,new Date(),"","","","","");		
	}

}
