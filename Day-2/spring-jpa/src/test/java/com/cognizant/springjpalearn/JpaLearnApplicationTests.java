package com.cognizant.springjpalearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cognizant.springjpalearn.repository.CountryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


@SpringBootTest
class JpaLearnApplicationTests {

	@Autowired
	CountryRepository countryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSearch() {
		System.out.println("Countries Having Names ni");
		countryRepository.getNameHaving("ni",Sort.by(Direction.ASC, "name")).forEach(country->System.out.println(country));

		System.out.println("\nCountries Name Starting with K");
		countryRepository.getNameStartingWith("K").forEach(country->System.out.println(country));
	}

}
