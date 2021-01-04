package demo.springboot.web;

import demo.springboot.domain.Product;
import demo.springboot.domain.User;
import demo.springboot.service.ProductService;
import demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Book 控制层
 *
 * Created by bysocket on 30/09/2017.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @PostMapping("/login")
    public String login(User user,HttpServletRequest request,Model model){
        List<User> users = userService.findByUsers(user);
        if (users!=null&&users.size()>0){
            request.getSession().setAttribute("user",users.get(0));
            List<Product> products = productService.findAll();
            model.addAttribute("products",products);
            return "productList";
        }
        return "login";
    }
    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";

    }
    @GetMapping("/register")
    public String register(HttpServletRequest request){
        return "regist";
    }
    @PostMapping("/create")
    public String create(User user,HttpServletRequest request){
        request.getSession().invalidate();
        User cuser = userService.update(user);
        request.getSession().setAttribute("user",cuser);
        return "redirect:/";
    }
}
