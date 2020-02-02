package joesoft.lab32.model;

import javax.persistence.*;

/**
 * Represents a buddy
 */
@Entity
public class BuddyInfo {

    // Primary Key for table BuddyInfo
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    @ManyToOne
    private AddressBook addressBook;


    /**
     * No argument constructor for JavaBeans convention
     */
    public BuddyInfo(){

    }

    /**
     * Constructor for BuddyInfo
     * @param name name of the buddy
     * @param phoneNumber phone number of the buddy
     */
    public BuddyInfo(Long id, String name, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Get the name of the BuddyInfo object
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Get the phone number of the BuddyInfo object
     * @return phoneNumber as a string
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the id for BuddyInfo object
     * @return id as an integer
     */
    public Long getId() {
        return id;
    }

    /**
     * Set a unique id for BuddyInfo object
     * @param id unique int value
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to display the object in a readable format
     * @return readable format of the object
     */
    @Override
    public String toString() {
        return "Name: " + name + " | Number: " + phoneNumber ;
    }

    /**
     * Set the phone number for BuddyInfo object
     * @param phoneNumber String parameter
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set the name of buddy for BuddyInfo object
     * @param name String parameter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the address of the BuddyInfo object
     * @return address as a string
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of buddy for BuddyInfo object
     * @param address String parameter
     */
    public void setAddress(String address) {
        this.address = address;
    }
}

