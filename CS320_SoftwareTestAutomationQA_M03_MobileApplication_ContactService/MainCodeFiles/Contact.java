package cs320_module3;

/*************************
 * Name:    Alysha Pursley
 * Course:  CS-320 Software Test, Automation QA
 * Date:    October 1, 2024
 * Description:  The Contact class represents an individual contact in a contact management application.
 * Each contact has a unique ID, first name, last name, phone number, and address.
 * The class ensures that the contact information is valid according to predefined rules.
 *************************/

public class Contact {
    // Constants that define the maximum allowed length for each field
    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 10;
    private static final int PHONE_NUMBER_LENGTH = 10;
    private static final int MAX_ADDRESS_LENGTH = 30;

    // Contact fields: ID is immutable, others are mutable with validation
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    /**
     * Constructor to initialize a new Contact object.
     * 
     * @param contactId   the unique ID for this contact, must be non-null and up to 10 characters
     * @param firstName   the first name of the contact, must be non-null and up to 10 characters
     * @param lastName    the last name of the contact, must be non-null and up to 10 characters
     * @param phoneNumber the phone number of the contact, must be exactly 10 digits
     * @param address     the address of the contact, must be non-null and up to 30 characters
     */
    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        // Validate and assign the contact ID
        if (contactId == null || contactId.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("Contact ID must be non-null and no longer than " + MAX_ID_LENGTH + " characters.");
        }
        this.contactId = contactId;

        // Validate and assign the first name
        if (firstName == null || firstName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("First name must be non-null and no longer than " + MAX_NAME_LENGTH + " characters.");
        }
        this.firstName = firstName;

        // Validate and assign the last name
        if (lastName == null || lastName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Last name must be non-null and no longer than " + MAX_NAME_LENGTH + " characters.");
        }
        this.lastName = lastName;

        // Validate and assign the phone number
        if (phoneNumber == null || phoneNumber.length() != PHONE_NUMBER_LENGTH || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must be exactly " + PHONE_NUMBER_LENGTH + " digits.");
        }
        this.phoneNumber = phoneNumber;

        // Validate and assign the address
        if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must be non-null and no longer than " + MAX_ADDRESS_LENGTH + " characters.");
        }
        this.address = address;
    }

    // Getters for each field
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Methods to update mutable fields with validation
    public void updateFirstName(String firstName) {
        if (firstName == null || firstName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("First name must be non-null and no longer than " + MAX_NAME_LENGTH + " characters.");
        }
        this.firstName = firstName;
    }

    public void updateLastName(String lastName) {
        if (lastName == null || lastName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Last name must be non-null and no longer than " + MAX_NAME_LENGTH + " characters.");
        }
        this.lastName = lastName;
    }

    public void updatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != PHONE_NUMBER_LENGTH || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must be exactly " + PHONE_NUMBER_LENGTH + " digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void updateAddress(String address) {
        if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must be non-null and no longer than " + MAX_ADDRESS_LENGTH + " characters.");
        }
        this.address = address;
    }
}
