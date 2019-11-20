package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
public class EmailController {
    private static Pattern patern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public EmailController(){
        patern = Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping("/haha")
    String getIndex(){
        return "index";

    }
    @PostMapping("/valiadate")
    String valiadateEmail(@RequestParam("email") String email, Model model){
        boolean isvalid = this.validate(email);
        if (!isvalid) {
            model.addAttribute("message", "email is valid");
            return "index";
        }
        model.addAttribute("email", email);
        return "success";
    }
    private boolean validate(String regex){
        matcher = patern.matcher(regex);
        return matcher.matches();
    }

}
