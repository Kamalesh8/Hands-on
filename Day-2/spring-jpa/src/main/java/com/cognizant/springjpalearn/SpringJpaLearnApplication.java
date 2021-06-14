package com.cognizant.springjpalearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.springjpalearn.model.Country;
import com.cognizant.springjpalearn.service.CountryNotFoundException;
import com.cognizant.springjpalearn.service.CountryService;

@SpringBootApplication
public class SpringJpaLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringJpaLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(SpringJpaLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		getAllCountriesTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
	}

	private static void getAllCountriesTest() {

		LOGGER.info("Start");
		Country country;
		try {
			country = countryService.findCountryByCode("FR");
			LOGGER.debug("Country:{}", country);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static void testAddCountry() {
		Country country = new Country();
		country.setCode("ES");
		country.setName("Spain");
		countryService.addCountry(country);

		Country check;
		try {
			check = countryService.findCountryByCode("ES");
			LOGGER.debug("Country:{}", check);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void testUpdateCountry() {
		countryService.updateCountry("PT", "Cape_Portugal");
		Country check;
		try {
			check = countryService.findCountryByCode("PT");
			LOGGER.debug("Country:{}", check);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void testDeleteCountry() {
		countryService.deleteCountry("CN");
		Country check;
		try {
			check = countryService.findCountryByCode("CN");
			LOGGER.debug("Country:{}", check);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			System.out.println("Country deleted successfully");
		}
	}
}