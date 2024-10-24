package cs320_module3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*************************
 * Name:    Alysha Pursley
 * Course:  CS-320 Software Test, Automation QA
 * Date:    October 1, 2024
 * Description: Unit tests for the Contact class. These tests validate that the Contact class
 * properly enforces the constraints on its fields and behaves as expected when
 * creating or modifying a contact.
 *************************/

public class ContactTest {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    @BeforeEach
    void setUp() {
        // Initialize test data before each test
        contactId = "1234567890";
        firstName = "John";
        lastName = "Doe";
        phoneNumber = "1234567890";
        address = "123 Main St, Anytown, USA";
    }

    @Test
    void testContactCreation() {
        // Test creating a contact with valid data
        Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        assertAll("Contact creation",
                () -> assertEquals(contactId, contact.getContactId()),
                () -> assertEquals(firstName, contact.getFirstName()),
                () -> assertEquals(lastName, contact.getLastName()),
                () -> assertEquals(phoneNumber, contact.getPhoneNumber()),
                () -> assertEquals(address, contact.getAddress()));
    }

    @Test
    void testUpdateFirstName() {
        // Test updating the first name with valid data
        Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        String newFirstName = "Jane";
        contact.updateFirstName(newFirstName);
        assertEquals(newFirstName, contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        // Test updating the last name with valid data
        Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        String newLastName = "Smith";
        contact.updateLastName(newLastName);
        assertEquals(newLastName, contact.getLastName());
    }

    @Test
    void testUpdatePhoneNumber() {
        // Test updating the phone number with valid data
        Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        String newPhoneNumber = "0987654321";
        contact.updatePhoneNumber(newPhoneNumber);
        assertEquals(newPhoneNumber, contact.getPhoneNumber());
    }

    @Test
    void testUpdateAddress() {
        // Test updating the address with valid data
        Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        String newAddress = "456 Elm St, Anytown, USA";
        contact.updateAddress(newAddress);
        assertEquals(newAddress, contact.getAddress());
    }

    @Test
    void testInvalidContactCreation() {
        // Test creating a contact with invalid data
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, firstName, lastName, phoneNumber, address);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, null, lastName, phoneNumber, address);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, null, phoneNumber, address);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, null, address);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phoneNumber, null);
        });
    }

    // Test cases for boundary conditions
    @Test
    void testValidMaxLengthFirstName() {
        Contact contact = new Contact(contactId, "JohnJohnJo", lastName, phoneNumber, address);
        assertEquals("JohnJohnJo", contact.getFirstName());
    }

    @Test
    void testExceedMaxLengthFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, "JohnJohnJohn", lastName, phoneNumber, address);
        });
    }

    @Test
    void testValidMaxLengthLastName() {
        Contact contact = new Contact(contactId, firstName, "DoeDoeDoeD", phoneNumber, address);
        assertEquals("DoeDoeDoeD", contact.getLastName());
    }

    @Test
    void testExceedMaxLengthLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, "DoeDoeDoeDoe", phoneNumber, address);
        });
    }

    @Test
    void testValidPhoneNumber() {
        Contact contact = new Contact(contactId, firstName, lastName, "0987654321", address);
        assertEquals("0987654321", contact.getPhoneNumber());
    }

    @Test
    void testInvalidPhoneNumberLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, "123", address);
        });
    }

    // Add tests for null or invalid phone number formats
    @Test
    void testNullPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, null, address);
        });
    }

    @Test
    void testNonNumericPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, "12345abcde", address);
        });
    }

    @Test
    void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, null, lastName, phoneNumber, address);
        });
    }

    @Test
    void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, null, phoneNumber, address);
        });
    }

    @Test
    void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactId, firstName, lastName, phoneNumber, null);
        });
    }
}
