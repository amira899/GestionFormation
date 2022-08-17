package org.sid.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.sid.dao.CandidatRepository;
import org.sid.entities.Candidat;
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
public class CandidatController 
{
	@Autowired
	private CandidatRepository candidatRepository;
	
	
	
	//Afficher Liste
	@RequestMapping(value = "/*/candidat")
	public String afficher(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
		@RequestParam(name = "size", defaultValue = "5") int s,
		@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Candidat> pageCandidat = candidatRepository.chercher("%" + mc + "%", new PageRequest(p, s));
		
		model.addAttribute("ListeCandidat", pageCandidat.getContent());
		int[] pages = new int[pageCandidat.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "Administrateur/GestionCandidats/Candidats";
	}

	//Supprimer Formateur
	@RequestMapping(value = "/admin/deleteCandidat", method = RequestMethod.GET)
	public String delete(Long idU, String motCle, int page, int size) {
		candidatRepository.delete(idU);
		//return "redirect:/*/formateur";
		return "redirect:/*/candidat?page=" + page + "&size=" + size + "&motCle=" + motCle;
	}
	
	//REdirect Ajouter Nouveau Formateur
	@RequestMapping(value = "/admin/saisieCandidat", method = RequestMethod.GET)
	public String saisieUtilisateur(Model model) {
		model.addAttribute("candidat", new Candidat());
		return "Administrateur/GestionCandidats/SaisieCandidat";
	}

	//Confirmer l'ajout d'unformateur
	@RequestMapping(value = "/admin/saveCandidat", method = RequestMethod.POST)
	public String ajouterUtilisateur(Model model, @Valid Candidat candidat , BindingResult bindingResult ,@RequestParam (name="picture") MultipartFile file) throws  IOException
		{
			if (bindingResult.hasErrors())
			{
				System.out.println("-------------"+bindingResult.getObjectName());
				return "Administrateur/GestionFormateurs/SaisieCandidat";
			}
	
		
			if(!(file.isEmpty()))
			{
				System.out.println("---------------------------------------------------");
				candidat.setImage(file.getOriginalFilename());
				//System.out.println("=>"+file.getOriginalFilename());
				file.transferTo(new File("C:/MALEK/img/"+file.getOriginalFilename()));
			}
			
			candidatRepository.save(candidat);
			//return "redirect:/*/formateur";
			return "redirect:/*/candidat";
		
		}
	
		//Modifier Formateur
		@RequestMapping(value = "/admin/editCandidat", method = RequestMethod.GET)
		public String editUtilisateur(Model model, Long id) 
		{
			Candidat c  = candidatRepository.chercherId(id);
			model.addAttribute("candidat", c);
			
			return "Administrateur/GestionCandidats/ModifierCandidat";
		}

			
		@RequestMapping(value = "/admin/updateCandidat", method = RequestMethod.POST)
		public String modifier(Model model, @Valid Candidat  formateur , BindingResult bindingResult ,@RequestParam (name="picture") MultipartFile file) throws  IOException
		{
				if (bindingResult.hasErrors())
				{
					System.out.println("-------------"+bindingResult.getObjectName());
					return "Administrateur/GestionCandidats/ModifierCandidat";
				}
		
				if(!(file.isEmpty()))
					{
						System.out.println("---------------------------------------------------");
						formateur.setImage(file.getOriginalFilename());
						//System.out.println("=>"+file.getOriginalFilename());
						file.transferTo(new File("C:/MALEK/img/"+file.getOriginalFilename()));
					}
					System.out.println(formateur.toString());
					candidatRepository.save(formateur);
					return "redirect:/*/candidat";
		}
				

			
			@RequestMapping(value="/getPhotoCandidat",produces=MediaType.IMAGE_JPEG_VALUE)
			@ResponseBody
			public byte[] getPhoto(String id) throws Exception
			{
				
				File f = new File("C:/MALEK/img/"+id);
				//System.out.println("====> "+"D:/SFE2017/img/"+id);
				return IOUtils.toByteArray(new FileInputStream(f));
			}
			
			
			
			@RequestMapping(value = "/admin/SuiviCandidat", method = RequestMethod.GET)
			public String SuiviFormateur(Model model, Long id) {
				Candidat f = candidatRepository.chercherId(id);
				//System.out.println(f.toString());	
				model.addAttribute("formateur", f);
					
				return "Administrateur/GestionFormateurs/SuiviFormateur";
			}
			
			
		
		

}