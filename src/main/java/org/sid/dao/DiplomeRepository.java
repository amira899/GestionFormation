package org.sid.dao;


import java.util.ArrayList;


import org.sid.entities.Diplome;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface DiplomeRepository extends CrudRepository<Diplome, Long>
{
	@Query("select d from  Diplome d , Formateur  u where u.id like :x and u.id=d.formateur.id ")
	public ArrayList chercheDiplome(@Param("x")Long mc);
	
	@Query("select d from  Diplome d , Formateur  u where d.id like :x and u.id=d.formateur.id ")
	public Diplome chercheAvecId(@Param("x")Long mc);
}
