package com.cognizant.springjpalearn.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.springjpalearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	@Query("from Country where name like %:name%")
	public List<Country> getNameHaving(@Param("name") String name,Sort sort);
	
	@Query("from Country where name like :name%")
	public List<Country> getNameStartingWith(@Param("name") String name);
	
}