package org.sid.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.List;

@Entity
public class Formateur implements Serializable
{
	//attributs

    @Id
    @GeneratedValue
	private Long id;
	private String nomPre,adresse,nationalite , specialite;
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
	 
	
	
	//Mapping With Table Diplome
	@OneToMany(mappedBy="formateur")
	private List<Diplome> diplome;
	
	//Mapping With Table Certificat
	@OneToMany(mappedBy="formateur")
    private List<Certificat> certificat ;
		
	//Mapping with Table Experience
	 
	 @OneToMany(mappedBy="formateur")
	    private List<Experience> experience ;
	 
	 //Mapping Whith Table Candidat
	 @OneToMany(mappedBy="formateurCandidat")
	   private List<Candidat> candidat;
	   
	 //Mapping Whith Table Formation
	   @OneToMany(mappedBy="formateurFormation")
	   private List<Formation> formation;
	   
	  //Mapping Whith Table Cours
	   @OneToMany(mappedBy="formateurCours")
	   private List<Cours> cours;
	   
	   //Mapping Whith Table Examen
	   @OneToMany(mappedBy="examen")
	   private List<Examen> examen;
	   
	 //Constructeur1
	public Formateur(Long id, String nomPre, String adresse, String email, String sexe, int cin, int numtel,
			Date datenais, String image, List<Diplome> diplome, List<Certificat> certificat,
			Exception experience)
	{
		super();
		this.id = id;
		this.nomPre = nomPre;
		this.adresse = adresse;
		this.email = email;
		this.nationalite = sexe;
		this.cin = cin;
		this.numtel = numtel;
		this.datenais = datenais;
		this.image = image;
		this.diplome = diplome;
		this.certificat = certificat;
	}
	
	
	//Constructeur2
	public Formateur(Long id, String nomPre, String adresse, String email, String sexe, long cin, long numtel,
			Date datenais, String image)
	{
		super();
		this.id = id;
		this.nomPre = nomPre;
		this.adresse = adresse;
		this.email = email;
		this.nationalite = sexe;
		this.cin = cin;
		this.numtel = numtel;
		this.datenais = datenais;
		this.image = image;
		
	}
	
	
	//Constructeur3
	public Formateur() {
		super();
	}
	
	
	//getters & setters
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String sexe) {
		this.nationalite = sexe;
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
	

	public List<Diplome> getDiplome() {
		return diplome;
	}

	public List<Certificat> getCertificat() {
		return certificat;
	}


	public void setDiplome(List<Diplome> diplome) {
		this.diplome = diplome;
	}

	public void setCertificat(List<Certificat> certificat) {
		this.certificat = certificat;
	}



	public String getSpecialite() {
		return specialite;
	}

	

	


	public List<Experience> getExperience() {
		return experience;
	}


	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", nomPre=" + nomPre + ", adresse=" + adresse + ", email=" + email + ", sexe="
				+ nationalite + ", specialite=" + specialite + ", cin=" + cin + ", numtel=" + numtel + ", datenais=" + datenais
				+ ", image=" + image +  ", diplome=" + diplome + ", certificat=" + certificat
				+ ", experience=" + experience + ", candidat=" + candidat + ", formation=" + formation + ", cours="
				+ cours + ", examen=" + examen + "]";
	}


	
	
	
	
	
}
