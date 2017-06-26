package com.example.demo;

import com.example.demo.Model.Transaction;
import com.example.demo.Model.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by student on 6/22/17.
 */

@Controller
public class HomeController {
@Autowired

    private TransactionRepository transactionRepository;
    private Iterable<Transaction> transactionIterable;

    @RequestMapping("/")
        public String index(Model model){
        model.addAttribute("transaction", new Transaction());
        return "index";
    }


    @RequestMapping("/transaction")
    public String addlinks(@Valid Transaction transaction, BindingResult bindingResult, Model model){

        model.addAttribute("transaction", new Transaction());

     /*   if (bindingResult.hasErrors()){
            model.addAttribute("transaction", transactionRepository.findAll());
            return "index";
        }
*/
            Iterable<Transaction>trans=transactionRepository.findAll();
            double balance2 = 0;
            Double balance=balance2;

            for (Transaction item:trans)

              {
                  balance=item.getBalance();
              }
            if (transaction.getAction().equals("deposit")) {
                balance = balance + transaction.getAmount();

            }
            else if (transaction.getAction().equals("withdraw")) {
                balance = balance - transaction.getAmount();
            }
            transaction.setBalance(balance);
            transactionRepository.save(transaction);

            model.addAttribute("transaction", transactionRepository.findAll());
            return "result";

    }

    /*@RequestMapping("/login")
    public String login(@Valid Transaction transaction, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("transaction", new Transaction());
            return "index";
        }
        if( transactionRepository.existsByAcct(transaction.getAcct())){

            model.addAttribute("transaction", new Transaction());

       if (bindingResult.hasErrors()){
            model.addAttribute("transaction", transactionRepository.findAll());
            return "index";
        }
            transactionRepository.save(transaction);


            model.addAttribute("transaction", transactionRepository.findAll());
            return "result";
        }

        return "index";

    }*/

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

