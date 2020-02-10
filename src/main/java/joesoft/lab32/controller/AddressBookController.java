package joesoft.lab32.controller;

import joesoft.lab32.model.AddressBook;
import joesoft.lab32.model.BuddyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;



@Controller
public class AddressBookController {

    // Unique sequential object counters
    private final AtomicLong bookCounter = new AtomicLong();
    private final AtomicLong buddyCounter = new AtomicLong();
    private AddressBook book;

    /**
     * Create a new AddressBook object
     * @param model model object for binding in SpringMVC
     * @return newbook thymeleaf html template
     */
    @GetMapping("/newbook")
    public String addressBook(Model model){
        book = new AddressBook(bookCounter.incrementAndGet());
        model.addAttribute("book", book.toString());
        return "newbook";
    }

    /**
     * API for adding a new BuddyInfo object
     * @param name
     * @param phone
     * @return a JSON object within the AddressBook object
     */
    @CrossOrigin
    @GetMapping("/api/addbuddy")
    @ResponseBody
    public BuddyInfo addBuddyInfoAPI(@RequestParam(name = "name", required=true) String name, @RequestParam(name = "phone", required = true) String phone, @RequestParam(name = "address", required = true) String address){
        if(book != null){
            BuddyInfo buddyInfo = new BuddyInfo(buddyCounter.incrementAndGet(), name, phone, address);
            book.addBuddy(buddyInfo);
            return buddyInfo;
        }
    return null;
    }

    /**
     * Add a BuddyInfo object through thymeleaf template
     * @param model model object for binding in SpringMVC
     * @return newbuddy thymeleaf html template
     */
    @GetMapping("/addbuddy")
    public String addBuddyInfo(Model model){
        if(book != null){
            BuddyInfo buddyInfo = new BuddyInfo();
            model.addAttribute("buddy", buddyInfo);
            return "newbuddy";
        }
        return "error";
    }

    /**
     * Post HTTP method to add a BuddyInfo object to the AddressBook object
     * @param buddyInfo
     * @return buddyresult thymeleaf html template
     */
    @PostMapping("/addbuddy")
    public String buddyInfoSubmit(@ModelAttribute("buddyInfo") BuddyInfo buddyInfo){
        book.addBuddy(buddyInfo);
        return "buddyresult";
    }

    /**
     * API for removing an existing BuddyInfo object
     * @param name
     */
    @CrossOrigin
    @GetMapping("/api/removebuddy")
    @ResponseBody
    public String removeBuddyInfoAPI(@RequestParam(name = "name", required=true) String name){
        if(book != null){
            book.removeBuddy(name);
            return "Buddy Removed";
        }
    return "error";
    }

    /**
     * Remove a BuddyInfo object using Thymeleaf html template
     * @return removebuddy thymeleaf html template
     */
    @GetMapping("/removebuddy")
    public String removeBuddyInfo(){
        if(book != null){
            return "removebuddy";
        }
      return "error";
    }

    /**
     * POST HTTP method for initiating removal of BuddyInfo object submitted through form
     * @param buddyName
     * @return buddyremoved thymeleaf html template
     */
    @PostMapping("/removebuddy")
    public String buddyInfoRemoved(@RequestParam("removalname") String buddyName){
        book.removeBuddy(buddyName);
        return "buddyremoved";
    }

    /**
     * API for viewing AddressBook object
     * @return JSON of AddressBook object
     */
    @CrossOrigin
    @GetMapping("/api/viewbook")
    @ResponseBody
    public AddressBook viewBookAPI(){
        if(book != null){
            return book;
        }
        return null;
    }

    /**
     * Thymeleaf template showing the AddressBook template
     * @param model
     * @return thymeleaf template for viewing the book
     */
    @GetMapping("/viewbook")
    public String viewBook(Model model){
        if(book != null){
            model.addAttribute("buddiesList", book.getAddressBook());
            return "viewbook";
        }
     return "error";
    }

    /**
     * Greeting message for the user
     * @param name optional parameter
     * @param model
     * @return thymeleaf template for greeting
     */
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required=false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
}