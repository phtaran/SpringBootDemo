package com.example.web.resource;

import com.example.domain.Account;
import com.example.service.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class GreetingController {

    @Autowired
    private AccountManager accountManager;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/hello")
    public @ResponseBody String getSession(HttpSession session) {
        return "greeting";
    }

    @ModelAttribute
    public Account addAccount(@RequestParam String number) {
        return accountManager.findAccount(number);
    }

// Add multiple attributes

    @ModelAttribute
    public void populateModel(@RequestParam String number, Model model) {
        model.addAttribute(accountManager.findAccount(number));
        // add more ...
    }
}
