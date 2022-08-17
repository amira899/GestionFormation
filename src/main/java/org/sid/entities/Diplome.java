package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;




@Entity
public class Diplome implements Serializable
{	
	//Attributs
	@Id
	@GeneratedValue
	private Long id;
	private String nom,universite;
	//@Temporal(javax.persistence.TemporalType.DATE)
	private String annee;
	
	
	//Mapping With Table Formateur
		@ManyToOne 
		//@JoinColumn(name="ID_FORM")
		private Formateur formateur; 
		  
		public Formateur getFormateur() {
			return formateur;
		}
		public void setFormateur(Formateur formateur) {
			this.formateur = formateur;
		}
		  
	
	public Diplome(String nom, String universite, String annee) {
		super();
		this.nom = nom;
		this.universite = universite;
		this.annee = annee;
	}
	public Diplome(){}
	
	//Getters & Setter
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getUniversite() {
		return universite;
	}
	public void setUniversite(String universite) {
		this.universite = universite;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	

	

	//ToString 
	@Override
	public String toString() {
		return "Diplome [id=" + id + ", nom=" + nom + ", universite=" + universite + ", annee=" + annee + 
				", formateur="+
			formateur.getId()	 + "]";
	}
	

	
	
}
