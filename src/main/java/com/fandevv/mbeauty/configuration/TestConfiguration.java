package com.fandevv.mbeauty.configuration;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fandevv.mbeauty.entities.Schedule;
import com.fandevv.mbeauty.entities.Service;
import com.fandevv.mbeauty.entities.User;
import com.fandevv.mbeauty.entities.enums.ServiceType;
import com.fandevv.mbeauty.entities.enums.UserType;
import com.fandevv.mbeauty.repositories.ScheduleRepository;
import com.fandevv.mbeauty.repositories.ServiceRepository;
import com.fandevv.mbeauty.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScheduleRepository schedulingRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Fani Pereira", "fanuel@gmail.com", "12354235","4398-4356", UserType.CLIENT);
		User user2 = new User(null, "Icô Santos", "ico@gmail.com", "9438945u02", "7734-0981", UserType.ADMINISTRATOR);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		
		Service serv1 = new Service(null, "Escovinha", 30.0, ServiceType.HAIR);
		Service serv2 = new Service(null, "Mão", 40.0, ServiceType.HAND);
		Service serv3 = new Service(null, "Relaxamento", 80.0, ServiceType.HAIR);
		
		serviceRepository.saveAll(Arrays.asList(serv1, serv2, serv3));
		
		Schedule sch1 = new Schedule(null, Instant.parse("2024-09-04T15:02:00Z"), 30.00, Instant.parse("2024-09-15T15:02:00Z"), user1, serv1);
		Schedule sch2 = new Schedule(null, Instant.parse("2025-09-14T18:32:00Z"), 20.00, null, user2, serv2);
		Schedule sch3 = new Schedule(null, Instant.parse("2026-09-24T15:20:00Z"), 50.00, Instant.parse("2026-10-04T21:02:00Z"), user1, serv3);
		
		schedulingRepository.saveAll(Arrays.asList(sch1, sch2, sch3));
	}
}
