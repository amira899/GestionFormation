package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reponse implements Serializable 
{
	//Attributs
			@Id
			@GeneratedValue
			private int id;
			private String description;
			private Boolean valide ;
			
			
			//Mapping With Table question
			@ManyToOne
			private Question question;
			
			//Constructer1
			public Reponse() 
			{
				super();
			}

			//Constructer 2
			public Reponse(int id, String description, Boolean valide) 
			{
		
				this.id = id;
				this.description = description;
				this.valide = valide;
			}

			
			//Getter
			public int getId() {
				return id;
			}

			public String getDescription() {
				return description;
			}

			public Boolean getValide() {
				return valide;
			}

			//Setter
			public void setId(int id) {
				this.id = id;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public void setValide(Boolean valide) {
				this.valide = valide;
			}
			
			

			
			
			
			
}
