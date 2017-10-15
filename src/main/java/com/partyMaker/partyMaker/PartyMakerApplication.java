package com.partyMaker.partyMaker;

import com.partyMaker.partyMaker.model.CompanyEntity;
import com.partyMaker.partyMaker.model.LocationEntity;
import com.partyMaker.partyMaker.model.PartyEntity;
import com.partyMaker.partyMaker.model.UserEntity;
import com.partyMaker.partyMaker.model.types.CompanyType;
import com.partyMaker.partyMaker.model.types.PartyType;
import com.partyMaker.partyMaker.model.types.UserType;
import com.partyMaker.partyMaker.repository.CompanyRepository;
import com.partyMaker.partyMaker.repository.PartyRepository;
import com.partyMaker.partyMaker.repository.LocationRepository;
import com.partyMaker.partyMaker.repository.UserRepository;
import com.partyMaker.partyMaker.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PartyMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyMakerApplication.class, args);
	}

	@Autowired
	private PartyService partyService;

	@Bean
	public CommandLineRunner init(UserRepository userRepository,
								  CompanyRepository companyRepository,
								  PartyRepository partyRepository,
                                  LocationRepository locationRepository) {

		return (evt) -> {
			generateUsers(userRepository);
			generateOrganizers(userRepository);
			generateCompanies(companyRepository);
			generateParties(partyRepository, userRepository);
			generateLocation(locationRepository);
		};
	}

	private void generateParties(PartyRepository partyRepository, UserRepository userRepository) {
		Arrays.asList("Jan, Ben, Ola, Agnieszka".split(",")).forEach(
				name -> {
					PartyEntity p = new PartyEntity();
					p.setPartyType(PartyType.TYPICAL);
					p.setHashtagBox("#homeparty");
					p.setDate(Date.from(Instant.now()));
					p.setDescription("Beer and Boobs home party");
					LocationEntity location = new LocationEntity();
					location.setAddress("Rynek 1, Wroclaw");
					location.setAttendersLimit(100);
					p.setLocation(location);
					p.setUsers(generateUsers(userRepository));
					p.setOrganizer(generateOrganizers(userRepository).get(0));
					PartyEntity partyEntity = partyRepository.save(p);
					p.setTickets(partyService.generateTickets(location.getAttendersLimit(),25.0,partyEntity));
				}
		);
	}

	private List<UserEntity> generateUsers(UserRepository userRepository) {
		Arrays.asList("Jan, Ben, Ola, Agnieszka".split(",")).forEach(
				name -> {
					UserEntity u = new UserEntity();
					u.setName(name);
					u.setUserType(UserType.CUSTOMER);
					userRepository.save(u);
				}
		);
		return userRepository.findAll();
	}


	private List<UserEntity> generateOrganizers(UserRepository userRepository) {
		Arrays.asList("Frank, Andry".split(",")).forEach(
				name -> {
					UserEntity u = new UserEntity();
					u.setName(name);
					u.setUserType(UserType.ORGANIZER);
					userRepository.save(u);
				}
		);
		return userRepository.findAll();
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

	private void generateLocation(LocationRepository locationRepository) {
		LocationEntity szewska = new LocationEntity();
		szewska.setAttendersLimit(200);
		szewska.setGeoLocation("51.1109220 17.0350210");
		szewska.setAddress("ul. Szewska 1, Wroclaw");
		locationRepository.save(szewska);

		LocationEntity kuznicza = new LocationEntity();
		kuznicza.setAttendersLimit(100);
		kuznicza.setGeoLocation("51.1118580 17.0341073");
		kuznicza.setAddress("ul. Kuznicza 1, Wroclaw");
		locationRepository.save(kuznicza);
	}
}
