package Chapter2.CreatingAndDestroyingObjects.Item1_StaticFactoryMethods;

import java.util.Arrays;

public class Customer {
    private final String id;
    private final String email;
    private final String firstName;
    private final String lastName;

    private Customer(String id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Customer fromCsvLine(String customerCsvLine) {
        String[] parts = Arrays.stream(customerCsvLine.split(",")).map(String::trim).toArray(String[]::new);
        if (parts.length != 4)
            throw new Error("Unable to construct customer");
        return new Customer(parts[0], parts[1], parts[2], parts[3]);
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public String toString() {
        return String.format("Customer - id:%s, email:%s, firstName:%s, lastName:%s", id, email, firstName, lastName);
    }
}
