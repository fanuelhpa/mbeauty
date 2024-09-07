package com.fandevv.mbeauty.configuration;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fandevv.mbeauty.entities.Phone;
import com.fandevv.mbeauty.entities.Scheduling;
import com.fandevv.mbeauty.entities.Service;
import com.fandevv.mbeauty.entities.User;
import com.fandevv.mbeauty.entities.enums.ServiceType;
import com.fandevv.mbeauty.entities.enums.UserType;
import com.fandevv.mbeauty.repositories.PhoneRepository;
import com.fandevv.mbeauty.repositories.SchedulingRepository;
import com.fandevv.mbeauty.repositories.ServiceRepository;
import com.fandevv.mbeauty.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SchedulingRepository schedulingRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Fani Pereira", "fanuel@gmail.com", "12354235", UserType.CLIENT);
		User user2 = new User(null, "Icô Santos", "ico@gmail.com", "9438945u02", UserType.ADMINISTRATOR);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Phone phone1 = new Phone(null, "3193442-4578");
		Phone phone2 = new Phone(null, "3193478-4523");
		Phone phone3 = new Phone(null, "3193456-7865");
		
		phone1.setUser(user1);
		phone2.setUser(user2);
		phone3.setUser(user2);
		
		phoneRepository.saveAll(Arrays.asList(phone1, phone2, phone3));
		
		Service serv1 = new Service(null, "Escovinha", 30.0, ServiceType.HAIR);
		Service serv2 = new Service(null, "Mão", 40.0, ServiceType.HAND);
		Service serv3 = new Service(null, "Relaxamento", 80.0, ServiceType.HAIR);
		
		serviceRepository.saveAll(Arrays.asList(serv1, serv2, serv3));
		
		Scheduling sch1 = new Scheduling(null, Instant.parse("2024-09-04T15:02:00Z"), 30.00, Instant.parse("2024-09-15T15:02:00Z"), user1, serv1);
		Scheduling sch2 = new Scheduling(null, Instant.parse("2024-09-14T18:32:00Z"), 20.00, null, user2, serv2);
		Scheduling sch3 = new Scheduling(null, Instant.parse("2024-09-24T15:20:00Z"), 50.00, Instant.parse("2024-10-04T21:02:00Z"), user1, serv3);
		
		schedulingRepository.saveAll(Arrays.asList(sch1, sch2, sch3));
	}
}
