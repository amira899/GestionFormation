package org.sid.dao;


import java.util.ArrayList;

import org.sid.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ExperienceRepository extends CrudRepository<Experience, Long>
{
	@Query("select e from  Experience e , Formateur  u where u.id like :x and u.id=e.formateur.id ")
	public ArrayList chercheExperience(@Param("x")Long mc);
}
