package com.linktic.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@Override
	public void run(String... args) throws Exception {
		jobLauncher.run(job, new JobParametersBuilder()
				.addString("file", new ClassPathResource("users2.csv").getURI().toString())
				.toJobParameters());
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
