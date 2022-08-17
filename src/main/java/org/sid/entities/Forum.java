package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Forum implements Serializable
{
	//Attributs
		@Id
		private int idForum;
	
	

		//Constructur
	public Forum(int idForum, Formation formation) 
	{
		super();
		this.idForum = idForum;
	
	}

	//Getters
	public int getIdForum() {
		return idForum;
	}

	

	//Setters
	public void setIdForum(int idForum) {
		this.idForum = idForum;
	}

	
		
}
