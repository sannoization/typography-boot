package com.boot.typography;


import com.boot.typography.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.annotation.DirtiesContext.ClassMode;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CustomerControllerTest extends TestBase {

    @Test
    void createAndGetCustomerById() throws Exception {
        CustomerDto customerDto = CustomerDto.builder()
                .id(1)
                .phone("0001110101")
                .email("v@t.org")
                .firstName("Vlad")
                .lastName("Vladov")
                .build();

        MvcResult result = mockMvc.perform(
                        post("/customer").content(json(customerDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"))
                .andReturn();

        CustomerDto entity = fromJson(result, CustomerDto.class);

        Assertions.assertEquals("0001110101", entity.getPhone());
        Assertions.assertEquals("v@t.org", entity.getEmail());
        Assertions.assertEquals("Vlad", entity.getFirstName());
        Assertions.assertEquals("Vladov", entity.getLastName());
        Assertions.assertNotNull(entity.getId());

        mockMvc.perform(get("/customer/" + entity.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"));
    }

    @Test
    void createAndGetAllCustomers() throws Exception {
        CustomerDto customerDto = CustomerDto.builder()
                .id(1)
                .phone("0001110101")
                .email("v@t.org")
                .firstName("Vlad")
                .lastName("Vladov")
                .build();

        mockMvc.perform(
                        post("/customer").content(json(customerDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"))
                .andReturn();

        customerDto = CustomerDto.builder()
                .id(2)
                .phone("8005553535")
                .email("vasya@t.ru")
                .firstName("Vasia")
                .lastName("Pupkin")
                .build();

        mockMvc.perform(
                        post("/customer").content(json(customerDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("8005553535"))
                .andExpect(jsonPath("$.email").value("vasya@t.ru"))
                .andExpect(jsonPath("$.first_name").value("Vasia"))
                .andExpect(jsonPath("$.last_name").value("Pupkin"))
                .andReturn();

        MvcResult result = mockMvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].phone").value("0001110101"))
                .andExpect(jsonPath("$.[0].email").value("v@t.org"))
                .andExpect(jsonPath("$.[0].first_name").value("Vlad"))
                .andExpect(jsonPath("$.[0].last_name").value("Vladov"))
                .andReturn();

        JSONArray listOfUsers = fromJsonListResponse(result);

        CustomerDto resultCustomerDto = CustomerDto.builder()
                .firstName(listOfUsers.getJSONObject(0).get("first_name").toString())
                .lastName(listOfUsers.getJSONObject(0).get("last_name").toString())
                .email(listOfUsers.getJSONObject(0).get("email").toString())
                .phone(listOfUsers.getJSONObject(0).get("phone").toString())
                .build();

        Assertions.assertEquals("0001110101", resultCustomerDto.getPhone());
        Assertions.assertEquals("v@t.org", resultCustomerDto.getEmail());
        Assertions.assertEquals("Vlad", resultCustomerDto.getFirstName());
        Assertions.assertEquals("Vladov", resultCustomerDto.getLastName());

        resultCustomerDto = CustomerDto.builder()
                .firstName(listOfUsers.getJSONObject(1).get("first_name").toString())
                .lastName(listOfUsers.getJSONObject(1).get("last_name").toString())
                .email(listOfUsers.getJSONObject(1).get("email").toString())
                .phone(listOfUsers.getJSONObject(1).get("phone").toString())
                .build();

        Assertions.assertEquals("8005553535", resultCustomerDto.getPhone());
        Assertions.assertEquals("vasya@t.ru", resultCustomerDto.getEmail());
        Assertions.assertEquals("Vasia", resultCustomerDto.getFirstName());
        Assertions.assertEquals("Pupkin", resultCustomerDto.getLastName());

    }

    @Test
    void createAndUpdateCustomer() throws Exception {
        CustomerDto customerDto = CustomerDto.builder()
                .id(1)
                .phone("0001110101")
                .email("v@t.org")
                .firstName("Vlad")
                .lastName("Vladov")
                .build();

        mockMvc.perform(
                        post("/customer").content(json(customerDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"))
                .andReturn();

        customerDto.setFirstName("Sergey");
        customerDto.setLastName("Korolev");
        customerDto.setEmail("serg@korolev.com");
        customerDto.setPhone("6663335522");

        mockMvc.perform(put("/customer").content(json(customerDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("6663335522"))
                .andExpect(jsonPath("$.email").value("serg@korolev.com"))
                .andExpect(jsonPath("$.first_name").value("Sergey"))
                .andExpect(jsonPath("$.last_name").value("Korolev"))
                .andReturn();

    }

    @Test
    void createAndDeleteCustomer() throws Exception {
        CustomerDto customerDto = CustomerDto.builder()
                .id(1)
                .phone("0001110101")
                .email("v@t.org")
                .firstName("Vlad")
                .lastName("Vladov")
                .build();

        MvcResult result = mockMvc.perform(
                        post("/customer").content(json(customerDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"))
                .andReturn();

        CustomerDto entity = fromJson(result, CustomerDto.class);

        mockMvc.perform(delete("/customer/" + entity.getId()))
                .andExpect(status().isNoContent());

    }

}
