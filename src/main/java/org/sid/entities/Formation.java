package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Formation implements Serializable
{
	//Attributs
	@Id
	private String nom;
	private String specialite;
	private int duree,nbrCand;
	private double prix;
	private String certifie;

	
	//Mapping with Table Formateur
	@ManyToOne
	private Formateur formateurFormation;
	
	//Mapping With Table Candidat
	@ManyToMany(mappedBy="form")
		private List <Candidat> candidat ;
	
	//Mapping With Table Cours
	@OneToMany(mappedBy="formation")
	private List <Cours> cours ;
	
	
	
	//Mapping With Table Examen
		@OneToMany(mappedBy="formation")
		private List <Examen> examen ;
		
		//Mapping With Table Devis
		@OneToMany(mappedBy="formation")
		private List <Devis> devis ;
		
		
		
	//Getters & Setters
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
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getNbrCand() {
		return nbrCand;
	}
	public void setNbrCand(int nbrCand) {
		this.nbrCand = nbrCand;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getCertifie() {
		return certifie;
	}
	public void setCertifie(String certifie) {
		this.certifie = certifie;
	}
	@Override
	public String toString() {
		return "Formation [nom=" + nom + ", specialite=" + specialite + ", duree=" + duree + ", nbrCand=" + nbrCand
				+ ", prix=" + prix + ", certifie=" + certifie + ", formateurFormation=" + formateurFormation
				+ ", candidat=" + candidat + ", cours=" + cours + ", examen=" + examen + ", devis="
				+ devis + "]";
	}
	
	
}
