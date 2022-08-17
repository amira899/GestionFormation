package org.sid.dao;

import java.util.ArrayList;

import org.sid.entities.Candidat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CandidatRepository extends CrudRepository<Candidat, Long>
{
	@Query("select c from Candidat c where c.adresse like :x")
	public  Page<Candidat> chercher(@Param("x")String mc, Pageable pageable) ;
	
	@Query("select u from Candidat u where u.id like :x")
	public  Candidat chercherId(@Param("x")Long mc) ;
}
