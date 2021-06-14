package com.cognizant.jpalearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.jpalearn.model.Country;
import com.cognizant.jpalearn.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries(){
		return countryRepository.findAll();
	}

	//Handson - 6 

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}
		Country country = result.get();
		return country;
	}

	//Handson - 7
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	//Handson - 8
	@Transactional
	public void updateCountry(String code,String name) {
		Country country = countryRepository.findById(code).get();
		country.setName(name);
		countryRepository.save(country);
	}
	
	//Handson - 9
	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}
}
