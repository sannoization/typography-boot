package com.boot.typography.config;

import com.boot.typography.conversion.CustomerDtoToEntityConverter;
import com.boot.typography.conversion.CustomerToDtoConverter;
import com.boot.typography.conversion.EmployeeDtoToEntityConverter;
import com.boot.typography.conversion.EmployeeToDtoConverter;
import com.boot.typography.service.DtoConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ConverterRegister implements WebMvcConfigurer {

    private final DtoConversionService conversionService;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        conversionService.addConverter(new EmployeeDtoToEntityConverter());
        conversionService.addConverter(new EmployeeToDtoConverter());
        conversionService.addConverter(new CustomerToDtoConverter());
        conversionService.addConverter(new CustomerDtoToEntityConverter());
    }

}
