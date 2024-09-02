package com.fandevv.mbeauty.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fandevv.mbeauty.entities.User;
import com.fandevv.mbeauty.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Fani Pereira", "fanuel@gmail.com", "12354235");
		User user2 = new User(null, "Icô Santos", "ico@gmail.com", "9438945u02");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
}
