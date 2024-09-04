package com.fandevv.mbeauty.configuration;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fandevv.mbeauty.entities.Scheduling;
import com.fandevv.mbeauty.entities.User;
import com.fandevv.mbeauty.repositories.SchedulingRepository;
import com.fandevv.mbeauty.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SchedulingRepository schedulingRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Fani Pereira", "fanuel@gmail.com", "12354235");
		User user2 = new User(null, "Icô Santos", "ico@gmail.com", "9438945u02");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Scheduling sch1 = new Scheduling(null, Instant.parse("2024-09-04T15:02:00Z"), 30.00, user1);
		Scheduling sch2 = new Scheduling(null, Instant.parse("2024-09-14T18:32:00Z"), 20.00, user2);
		Scheduling sch3 = new Scheduling(null, Instant.parse("2024-09-24T15:20:00Z"), 50.00, user1);
		
		schedulingRepository.saveAll(Arrays.asList(sch1, sch2, sch3));
	}
}
