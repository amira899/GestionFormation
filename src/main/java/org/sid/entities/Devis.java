package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Devis  implements Serializable
{
	//Attributs
	@Id
	private int idDevis;
	private int pourcentage ;
		
	//Mapping With Table formation
	@ManyToOne
	private Formation formation; 
			
	//Constructeur1
	public Devis()
	{
		super();
	}

	//Constructeur2
	public Devis(int idDevis, int pourcentage) {
	super();
		this.idDevis = idDevis;
		this.pourcentage = pourcentage;
		}

	
	//Getter
			public int getIdDevis() {
				return idDevis;
			}

			public int getPourcentage() {
				return pourcentage;
			}
			public Formation getFormation() {
				return formation;
			}
			
	//Setter
			public void setIdDevis(int idDevis) {
				this.idDevis = idDevis;
			}

			public void setPourcentage(int pourcentage) {
				this.pourcentage = pourcentage;
			}

			public void setFormation(Formation formation) {
				this.formation = formation;
			} 

	//ToString
			@Override
			public String toString() {
				return "Devis [idDevis=" + idDevis + ", pourcentage=" + pourcentage + "]";
			}

			

			
			
			
			
}
