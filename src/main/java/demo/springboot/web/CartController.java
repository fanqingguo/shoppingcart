package demo.springboot.web;

import demo.springboot.common.AjaxResult;
import demo.springboot.domain.Cart;
import demo.springboot.domain.Product;
import demo.springboot.domain.User;
import demo.springboot.service.CartService;
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
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(Cart cart,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        boolean b = cartService.addCart(cart, user.getId());
        if (b){
            return new AjaxResult(AjaxResult.Type.SUCCESS,"添加成功！");
        }
        return new AjaxResult(AjaxResult.Type.ERROR,"添加失败！");
    }
    @GetMapping("/viewCart")
    public String viewCart(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");
        Cart cart=new Cart();
        cart.setUserId(user.getId());
        List<Cart> byCarts = cartService.findByCarts(cart);
        model.addAttribute("carts",byCarts);
        return "cart";
    }
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(Cart cart,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        cart.setUserId(user.getId());
        Cart uCart = cartService.findById(cart.getId());
        uCart.setNum(cart.getNum());
        cartService.update(uCart);
        return new AjaxResult(AjaxResult.Type.SUCCESS,"添加成功！");
    }
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Cart cart){
        cartService.delete(cart.getId());
        return new AjaxResult(AjaxResult.Type.SUCCESS,"删除成功！");
    }
    @PostMapping("/deletes")
    @ResponseBody
    public AjaxResult deletes(@RequestParam(value = "ids[]") Long[] ids){
        for (int i = 0; i <ids.length ; i++) {
            cartService.delete(ids[i]);
        }
        return new AjaxResult(AjaxResult.Type.SUCCESS,"删除成功！");
    }
    @GetMapping("/viewOrder")
    public String viewOrder(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");
        Cart cart=new Cart();
        cart.setUserId(user.getId());
        List<Cart> byCarts = cartService.findByCarts(cart);
        model.addAttribute("carts",byCarts);
        return "order";
    }
}
