package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Inscription implements Serializable 
{
	//Attributs
	@Id
	@GeneratedValue
	private int id;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateInscri;
	private double tva;
	//Mapping With Table Candidat
	@OneToMany(mappedBy="inscri")
	private List<Candidat> candidat ;

	//Constructor
	public Inscription(int id, Date dateInscri, List<Candidat> candidat) {
		super();
		this.id = id;
		this.dateInscri = dateInscri;
		this.candidat = candidat;
	}

	//Getters
	public int getId() {
		return id;
	}

	public Date getDateInscri() {
		return dateInscri;
	}

	public List<Candidat> getCandidat() {
		return candidat;
	}

	//Setter
	public void setId(int id) {
		this.id = id;
	}

	public void setDateInscri(Date dateInscri) {
		this.dateInscri = dateInscri;
	}

	public void setCandidat(List<Candidat> candidat) {
		this.candidat = candidat;
	}
	
	

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	//ToString
	@Override
	public String toString() {
		return "Inscription [id=" + id + ", dateInscri=" + dateInscri + ", candidat=" + candidat + "]";
	}
	
	

	
	
}
