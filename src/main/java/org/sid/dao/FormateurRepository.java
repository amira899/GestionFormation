package org.sid.dao;

import java.awt.List;

import org.sid.entities.Formateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FormateurRepository extends CrudRepository<Formateur, Long>
{
		@Query("select u from Formateur u where u.specialite like :x")
		public  Page<Formateur> chercher(@Param("x")String mc, Pageable pageable) ;
		
		@Query("select u from Formateur u where u.id like :x")
		public  Formateur chercherId(@Param("x")Long mc) ;
		
		
}
