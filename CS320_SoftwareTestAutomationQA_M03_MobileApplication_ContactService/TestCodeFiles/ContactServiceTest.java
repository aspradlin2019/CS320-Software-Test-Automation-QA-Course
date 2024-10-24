package cs320_module3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*************************
 * Name:    Alysha Pursley
 * Course:  CS-320 Software Test, Automation QA
 * Date:    September 22, 2024
 * Description: * Unit tests for the ContactService class.
 * These tests ensure that the ContactService class correctly manages
 * the addition, deletion, and updating of contacts.
 *************************/

 public class ContactServiceTest {
    private ContactService contactService;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    @BeforeEach
    void setUp() {
        // Initialize the contact service and test data before each test
        contactService = new ContactService();
        firstName = "John";
        lastName = "Doe";
        phoneNumber = "1234567890";
        address = "123 Main St, Anytown, USA";
    }

    @Test
    void testAddContact() {
        // Test adding a new contact
        contactService.addContact(firstName, lastName, phoneNumber, address);
        assertNotNull(contactService.getContactList().get(0).getContactId());
    }

    @Test
    void testDeleteContact() {
        // Test deleting a contact by ID
        contactService.addContact(firstName, lastName, phoneNumber, address);
        String contactId = contactService.getContactList().get(0).getContactId();
        contactService.deleteContact(contactId);
        assertTrue(contactService.getContactList().isEmpty());
    }

    @Test
    void testUpdateFirstName() {
        // Test updating the first name of a contact
        contactService.addContact(firstName, lastName, phoneNumber, address);
        String contactId = contactService.getContactList().get(0).getContactId();
        String newFirstName = "Jane";
        contactService.updateFirstName(contactId, newFirstName);
        assertEquals(newFirstName, contactService.getContactList().get(0).getFirstName());
    }

    @Test
    void testUpdateLastName() {
        // Test updating the last name of a contact
        contactService.addContact(firstName, lastName, phoneNumber, address);
        String contactId = contactService.getContactList().get(0).getContactId();
        String newLastName = "Smith";
        contactService.updateLastName(contactId, newLastName);
        assertEquals(newLastName, contactService.getContactList().get(0).getLastName());
    }

    @Test
    void testUpdatePhoneNumber() {
        // Test updating the phone number of a contact
        contactService.addContact(firstName, lastName, phoneNumber, address);
        String contactId = contactService.getContactList().get(0).getContactId();
        String newPhoneNumber = "0987654321";
        contactService.updatePhoneNumber(contactId, newPhoneNumber);
        assertEquals(newPhoneNumber, contactService.getContactList().get(0).getPhoneNumber());
    }

    @Test
    void testUpdateAddress() {
        // Test updating the address of a contact
        contactService.addContact(firstName, lastName, phoneNumber, address);
        String contactId = contactService.getContactList().get(0).getContactId();
        String newAddress = "456 Elm St, Anytown, USA";
        contactService.updateAddress(contactId, newAddress);
        assertEquals(newAddress, contactService.getContactList().get(0).getAddress());
    }

    @Test
    void testDeleteNonExistentContact() {
        // Test trying to delete a contact that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("NonExistentID");
        });
    }
}