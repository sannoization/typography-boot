package com.boot.typography;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.boot.typography.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;


@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
@Import(TestcontainersConfiguration.class)
@TestInstance(Lifecycle.PER_CLASS)
class EmployeeControllerTest extends TestBase {

    @Test
    void createAndGetEmployeeById() throws Exception {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(1)
                .phone("0001110101")
                .email("v@t.org")
                .firstName("Vlad")
                .lastName("Vladov")
                .build();

        MvcResult result = mockMvc.perform(
                        post("/employee").content(json(employeeDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"))
                .andReturn();

        EmployeeDto entity = fromJson(result, EmployeeDto.class);

        Assertions.assertEquals("0001110101", entity.getPhone());
        Assertions.assertEquals("v@t.org", entity.getEmail());
        Assertions.assertEquals("Vlad", entity.getFirstName());
        Assertions.assertEquals("Vladov", entity.getLastName());
        Assertions.assertNotNull(entity.getId());

        mockMvc.perform(get("/employee/" + entity.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"));
    }

    @Test
    void createAndGetAllEmployees() throws Exception {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(1)
                .phone("0001110101")
                .email("v@t.org")
                .firstName("Vlad")
                .lastName("Vladov")
                .build();

        mockMvc.perform(
                        post("/employee").content(json(employeeDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"))
                .andReturn();

        employeeDto = EmployeeDto.builder()
                .id(2)
                .phone("8005553535")
                .email("vasya@t.ru")
                .firstName("Vasia")
                .lastName("Pupkin")
                .build();

        mockMvc.perform(
                        post("/employee").content(json(employeeDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("8005553535"))
                .andExpect(jsonPath("$.email").value("vasya@t.ru"))
                .andExpect(jsonPath("$.first_name").value("Vasia"))
                .andExpect(jsonPath("$.last_name").value("Pupkin"))
                .andReturn();

        MvcResult result = mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].phone").value("0001110101"))
                .andExpect(jsonPath("$.[0].email").value("v@t.org"))
                .andExpect(jsonPath("$.[0].first_name").value("Vlad"))
                .andExpect(jsonPath("$.[0].last_name").value("Vladov"))
                .andReturn();

        JSONArray listOfUsers = fromJsonListResponse(result);

        EmployeeDto resultEmployeeDto = EmployeeDto.builder()
                .firstName(listOfUsers.getJSONObject(0).get("first_name").toString())
                .lastName(listOfUsers.getJSONObject(0).get("last_name").toString())
                .email(listOfUsers.getJSONObject(0).get("email").toString())
                .phone(listOfUsers.getJSONObject(0).get("phone").toString())
                .build();

        Assertions.assertEquals("0001110101", resultEmployeeDto.getPhone());
        Assertions.assertEquals("v@t.org", resultEmployeeDto.getEmail());
        Assertions.assertEquals("Vlad", resultEmployeeDto.getFirstName());
        Assertions.assertEquals("Vladov", resultEmployeeDto.getLastName());

        resultEmployeeDto = EmployeeDto.builder()
                .firstName(listOfUsers.getJSONObject(1).get("first_name").toString())
                .lastName(listOfUsers.getJSONObject(1).get("last_name").toString())
                .email(listOfUsers.getJSONObject(1).get("email").toString())
                .phone(listOfUsers.getJSONObject(1).get("phone").toString())
                .build();

        Assertions.assertEquals("8005553535", resultEmployeeDto.getPhone());
        Assertions.assertEquals("vasya@t.ru", resultEmployeeDto.getEmail());
        Assertions.assertEquals("Vasia", resultEmployeeDto.getFirstName());
        Assertions.assertEquals("Pupkin", resultEmployeeDto.getLastName());

    }

    @Test
    void createAndUpdateEmployee() throws Exception {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(1)
                .phone("0001110101")
                .email("v@t.org")
                .firstName("Vlad")
                .lastName("Vladov")
                .build();

        mockMvc.perform(
                        post("/employee").content(json(employeeDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"))
                .andReturn();

        employeeDto.setFirstName("Sergey");
        employeeDto.setLastName("Korolev");
        employeeDto.setEmail("serg@korolev.com");
        employeeDto.setPhone("6663335522");

        mockMvc.perform(put("/employee").content(json(employeeDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("6663335522"))
                .andExpect(jsonPath("$.email").value("serg@korolev.com"))
                .andExpect(jsonPath("$.first_name").value("Sergey"))
                .andExpect(jsonPath("$.last_name").value("Korolev"))
                .andReturn();

    }

    @Test
    void createAndDeleteEmployee() throws Exception {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(1)
                .phone("0001110101")
                .email("v@t.org")
                .firstName("Vlad")
                .lastName("Vladov")
                .build();

        MvcResult result = mockMvc.perform(
                        post("/employee").content(json(employeeDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.phone").value("0001110101"))
                .andExpect(jsonPath("$.email").value("v@t.org"))
                .andExpect(jsonPath("$.first_name").value("Vlad"))
                .andExpect(jsonPath("$.last_name").value("Vladov"))
                .andReturn();

        EmployeeDto entity = fromJson(result, EmployeeDto.class);

        mockMvc.perform(delete("/employee/" + entity.getId()))
                .andExpect(status().isNoContent());

    }

}
