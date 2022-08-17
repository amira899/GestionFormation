package org.sid;

import org.sid.dao.FormateurRepository;
import org.sid.dao.UtilisateurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestionDeCentreDeFormationApplication {

	public static void main(String[] args) {
		//SpringApplication.run(GestionDeCentreDeFormationApplication.class, args);
		
		
		ApplicationContext ctx= SpringApplication.run(GestionDeCentreDeFormationApplication.class, args);
		UtilisateurRepository utilisateurRepository = ctx.getBean(UtilisateurRepository.class);
		FormateurRepository formateur = (FormateurRepository) ctx.getBean(FormateurRepository.class);
	}
}
