package org.sid.dao;

import org.sid.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
	@Query("select u from Utilisateur u where u.type like :x")
	public Page<Utilisateur> chercher(@Param("x")String mc, Pageable pageable);
	
	@Query("select u from Utilisateur u where u.login like :x and u.password like :y")
	public  Utilisateur recherche(@Param("x")String login, @Param("y")String password);

}
