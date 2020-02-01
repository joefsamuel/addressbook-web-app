package joesoft.lab32.controller;

import joesoft.lab32.model.AddressBook;
import org.springframework.data.repository.CrudRepository;


public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    AddressBook findById(long id);

}
