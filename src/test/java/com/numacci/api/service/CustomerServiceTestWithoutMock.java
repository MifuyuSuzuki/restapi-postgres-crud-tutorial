package com.numacci.api.service;

import com.numacci.api.config.DbConfig;
import com.numacci.api.dto.Customer;
import com.numacci.api.repository.CustomerMapper;
import com.numacci.api.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@Import(DbConfig.class)
@Transactional
public class CustomerServiceTestWithoutMock {

    @Autowired
    private CustomerService service;

    @DisplayName("CREATE TEST: Check if registration succeeded.")
    @Test
    public void testRegister() {
        Customer customer = new Customer();
        customer.setId("100");
        customer.setUsername("user100");
        customer.setEmail("test.user.100@EXAMPLE.com");
        customer.setPhoneNumber("01234567890");
        customer.setPostCode("1234567");

        Customer actual = service.register(customer);
        assertEquals(customer.getId(), actual.getId());
        assertEquals(customer.getUsername(), actual.getUsername());
        assertEquals("test.user.100@example.com", actual.getEmail());
        assertEquals(customer.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(customer.getPostCode(), actual.getPostCode());
    }

    @DisplayName("READ TEST: Check if all customer information retrieved.")
    @Test
    public void testRetrieveAll() {
        List<Customer> actual = service.retrieve();
        for (Customer customer : actual) {
            System.out.println(customer.getId());
        }
        assertEquals(10, actual.size());
    }

    @DisplayName("READ TEST: Check if expected customer information retrieved.")
    @Test
    public void testRetrieve() {
        Customer customer = new Customer();
        customer.setId("001");
        customer.setUsername("user001");
        customer.setEmail("test.user.001@example.com");
        customer.setPhoneNumber("12345678901");
        customer.setPostCode("1234567");

        Customer actual = service.retrieve("001");

        assertEquals(customer.getId(), actual.getId());
        assertEquals(customer.getUsername(), actual.getUsername());
        assertEquals(customer.getEmail(), actual.getEmail());
        assertEquals(customer.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(customer.getPostCode(), actual.getPostCode());
    }

    @DisplayName("UPDATE TEST: Check if update succeeded.")
    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setId("002");
        customer.setUsername("user002");
        customer.setEmail("modified.test.user.002@example.com");
        customer.setPhoneNumber("23456789012");
        customer.setPostCode("2222222");

        Customer actual = service.update(customer);
        assertEquals(customer, actual);
    }

    @DisplayName("DELETE TEST: Check if deletion succeeded.")
    @Test
    public void testDelete() {
        String id = "100";

        String actual = service.delete(id);
        assertEquals(id, actual);
    }
}
