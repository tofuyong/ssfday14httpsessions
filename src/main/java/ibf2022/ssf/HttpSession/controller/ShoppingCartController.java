package ibf2022.ssf.HttpSession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.ssf.HttpSession.model.Cart;
import ibf2022.ssf.HttpSession.model.Item;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping(path="/cart")
public class ShoppingCartController {
    
    @GetMapping
    public String getCart(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart"); //get latest object from session, to persist session, need key
        if (null == cart) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        model.addAttribute("item", new Item());
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping
    public String postData(@Valid Item item, BindingResult result, Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if(result.hasErrors()) {
            model.addAttribute("item", item);
            model.addAttribute("cart", cart);
            return "cart";
        }
        cart.addItemToCart(item);
        model.addAttribute("item", item);
        model.addAttribute("cart", cart);
        return "cart";
    }

}
