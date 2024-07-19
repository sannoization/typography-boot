package com.boot.typography;

import com.boot.typography.repository.CustomerRepository;
import com.boot.typography.repository.EmployeeRepository;
import com.boot.typography.repository.GoodsRepository;
import com.boot.typography.repository.OrderRepository;
import com.boot.typography.repository.OrderToCustomerRepository;
import com.boot.typography.service.DtoConversionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.sql.DataSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

public class TestBase {

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Autowired
    protected CustomerRepository customerRepository;

    @Autowired
    protected OrderToCustomerRepository orderToCustomerRepository;

    @Autowired
    protected GoodsRepository goodsRepository;

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected DtoConversionService conversionService;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected DataSource dataSource;

    @Value("classpath:initTest.sql")
    protected Resource resource;

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
    public void initData() throws Exception {
        ScriptUtils.executeSqlScript(dataSource.getConnection(), resource);

    }
// for debug each test only
//    @AfterAll
//    public void clearData() {
//        employeeRepository.deleteAll();
//        customerRepository.deleteAll();
//    }

}
