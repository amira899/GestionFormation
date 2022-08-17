package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.DiplomeRepository;
import org.sid.dao.FormateurRepository;
import org.sid.entities.Certificat;
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
public class DiplomeController 
{
	@Autowired
	private DiplomeRepository diplomeRepository;
	@Autowired
	private FormateurRepository formateurRepository;
	
	
	
	
	@RequestMapping(value = "/admin/deleteDiplome", method = RequestMethod.GET)
	public String delete(Long idU) {
		Diplome c = diplomeRepository.chercheAvecId(idU);
		System.out.println(c.toString());
			Formateur f = c.getFormateur();
			System.out.println("----------"+f.toString());
		diplomeRepository.delete(idU);
		//return "redirect:/*/formateur";
		return "redirect:/admin/editFormateur?id="+f.getId();
	}
	
	@RequestMapping(value = "/admin/saisieDiplome", method = RequestMethod.GET)
	public String saisieUtilisateur(Model model,Long idF) {
		System.out.println("crer D");
		Diplome c = new Diplome();
		Formateur f = formateurRepository.chercherId(idF);
		System.out.println("Formateur "+f.toString());
		c.setFormateur(f);
		model.addAttribute("diplome",c);
		return "Administrateur/GestionFormateurs/SaisieDiplome";
	}


			
			@RequestMapping(value = "/admin/saveDiplome", method = RequestMethod.POST)
		// @valid pour confirmer les attribut , BindingResult collection pour stock
		// les erreurs
		public String ajouterUtilisateur(Model model, @Valid Diplome diplome,Long idF, BindingResult bindingResult) {
			
				System.out.println(idF);
				
				Formateur f = formateurRepository.chercherId(idF);
				if(diplome.equals(null))
				{
					System.out.println("---------null---------");
					return"redirect:/admin/saisieCertificat?idF="+idF;
				}
				
					//System.out.println("----->>"+diplome.toString());
					diplome.setFormateur(f);
					diplomeRepository.save(diplome);
					//return "redirect:/*/formateur";
					return"redirect:/admin/saisieDiplome?idF="+idF;
				
			
			
		}
			
			@RequestMapping(value = "/admin/AjouterDiplome", method = RequestMethod.GET)
			public String saisieDiplomeModif(Model model,Long idF) {
				System.out.println("crer D");
				Diplome c = new Diplome();
				Formateur f = formateurRepository.chercherId(idF);
				System.out.println("Formateur "+f.toString());
				c.setFormateur(f);
				//System.out.println(c.toString());
				model.addAttribute("diplome",c);
				return "Administrateur/GestionFormateurs/AjoutDiplome";
			}


					
					@RequestMapping(value = "/admin/saveDiplomeModif", method = RequestMethod.POST)
				// @valid pour confirmer les attribut , BindingResult collection pour stock
				// les erreurs
				public String ajouterDiplomeModif(Model model, @Valid Diplome diplome,Long idF, BindingResult bindingResult) {
					
						System.out.println(idF);
						Formateur f = formateurRepository.chercherId(idF);
						if(diplome.equals(null))
						{
							
							return "redirect:/admin/editFormateur?id="+f.getId();
							
						}
						else
						{
							diplome.setFormateur(f);
							diplomeRepository.save(diplome);
							return "redirect:/admin/editFormateur?id="+f.getId();
						}
						
					
				}
}