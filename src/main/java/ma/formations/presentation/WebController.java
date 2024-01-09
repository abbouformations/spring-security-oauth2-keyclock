package ma.formations.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import ma.formations.service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor

public class WebController {

    private IService customerService;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("username", principal.getName());
        return "customers";
    }
}