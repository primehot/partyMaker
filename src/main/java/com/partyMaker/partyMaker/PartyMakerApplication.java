package com.partyMaker.partyMaker;

import com.partyMaker.partyMaker.model.CompanyEntity;
import com.partyMaker.partyMaker.model.LocationEntity;
import com.partyMaker.partyMaker.model.PartyEntity;
import com.partyMaker.partyMaker.model.UserEntity;
import com.partyMaker.partyMaker.model.types.CompanyType;
import com.partyMaker.partyMaker.model.types.PartyType;
import com.partyMaker.partyMaker.model.types.UserType;
import com.partyMaker.partyMaker.repository.CompanyRepository;
import com.partyMaker.partyMaker.repository.LocationRepository;
import com.partyMaker.partyMaker.repository.PartyRepository;
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

    private UserRepository userRepository;
    private CompanyRepository companyRepository;
    private PartyRepository partyRepository;
    private LocationRepository locationRepository;

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
            this.userRepository = userRepository;
            this.companyRepository = companyRepository;
            this.partyRepository = partyRepository;
            this.locationRepository = locationRepository;

            generateUsers();
			generateOrganizers();
            generateCompanies();
			generateLocation();
            generateParties();
		};
	}

	private void generateParties() {
		PartyEntity p = new PartyEntity();
		p.setPartyType(PartyType.TYPICAL);
		p.setHashtagBox("#homeparty");
		p.setDate(Date.from(Instant.now()));
		p.setDescription("Beer and Boobs home party");
		p.setUsers(generateUsers());
		p.setOrganizer(generateOrganizers().get(0));
		p.setLocation(generateLocation().get(0));

		p = partyRepository.save(p);

		p.setTickets(partyService.generateTickets(p.getLocation().getAttendersLimit(),25.0, p));

		partyRepository.save(p);
	}

	private List<UserEntity> generateUsers() {
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


	private List<UserEntity> generateOrganizers() {
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

	private void generateCompanies() {
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

	private List<LocationEntity> generateLocation() {
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

		return locationRepository.findAll();
	}
}
