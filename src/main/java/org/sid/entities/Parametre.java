package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Parametre implements Serializable 
{
	//Attributs
		@Id
		@GeneratedValue
		private int id;
		private String nomContre , adresseContre  ;
		private int NTel , NFaxe ;
		@Temporal(javax.persistence.TemporalType.DATE)
		private Date dateDeb;
		
		//Constructer1
		public Parametre() 
		{
			super();
		}

		//Constructer2
		public Parametre(int id, String nomContre, String adresseContre, int nTel, int nFaxe, Date dateDeb) {
			super();
			this.id = id;
			this.nomContre = nomContre;
			this.adresseContre = adresseContre;
			NTel = nTel;
			NFaxe = nFaxe;
			this.dateDeb = dateDeb;
		}

		//Getter
		public int getId() {
			return id;
		}

		public String getNomContre() {
			return nomContre;
		}

		public String getAdresseContre() {
			return adresseContre;
		}

		public int getNTel() {
			return NTel;
		}

		public int getNFaxe() {
			return NFaxe;
		}

		public Date getDateDeb() {
			return dateDeb;
		}

		//Setter
		public void setId(int id) {
			this.id = id;
		}

		public void setNomContre(String nomContre) {
			this.nomContre = nomContre;
		}

		public void setAdresseContre(String adresseContre) {
			this.adresseContre = adresseContre;
		}

		public void setNTel(int nTel) {
			NTel = nTel;
		}

		public void setNFaxe(int nFaxe) {
			NFaxe = nFaxe;
		}

		public void setDateDeb(Date dateDeb) {
			this.dateDeb = dateDeb;
		}
		
		//ToString
		@Override
		public String toString() {
			return "Parametre [id=" + id + ", nomContre=" + nomContre + ", adresseContre=" + adresseContre + ", NTel="
					+ NTel + ", NFaxe=" + NFaxe + ", dateDeb=" + dateDeb + "]";
		}
		
}
