package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Utilisateur implements Serializable{
	@Id
	@GeneratedValue
	private Long idU;
	//@NotNull
	@Size(min=3, max=15)
	private String nom;
	//@NotNull
	@Size(min=3, max=15)
	private String prenom;
	//@NotNull
	@Size(min=8, max=30)
	private String login;
	//@NotNull
	@Size(min=6, max=255)
	private String password;
	//@NotNull
	@Size(min=3, max=15)
	private String type;
	
	private String image;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(String nom, String prenom, String type, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
		this.login = login;
		this.password = password;
	}
	public Long getIdU() {
		return idU;
	}
	public void setIdU(Long idU) {
		this.idU = idU;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Utilisateur [idU=" + idU + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password="
				+ password + ", type=" + type + ", getIdU()=" + getIdU() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getType()=" + getType() + ", getLogin()=" + getLogin() + ", getPassword()="
				+ getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
