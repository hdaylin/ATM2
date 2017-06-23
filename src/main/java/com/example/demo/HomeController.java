package com.example.demo;

import com.example.demo.Model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by student on 6/22/17.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("transaction", new Transaction());
        return "index";
    }

    @GetMapping("/add")
    public String transactionForm(Model model){
        model.addAttribute("transaction", new Transaction());
        return "index";
    }

    @PostMapping("/add")
    public String transactionSubmit(@ModelAttribute Transaction transaction){
        return "result";
    }

}

