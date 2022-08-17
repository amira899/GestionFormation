package org.sid.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.sid.dao.CertificatRepository;
import org.sid.dao.DiplomeRepository;
import org.sid.dao.ExperienceRepository;
import org.sid.dao.FormateurRepository;
import org.sid.entities.Certificat;
import org.sid.entities.Diplome;
import org.sid.entities.Experience;
import org.sid.entities.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FormateurController 
{
	@Autowired
	private FormateurRepository formateurRepository;
	
	@Autowired
	private DiplomeRepository diplomeRepository;
	
	@Autowired
	private CertificatRepository certificatRepository;
	
	@Autowired
	private ExperienceRepository experienceRepository;
	
	//Afficher Liste
	@RequestMapping(value = "/*/formateur")
	public String afficher(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
		@RequestParam(name = "size", defaultValue = "5") int s,
		@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Formateur> pageUtilisateurs = formateurRepository.chercher("%" + mc + "%", new PageRequest(p, s));
		
		model.addAttribute("Listeformateurs", pageUtilisateurs.getContent());
		int[] pages = new int[pageUtilisateurs.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "Administrateur/GestionFormateurs/Formateurs";
	}

	//Supprimer Formateur
	@RequestMapping(value = "/admin/deleteFormateur", method = RequestMethod.GET)
	public String delete(Long idU, String motCle, int page, int size) {
		formateurRepository.delete(idU);
		//return "redirect:/*/formateur";
		return "redirect:/*/formateur?page=" + page + "&size=" + size + "&motCle=" + motCle;
	}
	
	//REdirect Ajouter Nouveau Formateur
	@RequestMapping(value = "/admin/saisieFormateur", method = RequestMethod.GET)
	public String saisieUtilisateur(Model model) {
		model.addAttribute("formateur", new Formateur());
		return "Administrateur/GestionFormateurs/SaisieFormateur";
	}

	//Confirmer l'ajout d'unformateur
	@RequestMapping(value = "/admin/saveFormateur", method = RequestMethod.POST)
	public String ajouterUtilisateur(Model model, @Valid Formateur  formateur , BindingResult bindingResult ,@RequestParam (name="picture") MultipartFile file) throws  IOException
		{
			if (bindingResult.hasErrors())
			{
				System.out.println("-------------"+bindingResult.getObjectName());
				return "Administrateur/GestionFormateurs/SaisieFormateur";
			}
	
		
			if(!(file.isEmpty()))
			{
				System.out.println("---------------------------------------------------");
				formateur.setImage(file.getOriginalFilename());
				//System.out.println("=>"+file.getOriginalFilename());
				file.transferTo(new File("C:/MALEK/img/"+file.getOriginalFilename()));
			}
			
			formateurRepository.save(formateur);
			//return "redirect:/*/formateur";
			return "redirect:/admin/saisieDiplome?idF="+formateur.getId();
		
		}
	
		//Modifier Formateur
		@RequestMapping(value = "/admin/editFormateur", method = RequestMethod.GET)
		public String editUtilisateur(Model model, Long id) 
		{
			Formateur f = formateurRepository.chercherId(id);
			model.addAttribute("formateur", f);
			//lISTE DES DIPLOME
			ArrayList <Diplome>d ;
			d=  diplomeRepository.chercheDiplome(id);
			model.addAttribute("ListeDiplomes",d);
			
			//liste des Certificats
			ArrayList <Certificat>c ;
			c=  certificatRepository.chercheCertificat(id);
			model.addAttribute("ListeCertificats",c);
			
			//liste des Certificats
			ArrayList <Experience>ex ;
			ex = experienceRepository.chercheExperience(id);
			model.addAttribute("ListeExperience",ex);	
			return "Administrateur/GestionFormateurs/ModifierFormateur";
		}

			
		@RequestMapping(value = "/admin/updateFormateur", method = RequestMethod.POST)
		public String modifier(Model model, @Valid Formateur  formateur , BindingResult bindingResult ,@RequestParam (name="picture") MultipartFile file) throws  IOException
		{
				if (bindingResult.hasErrors())
				{
					System.out.println("-------------"+bindingResult.getObjectName());
					return "Administrateur/GestionFormateurs/ModifierFormateur";
				}
		
				if(!(file.isEmpty()))
					{
						System.out.println("---------------------------------------------------");
						formateur.setImage(file.getOriginalFilename());
						//System.out.println("=>"+file.getOriginalFilename());
						file.transferTo(new File("C:/MALEK/img/"+file.getOriginalFilename()));
					}
					System.out.println(formateur.toString());
					formateurRepository.save(formateur);
					return "redirect:/*/formateur";
		}
				

			
			@RequestMapping(value="/getPhoto",produces=MediaType.IMAGE_JPEG_VALUE)
			@ResponseBody
			public byte[] getPhoto(String id) throws Exception
			{
				
				File f = new File("C:/MALEK/img/"+id);
				//System.out.println("====> "+"D:/SFE2017/img/"+id);
				return IOUtils.toByteArray(new FileInputStream(f));
			}
			
			
			
			@RequestMapping(value = "/admin/SuiviFormateur", method = RequestMethod.GET)
			public String SuiviFormateur(Model model, Long id) {
				Formateur f = formateurRepository.chercherId(id);
				//System.out.println(f.toString());	
				model.addAttribute("formateur", f);
				//lISTE DES DIPLOME
				ArrayList <Diplome>d ;
				d=  diplomeRepository.chercheDiplome(id);
				model.addAttribute("ListeDiplomes",d);
				
				//liste des Certificats
				ArrayList <Certificat>c ;
				c=  certificatRepository.chercheCertificat(id);
				model.addAttribute("ListeCertificats",c);
				
				//liste des Certificats
				ArrayList <Experience>ex ;
				ex = experienceRepository.chercheExperience(id);
				model.addAttribute("ListeExperience",ex);		
				
				return "Administrateur/GestionFormateurs/SuiviFormateur";
			}
			
			
		
		

}