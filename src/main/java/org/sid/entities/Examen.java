package org.sid.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Examen implements Serializable
{
	//Attributs
		@Id
		@GeneratedValue
		private int id;
		private String nom ;
		private String description;
		
		@ManyToOne
		private Examen examen;
		
		@Temporal(javax.persistence.TemporalType.DATE)
		private Date datePasse;
		
		//Mapping With Table Formateur
		@ManyToOne
		private Formateur formateurExamen;
		
		//Mapping WithTable Formation
		@ManyToOne
		private Formation formation;
		
		//Mapping With Table Examen
		  @OneToMany(mappedBy="examen")
		   private List<Question> qcm;
		  
		//Constructer 1
		public Examen()
		{
			super();
		}
		
		//Constructer2
		public Examen(int id, String nom, String description ,Date datePasse)
		{
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			
			this.datePasse=datePasse;
		}
		
		
		//Getter
		public int getId() {
			return id;
		}

		public String getNom() {
			return nom;
		}

		public String getDescription() {
			return description;
		}

		
		
		public Date getDatePasse() {
			return datePasse;
		}


		//Setter
		public void setId(int id) {
			this.id = id;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	
		

		public void setDatePasse(Date datePasse) {
			this.datePasse = datePasse;
		}
		//ToString
		@Override
		public String toString() {
			return "Examen [id=" + id + ", nom=" + nom + ", description=" + description +  "]";
		}
		
		
		
		
		
}
