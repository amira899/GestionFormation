package org.sid.dao;


import org.sid.entities.Formation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormationRepository extends JpaRepository<Formation, String>
{
		@Query("select u from Formation u where u.nom like :x")
		public  Page<Formation> chercher(@Param("x")String mc, Pageable pageable) ;
		
		@Query("select u from Formation u where u.nom like :x")
		public  Formation chercherId(@Param("x")String nom) ;
}
