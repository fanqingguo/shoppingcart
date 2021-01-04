package demo.springboot.web;

import demo.springboot.domain.Product;
import demo.springboot.domain.User;

import demo.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Book 控制层
 *
 * Created by bysocket on 30/09/2017.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        Object user = request.getSession().getAttribute("user");
        if (user==null)
            return "login";
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "productList";
   }
}
