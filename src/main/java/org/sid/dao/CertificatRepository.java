package org.sid.dao;

import java.util.ArrayList;

import org.sid.entities.Certificat;
import org.sid.entities.Formateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CertificatRepository extends CrudRepository<Certificat, Long>
{
	@Query("select c from  Certificat c , Formateur  u where u.id like :x and u.id=c.formateur.id ")
	public ArrayList chercheCertificat(@Param("x")Long mc);
	
	@Query("select c from  Certificat c , Formateur  u where c.id like :x and u.id=c.formateur.id ")
	public Certificat chercheAvecId(@Param("x")Long mc);
}
