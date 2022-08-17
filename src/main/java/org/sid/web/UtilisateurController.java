
package org.sid.web;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.sid.dao.UtilisateurRepository;
import org.sid.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@RequestMapping(value = "/*/user")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "5") int s,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Utilisateur> pageUtilisateurs = utilisateurRepository.chercher("%" + mc + "%", new PageRequest(p, s));
		// appeler couche metier et recuperer la liste et stocker dans model
		// avec le nom listUtilisateur
		model.addAttribute("ListUtilisateurs", pageUtilisateurs.getContent());
		int[] pages = new int[pageUtilisateurs.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "Administrateur/GestionRole/utilisateurs";
	}

	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public String delete(Long idU, String motCle, int page, int size) {
		utilisateurRepository.delete(idU);
		return "redirect:/*/user?page=" + page + "&size=" + size + "&motCle=" + motCle;
	}


	@RequestMapping(value = "/admin/saisie", method = RequestMethod.GET)
	public String saisieUtilisateur(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "Administrateur/GestionRole/SaisieUtilisateur";
	}

	@RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
	public String editUtilisateur(Model model, Long idU) {
		Utilisateur u = utilisateurRepository.findOne(idU);
		//u.setPassword(getEncodedPassword(u.getPassword()));
		model.addAttribute("utilisateur", u);
		return "Administrateur/GestionRole/EditUtilisateur";
	}

	 //Crypter Mot de passe
    public static String getEncodedPassword(String key) {
	  byte[] uniqueKey = key.getBytes();
	  byte[] hash = null;
	  try 
          {
		hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
	  }
          catch (NoSuchAlgorithmException e) {
		throw new Error("no MD5 support in this VM");
	  }
	  StringBuffer hashString = new StringBuffer();
	  for ( int i = 0; i < hash.length; ++i ) {
		String hex = Integer.toHexString(hash[i]);
		if ( hex.length() == 1 ) {
		  hashString.append('0');
		  hashString.append(hex.charAt(hex.length()-1));
		} else {
		  hashString.append(hex.substring(hex.length()-2));
		}
	  }
	  return hashString.toString();
	}
    //Fin Crypter
	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	// @valid pour confirmer les attribut , BindingResult collection pour stock
	// les erreurs
	public String ajouterUtilisateur(Model model, @Valid Utilisateur utilisateur, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "Administrateur/GestionRole/SaisieUtilisateur";
		
		utilisateur.setPassword(getEncodedPassword(utilisateur.getPassword()));
		utilisateurRepository.save(utilisateur);
		return "redirect:/*/user";
	}
	
	@RequestMapping(value = "/verif", method = RequestMethod.GET)
	// @valid pour confirmer les attribut , BindingResult collection pour stock
	// les erreurs
	public String Verifier( String login , String password) {
		
		System.out.println(login+"------"+password);
		String mdp = getEncodedPassword(password);
		Utilisateur u = utilisateurRepository.recherche(login, mdp);
		if(u==null)
		{
			return "Administrateur/SeConnecter";
		}
		else
		{
			return"Administrateur/Index";
		}
		
	}
	
	
	@RequestMapping(value="/getPhotoUser",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(String id) throws Exception
	{
		
		File f = new File("D:/SFE2017/img/"+id);
		System.out.println("====> "+"D:/SFE2017/img/"+id);
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	

	// action par defeaut
		@RequestMapping(value = "/")
		public String home() {
			return "Administrateur/SeConnecter";
		}

		@RequestMapping(value = "/deconnecter", method = RequestMethod.GET)
		// @valid pour confirmer les attribut , BindingResult collection pour stock
		// les erreurs
		public String log( ) {
	
			{
				return "Administrateur/SeConnecter";
			}
			
			
		}
		
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		// @valid pour confirmer les attribut , BindingResult collection pour stock
		// les erreurs
		public String index() {
	
			{
				return "Administrateur/Index";
			}
			
			
		}
}
