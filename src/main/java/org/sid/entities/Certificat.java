package org.sid.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Certificat implements Serializable 
{
	//Attributs
	@Id
	@GeneratedValue
	private Long id;
	private String nom,specialite;
	//@Temporal(javax.persistence.TemporalType.DATE)
	private String annee;
	
	//Mapping With Table Formateur
	@ManyToOne 
	
	private Formateur formateur; 
	  
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	//Geters & Setters
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
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	@Override
	public String toString() {
		return "Certificat [id=" + id + ", nom=" + nom + ", specialite=" + specialite + ", annee=" + annee
				+ ", formateur=" + formateur.getId() + "]";
	}

	

}
