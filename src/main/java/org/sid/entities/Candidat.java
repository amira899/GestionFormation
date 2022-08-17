package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Candidat implements Serializable
{
	//Attributs
	  @Id
	    @GeneratedValue
		private Long id;
		private String nomPre,adresse,nationalite ;
		@NotEmpty 
		@Email
		private String email;
		//@NotEmpty 
		private long cin;
		private long numtel;
		 

		@DateTimeFormat(pattern="yyyy-MM-dd")
		private  Date datenais;
		//private String image;
		private String image;
		 
	@ManyToOne
	private Candidat formateurCandidat;
	
	//Mapping with Table Formateur
	  /* @ManyToOne
		private Formateur formateur;*/
	
	//Mapping With Table Inscription
	   @ManyToOne
	   private Inscription inscri ;
	   
	//Mapping With Table Formation
	@ManyToMany
	private List <Formation> form ;
	
	//Mapping With Table Cours
		@ManyToMany(mappedBy="candidat")
		private List <Cours> cours;
	//Getters & Setters

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNomPre() {
			return nomPre;
		}

		public void setNomPre(String nomPre) {
			this.nomPre = nomPre;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getNationalite() {
			return nationalite;
		}

		public void setNationalite(String nationalite) {
			this.nationalite = nationalite;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getCin() {
			return cin;
		}

		public void setCin(long cin) {
			this.cin = cin;
		}

		public long getNumtel() {
			return numtel;
		}

		public void setNumtel(long numtel) {
			this.numtel = numtel;
		}

		public Date getDatenais() {
			return datenais;
		}

		public void setDatenais(Date datenais) {
			this.datenais = datenais;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public Candidat getFormateurCandidat() {
			return formateurCandidat;
		}

		public void setFormateurCandidat(Candidat formateurCandidat) {
			this.formateurCandidat = formateurCandidat;
		}

		public Inscription getInscri() {
			return inscri;
		}

		public void setInscri(Inscription inscri) {
			this.inscri = inscri;
		}

		public List<Formation> getForm() {
			return form;
		}

		public void setForm(List<Formation> form) {
			this.form = form;
		}

		public List<Cours> getCours() {
			return cours;
		}

		public void setCours(List<Cours> cours) {
			this.cours = cours;
		}
	
	
	
}
