package cs320_module3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*************************
 * Name:    Alysha Pursley
 * Course:  CS-320 Software Test, Automation QA
 * Date:    September 22, 2024
 * Description: The ContactService class manages a list of Contact objects.
 * It allows adding, deleting, and updating contacts in the list.
 * The contacts are stored in-memory, and each contact is identified by a unique ID.
 *************************/

 public class ContactService {
    // List to store all contacts
    private final List<Contact> contactList;

    /**
     * Constructor to initialize the contact list.
     */
    public ContactService() {
        this.contactList = new ArrayList<>();
    }

    /**
     * Adds a new contact to the list.
     * Generates a unique ID for the contact and validates the provided information.
     * 
     * @param firstName   the first name of the new contact
     * @param lastName    the last name of the new contact
     * @param phoneNumber the phone number of the new contact
     * @param address     the address of the new contact
     */
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        String uniqueId = generateUniqueId();
        Contact contact = new Contact(uniqueId, firstName, lastName, phoneNumber, address);
        contactList.add(contact);
    }

    /**
     * Deletes a contact from the list based on its unique ID.
     * 
     * @param contactId the ID of the contact to be deleted
     * @throws IllegalArgumentException if the contact with the given ID does not exist
     */
    public void deleteContact(String contactId) {
        Contact contact = findContactById(contactId);
        contactList.remove(contact);
    }

    /**
     * Updates the first name of a contact identified by its ID.
     * 
     * @param contactId the ID of the contact to be updated
     * @param firstName the new first name for the contact
     * @throws IllegalArgumentException if the contact with the given ID does not exist
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = findContactById(contactId);
        contact.updateFirstName(firstName);
    }

    /**
     * Updates the last name of a contact identified by its ID.
     * 
     * @param contactId the ID of the contact to be updated
     * @param lastName  the new last name for the contact
     * @throws IllegalArgumentException if the contact with the given ID does not exist
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = findContactById(contactId);
        contact.updateLastName(lastName);
    }

    /**
     * Updates the phone number of a contact identified by its ID.
     * 
     * @param contactId   the ID of the contact to be updated
     * @param phoneNumber the new phone number for the contact
     * @throws IllegalArgumentException if the contact with the given ID does not exist
     */
    public void updatePhoneNumber(String contactId, String phoneNumber) {
        Contact contact = findContactById(contactId);
        contact.updatePhoneNumber(phoneNumber);
    }

    /**
     * Updates the address of a contact identified by its ID.
     * 
     * @param contactId the ID of the contact to be updated
     * @param address   the new address for the contact
     * @throws IllegalArgumentException if the contact with the given ID does not exist
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = findContactById(contactId);
        contact.updateAddress(address);
    }

    /**
     * Generates a new unique ID for a contact.
     * The ID is a 10-character string derived from a UUID.
     * 
     * @return a unique contact ID string
     */
    private String generateUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    /**
     * Finds a contact by its unique ID.
     * 
     * @param contactId the ID of the contact to find
     * @return the Contact object corresponding to the given ID
     * @throws IllegalArgumentException if the contact is not found
     */
    private Contact findContactById(String contactId) {
        return contactList.stream()
                .filter(contact -> contact.getContactId().equals(contactId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Contact ID not found: " + contactId));
    }

    /**
     * Returns the list of all contacts (used for testing purposes).
     * 
     * @return the list of contacts
     */
    protected List<Contact> getContactList() {
        return contactList;
    }
}