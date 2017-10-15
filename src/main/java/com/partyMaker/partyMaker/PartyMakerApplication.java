package com.partyMaker.partyMaker;

import com.partyMaker.partyMaker.model.CompanyEntity;
import com.partyMaker.partyMaker.model.UserEntity;
import com.partyMaker.partyMaker.model.types.CompanyType;
import com.partyMaker.partyMaker.model.types.UserType;
import com.partyMaker.partyMaker.repository.CompanyRepository;
import com.partyMaker.partyMaker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class PartyMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyMakerApplication.class, args);
	}


	@Bean
	private CommandLineRunner init(UserRepository userRepository,
								   CompanyRepository companyRepository) {
		return (evt) -> {
			generateUsers(userRepository);
			generateOrganizers(userRepository);
			generateCompanies(companyRepository);
		};
	}

	private void generateUsers(UserRepository userRepository) {
		Arrays.asList("Jan, Ben, Ola, Agnieszka".split(",")).forEach(
				name -> {
					UserEntity u = new UserEntity();
					u.setName(name);
					u.setUserType(UserType.CUSTOMER);
					userRepository.save(u);
				}
		);
	}

	private void generateOrganizers(UserRepository userRepository) {
		Arrays.asList("Frank, Andry".split(",")).forEach(
				name -> {
					UserEntity u = new UserEntity();
					u.setName(name);
					u.setUserType(UserType.ORGANIZER);
					userRepository.save(u);
				}
		);
	}

	private void generateCompanies(CompanyRepository companyRepository) {
		Arrays.asList("House Rent, Castle Rent".split(",")).forEach(
				name -> {
					CompanyEntity c = new CompanyEntity();
					c.setName(name);
					c.setCompanyType(CompanyType.LOCATION);
					companyRepository.save(c);
				}
		);
		Arrays.asList("Balloon Corporation, FoodTrack".split(",")).forEach(
				name -> {
					CompanyEntity c = new CompanyEntity();
					c.setName(name);
					c.setCompanyType(CompanyType.ADDITIONAL);
					companyRepository.save(c);
				}
		);
	}
}
