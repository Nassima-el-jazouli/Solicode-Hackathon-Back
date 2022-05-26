package org.sid.announcementService;

import org.sid.announcementService.Repository.ProductRepository;
import org.sid.announcementService.ServiceImp.ProductServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {ProductServiceImp.class, ProductRepository.class})
@EnableDiscoveryClient

public class AnnouncementServiceApplication {
	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(AnnouncementServiceApplication.class, args);
	}

}
