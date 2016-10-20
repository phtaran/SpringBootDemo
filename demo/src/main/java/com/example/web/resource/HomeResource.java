package com.example.web.resource;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.web.dto.PropertiesDTO;

@RestController("/")
@PropertySource(value="classpath:application.properties")
public class HomeResource {

    @Value("${first_property}")
    String firstProperty;

    @Inject
    Environment environment;

    @RequestMapping(method = RequestMethod.GET)
    String getHomePage() {
        return "home";
    }

    @RequestMapping(value = "property",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PropertiesDTO> getProperty() {

        String secondProperty = environment.getProperty("second_property");
        PropertiesDTO propertiesDTO = new PropertiesDTO(firstProperty, secondProperty);

        return ResponseEntity.ok(propertiesDTO);
    }
}
