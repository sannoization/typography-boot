package com.boot.typography;

import com.boot.typography.data.Employee;
import com.boot.typography.dto.EmployeeDto;
import com.boot.typography.repository.EmployeeRepository;
import com.boot.typography.service.DtoConversionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

public class TestBase {

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected DtoConversionService conversionService;

    @Autowired
    protected ObjectMapper objectMapper;

    protected String json(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    protected <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    protected <T> T fromJson(MvcResult result, Class<T> clazz) throws IOException {
        return objectMapper.readValue(result.getResponse().getContentAsString(), clazz);
    }

    protected JSONArray fromJsonListResponse(MvcResult result) throws IOException, JSONException {
        return new JSONArray(result.getResponse().getContentAsString());
    }

    @BeforeAll
    public void initData() {

        EmployeeDto employee1Dto = EmployeeDto.builder()
                .firstName("alex")
                .lastName("buhalex")
                .phone("9995553535")
                .email("email@email.com")
                .build();

        Employee entity1 = conversionService.convert(employee1Dto, Employee.class);
        employeeRepository.save(entity1);
    }

    @AfterEach
    public void clearData() {
        employeeRepository.deleteAll();
    }

}
