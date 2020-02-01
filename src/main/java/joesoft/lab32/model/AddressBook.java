package joesoft.lab32.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AddressBook class representing a Address Book containing multiple BuddyInfo("buddies") objects
 */
@Entity
public class AddressBook {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long key;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "addressBook", fetch=FetchType.EAGER)
    private List<BuddyInfo> buddiesList;

    /**
     * Constructor for creating a new Address Book
     */
    public AddressBook() {
        this.buddiesList = new ArrayList<>();
    }

    /**
     * Constructor for creating a new Address Book
     */
    public AddressBook(Long id) {
        this.key = id;
        this.buddiesList = new ArrayList<>();
    }

    /**
     * Count the total number of buddies in the address book object
     * @return int value of total number of buddies
     */
    public int countBuddies() {
        return buddiesList.size();
    }

    /**
     * Add new buddy to the address book
     * @param buddy a new BuddyInfo object
     */
    public void addBuddy(BuddyInfo buddy) {
        buddiesList.add(buddy);
    }

    /**
     * Display all the buddies currently present in the address book object
     */
    public void displayBuddies(){

        for(BuddyInfo buddyInfo: buddiesList){
            System.out.println(buddyInfo.toString());
        }
    }

    /**
     * Clear all the information from the address book
     */
    public void clearAll(){
        buddiesList.clear();
    }

    /**
     * Return the key for the AddressBook object
     * @return key as an int value
     */
    public Long getKey() {
        return key;
    }

    /**
     * Set a unique key for AddressBook object
     * @param key unique int value
     */
    public void setKey(Long key) {
        this.key = key;
    }

    /**
     * Retrieve the list of buddies as part of the Address Book object
     * @return buddiesList as a list of BuddyInfo objects
     */
    public List<BuddyInfo> getAddressBook() {
        return buddiesList;
    }

    /**
     * Remove a buddy from the address book
     * @param buddy object of type BuddyInfo
     */
    public void removeBuddy(BuddyInfo buddy){
        buddiesList.remove(buddy);
    }

    /**
     * Remove a buddy from the address book by name
     * @param name object of type BuddyInfo
     */
    public void removeBuddy(String name){
        for (BuddyInfo buddy: buddiesList){
            if(buddy.getName().equalsIgnoreCase(name)){
                buddiesList.remove(buddy);
                break;
            }
        }
    }

    /**
     * toString method to print out the object metrics for AddressBook
     * @return String object
     */
    @Override
    public String toString() {
        return "AddressBook{" +
                "key=" + key +
                ", buddiesList=" + buddiesList +
                '}';
    }
}
