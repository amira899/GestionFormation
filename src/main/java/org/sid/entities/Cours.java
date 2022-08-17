package org.sid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Cours implements Serializable
{
	//Attributs
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	
	//Mapping With Table Formateur
	@ManyToOne
	private Formateur formateurCours;
	
	//Mapping With Table Formation
		@ManyToOne
		private Formation formation;
	
	//Mapping With Table Candidat
		@ManyToMany
		private List<Candidat> candidat ;
		
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
