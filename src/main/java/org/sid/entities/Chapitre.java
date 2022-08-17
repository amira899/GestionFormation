package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chapitre implements Serializable
{
	//Attributs
	@Id
	@GeneratedValue
	private int idCh;
	private int numero ;
	private int nbr;
	
}
