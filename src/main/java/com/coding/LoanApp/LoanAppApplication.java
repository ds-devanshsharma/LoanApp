package com.coding.LoanApp;

import com.coding.LoanApp.entities.Customer;
import com.coding.LoanApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LoanAppApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerRepository ;
	public static void main(String[] args) {
		SpringApplication.run(LoanAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Customer> customers = onboardCustomers();
		customerRepository.saveAll(customers);
	}

	private List<Customer> onboardCustomers() {
		List<Customer> customers = new ArrayList<>();

		Customer c1 = new Customer();
		c1.setName("Amit Sharma");
		c1.setEmail("amit.sharma@example.com");
		c1.setDob(LocalDateTime.of(1990, 5, 20, 0, 0));
		c1.setAadhaar("1234-5678-9012");

		Customer c2 = new Customer();
		c2.setName("Neha Verma");
		c2.setEmail("neha.verma@example.com");
		c2.setDob(LocalDateTime.of(1985, 8, 10, 0, 0));
		c2.setAadhaar("9876-5432-1098");

		Customer c3 = new Customer();
		c3.setName("Rajiv Kapoor");
		c3.setEmail("rajiv.kapoor@example.com");
		c3.setDob(LocalDateTime.of(1978, 3, 2, 0, 0));
		c3.setAadhaar("1111-2222-3333");

		Customer c4 = new Customer();
		c4.setName("Priya Singh");
		c4.setEmail("priya.singh@example.com");
		c4.setDob(LocalDateTime.of(1995, 11, 30, 0, 0));
		c4.setAadhaar("4444-5555-6666");

		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);

		return customers ;
	}
}
