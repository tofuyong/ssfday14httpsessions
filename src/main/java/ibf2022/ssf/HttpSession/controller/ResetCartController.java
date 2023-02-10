package ibf2022.ssf.HttpSession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/resetcart")
public class ResetCartController {

    @GetMapping
    public String resetCart(HttpSession session) {
        session.invalidate();
        return "redirect:cart";
    }
    
}
