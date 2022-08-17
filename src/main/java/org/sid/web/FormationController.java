package org.sid.web;

import java.io.IOException;

import javax.validation.Valid;


import org.sid.dao.FormationRepository;
import org.sid.entities.Formateur;
import org.sid.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FormationController 
{
	
	@Autowired
	private FormationRepository formationRepository;
	
	@RequestMapping(value = "/*/formation")
	public String afficher(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
		@RequestParam(name = "size", defaultValue = "5") int s,
		@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Formation> pageFormations = formationRepository.chercher("%" + mc + "%", new PageRequest(p, s));
		model.addAttribute("Listeformations", pageFormations.getContent());
		int[] pages = new int[pageFormations.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		return "Administrateur/GestionFormation/Formations";
	}
	
	@RequestMapping(value = "/admin/deleteFormation", method = RequestMethod.GET)
	public String delete(String idU, String motCle, int page, int size) {
		formationRepository.delete(idU);
		//return "redirect:/*/formateur";
		return "redirect:/*/formation?page=" + page + "&size=" + size + "&motCle=" + motCle;
	}
	
	@RequestMapping(value = "/admin/editFormation", method = RequestMethod.GET)
	public String editUtilisateur(Model model, String id) {
		Formation f = formationRepository.chercherId(id);
		model.addAttribute("formation", f);
		return "Administrateur/GestionFormation/ModifierFormation";
	}
	
	@RequestMapping(value = "/admin/saisieFormation", method = RequestMethod.GET)
	public String saisieUtilisateur(Model model) {
		model.addAttribute("formation", new Formation());
		return "Administrateur/GestionFormation/SaisieFormation";
	}
	
	@RequestMapping(value = "/admin/saveFormation", method = RequestMethod.POST)
	// @valid pour confirmer les attribut , BindingResult collection pour stock
	// les erreurs
	public String ajouterFormation(Model model, @Valid Formation  formation , BindingResult bindingResult ) throws  IOException
		{
	if (bindingResult.hasErrors())
		{
		System.out.println("-------------"+bindingResult.getObjectName());
			return "Administrateur/GestionFormation/SaisieFormation";
		}
				formationRepository.save(formation);
				return "redirect:/*/formation";
		}
	
	@RequestMapping(value = "/admin/updateFormation", method = RequestMethod.POST)
	// @valid pour confirmer les attribut , BindingResult collection pour stock
	// les erreurs
	public String modifier(Model model, @Valid Formation  formation , BindingResult bindingResult ) throws  IOException
	{
			if (bindingResult.hasErrors())
				{
					System.out.println("-------------"+bindingResult.getObjectName());
						return "Administrateur/GestionFormation/ModifierFormation";
				}
			System.out.println(formation.toString());
			formationRepository.save(formation);
			return "redirect:/*/formation";
	}
}