package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.hibernate.annotations.GeneratorType;


@Entity
public class Experience implements Serializable
{
	//Attributs
		@Id
		@GeneratedValue
		private Long id;
		private String entreprise , duree , grade;
		@ManyToOne 
		private Formateur formateur; 
		

		//Constructor 1
		public Experience() 
		{
			super();
		}

		//Constructer2
		public Experience(Long id, String entreprise, String duree, String grade)
		{
			super();
			this.id = id;
			this.entreprise = entreprise;
			this.duree = duree;
			this.grade = grade;
		}

		//Getter
		public Long getId() {
			return id;
		}

		public String getEntreprise() {
			return entreprise;
		}

		public String getDuree() {
			return duree;
		}

		public String getGrade() {
			return grade;
		}

		//Setter
		public void setId(Long id) {
			this.id = id;
		}

		public void setEntreprise(String entreprise) {
			this.entreprise = entreprise;
		}

		public void setDuree(String duree) {
			this.duree = duree;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public Formateur getFormateur() {
			return formateur;
		}

		public void setFormateur(Formateur formateur) {
			this.formateur = formateur;
		}

		@Override
		public String toString() {
			return "Experience [id=" + id + ", entreprise=" + entreprise + ", duree=" + duree + ", grade=" + grade
					+ ", formateur=" + formateur.getId() + "]";
		}
		
		
	
		
		
		
		
		
		
}
