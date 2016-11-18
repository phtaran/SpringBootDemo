package com.example.web.resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * OldStyleRestController is controller to use with views.
 * See https://www.genuitec.com/spring-frameworkrestcontroller-vs-controller/
 * and http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/mvc.html
 */
@Controller
public class OldStyleRestController {

    @RequestMapping(value = "/rest/old/test", method = RequestMethod.GET)
    public @ResponseBody
    String getRandomText() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
