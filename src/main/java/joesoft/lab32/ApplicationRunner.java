package joesoft.lab32;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application
 */
@SpringBootApplication
public class ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunner.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(AddressBookRepository repository) {
//		return (args) -> {
//			// New Address Book
//			AddressBook myBook = new AddressBook();
//
//			// Save Address Book
//			log.info("Saving address book");
//			repository.save(myBook);
//			log.info("Saved address book");
//
//			// Creating buddies
//			BuddyInfo buddy1 = new BuddyInfo("Joe", "+1 (123) 123-3322");
//			myBook.addBuddy(buddy1);
//			BuddyInfo buddy2 = new BuddyInfo("Tom", "+1 (111) 123-4422");
//			myBook.addBuddy(buddy2);
//			BuddyInfo buddy3 = new BuddyInfo("Jerry", "+1 (234) 123-2323");
//			myBook.addBuddy(buddy3);
//			log.info("Total BuddyInfo objects: " + myBook.countBuddies());
//
//			// Save Address Book
//			log.info("Saving address book");
//			repository.save(myBook);
//			log.info("Saved address book");
//
//			// Fetch all Addressbooks
//			log.info("BuddyInfo found with findAll():");
//			log.info("-------------------------------");
//			for (AddressBook addressBook : repository.findAll()) {
//				log.info("One Address Book" + addressBook.toString());
//			}
//			log.info("");
//		};
//	}
}