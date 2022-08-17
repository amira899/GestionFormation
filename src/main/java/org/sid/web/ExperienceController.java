package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.ExperienceRepository;
import org.sid.dao.FormateurRepository;
import org.sid.entities.Diplome;
import org.sid.entities.Experience;
import org.sid.entities.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExperienceController 
{
	@Autowired
	ExperienceRepository experienceRepository ;
	@Autowired
	private FormateurRepository formateurRepository;
	
	@RequestMapping(value = "/admin/saisieExperience", method = RequestMethod.GET)
	public String saisieUtilisateur(Model model,Long idF) {
		System.out.println("crer D");
		Experience e = new Experience();
		Formateur f = formateurRepository.chercherId(idF);
		System.out.println("Formateur "+f.toString());
		e.setFormateur(f);
		//System.out.println(e.toString());
		model.addAttribute("experience",e);
		return "Administrateur/GestionFormateurs/SaisieExperience";
	}


			
			@RequestMapping(value = "/admin/saveExperience", method = RequestMethod.POST)
		// @valid pour confirmer les attribut , BindingResult collection pour stock
		// les erreurs
		public String ajouterUtilisateur(Model model, @Valid Experience experience,Long idF, BindingResult bindingResult) {
			
				System.out.println(idF);
				Formateur f = formateurRepository.chercherId(idF);
				if(experience.equals(null))
				{
					//return "redirect:/*/formateur";
					return "redirect:/admin/saisieExperience?idF="+f.getId();
				}
				else
				{
					experience.setFormateur(f);
					experienceRepository.save(experience);
					return "redirect:/*/formateur";
				}
				
				
			
		}
			
			@RequestMapping(value = "/admin/AjouterExperience", method = RequestMethod.GET)
			public String saisieExperience(Model model,Long idF) {
				
				Experience e = new Experience();
				Formateur f = formateurRepository.chercherId(idF);
				System.out.println("Formateur "+f.toString());
				e.setFormateur(f);
				//System.out.println(e.toString());
				model.addAttribute("experience",e);
				return "Administrateur/GestionFormateurs/AjoutExperience";
			}


					
					@RequestMapping(value = "/admin/saveExperienceModif", method = RequestMethod.POST)
				// @valid pour confirmer les attribut , BindingResult collection pour stock
				// les erreurs
				public String ajouterExperience(Model model, @Valid Experience experience,Long idF, BindingResult bindingResult) {
					
						System.out.println(idF);
						Formateur f = formateurRepository.chercherId(idF);
						if(experience.equals(null))
						{
							
							return "redirect:/admin/editFormateur?id="+f.getId();
							
						}
						else
						{
							
							experience.setFormateur(f);
							experienceRepository.save(experience);
							return "redirect:/admin/editFormateur?id="+f.getId();
						}
						
						
						
					
				}
}