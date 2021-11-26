package Chapter2.CreatingAndDestroyingObjects.StaticFactoryMethods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class CustomerTest {

    public final String customerCsvLine = "123,hey@example.com,Ryan  ,   Aubrey";
    public Customer c;

    @BeforeEach
    void setup() {
        c = Customer.fromCsvLine(customerCsvLine);
    }

    @Test
    void whenCsvLineIsInvalid_ExceptionIsThrownInCustomerCreation() {
        assertThrows(Error.class, () -> Customer.fromCsvLine("not, enough, columns"));
    }

    @Test
    void givenCustomer_WhenAllFieldsIncluded_ThenCustomerIsCreated() {
        assertNotNull(c);
    }

    @Test
    void givenCustomer_WhenCsvContainsSpacedInName_ThenCustomerFullNameIsStripped() {
        assertNotNull(c.getFullName(), "Ryan Aubrey");
    }
}
