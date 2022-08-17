package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import org.hibernate.annotations.GeneratorType;


@Entity
public class Question implements Serializable
{
	//Attributs
		@Id
		@GeneratedValue
		private int num;
		private String description;
		
		//Mapping With Table Examen
		@ManyToOne
		private Examen examen;
		
		  //Mapping Whith Table Reponse
		   @OneToMany(mappedBy="question")
		   private List<Reponse> reponse;
		   
		//Constructer1
		public Question() 
		{
			super();
		}

		//Constructer2
		public Question(int num, String description)
		{
			super();
			this.num = num;
			this.description = description;
		}

		//Getter
		public int getNum() {
			return num;
		}

		public String getDescription() {
			return description;
		}

		//Setter
		public void setNum(int num) {
			this.num = num;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		
		
		
	
}
