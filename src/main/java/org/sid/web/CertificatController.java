package org.sid.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.sid.dao.CertificatRepository;
import org.sid.dao.FormateurRepository;
import org.sid.entities.Certificat;
import org.sid.entities.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CertificatController 
{
	@Autowired
	private CertificatRepository certificatRepository;

	@Autowired
	private FormateurRepository formateurRepository;
	
	
		//****Supprimer Certificat****//
		@RequestMapping(value = "/admin/deleteCertificat", method = RequestMethod.GET)
		public String delete(Long idU) {
			
			Certificat c = certificatRepository.chercheAvecId(idU);
			System.out.println(c.toString());
				Formateur f = c.getFormateur();
				System.out.println("----------"+f.toString());
			certificatRepository.delete(idU);
			//return "redirect:/*/formateur";
			return "redirect:/admin/editFormateur?id="+f.getId();
		}
		
		//****Saisie un Certificat****//
		@RequestMapping(value = "/admin/saisieCertificat", method = RequestMethod.GET)
		public String saisieCertif(Model model ,Long idF)
		{
			System.out.println("crer C");
			Certificat c = new Certificat();
			Formateur f = formateurRepository.chercherId(idF);
			System.out.println("Formateur "+f.toString());
			c.setFormateur(f);
			//System.out.println(c.toString());
			model.addAttribute("certificat",c);
			return "Administrateur/GestionFormateurs/SaisieCertificat";
		}


			//****Inserer Certificat a la Base****//
		@RequestMapping(value = "/admin/saveCertificat", method = RequestMethod.POST)
		public String ajouterCertificat(Model model, @Valid Certificat certificat  ,Long idF, BindingResult bindingResult) 
		{
	
				System.out.println(idF);
				Formateur f = formateurRepository.chercherId(idF);
				if(certificat.equals(null))
				{
					System.out.println("--------"+f.getNomPre()+"  a une Certificat----------");
					certificat.setFormateur(f);
					certificatRepository.save(certificat);
					return "redirect:/admin/saisieExperience?idF="+f.getId();
				}
				else
				{
					System.out.println("--------Pas de Certificat----------");
					return "redirect:/admin/saisieCertificat?idF="+f.getId();
				}
				
		}
			
		//****Ajouter autre certificat****//
			@RequestMapping(value = "/admin/ajoutCertificat", method = RequestMethod.GET)
			public String AjouterCertif(Model model ,Long idF) {
				System.out.println("crer C");
				Certificat c = new Certificat();
				Formateur f = formateurRepository.chercherId(idF);
				System.out.println("Formateur "+f.toString());
				c.setFormateur(f);
				//System.out.println(c.toString());
				model.addAttribute("certificat",c);
				return "Administrateur/GestionFormateurs/AjoutCertificat";
			}

			
			//****entregistrer nouveau certificat****//S
			@RequestMapping(value = "/admin/saveCertificatModif", method = RequestMethod.POST)
			public String ajouterCertificatEnModif(Model model, @Valid Certificat certificat  ,Long idF, BindingResult bindingResult) {
				
					System.out.println(idF);
					Formateur f = formateurRepository.chercherId(idF);
					if(certificat.getAnnee()==null||certificat.getSpecialite().equals(null)||certificat.getNom().equals(null))
					{
						System.out.println("--------Pas de Certificat----------");
						return "redirect:/admin/editFormateur?id="+f.getId();
						
					}
					else
					{
						System.out.println("--------"+f.getNomPre()+"  a une Certificat----------");
						certificat.setFormateur(f);
						certificatRepository.save(certificat);
						return "redirect:/admin/editFormateur?id="+f.getId();
					}
					
			}
			
	
}