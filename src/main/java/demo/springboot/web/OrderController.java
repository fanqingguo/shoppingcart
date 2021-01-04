package demo.springboot.web;


import demo.springboot.domain.Order;
import demo.springboot.domain.OrderItem;
import demo.springboot.domain.User;
import demo.springboot.service.OrderItemService;
import demo.springboot.service.OrderService;
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
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @GetMapping("/genOrder")
    public String genOrder(HttpServletRequest request, Model model){
        User user =(User) request.getSession().getAttribute("user");
        String orderId = orderService.genOrder(user.getId());
        model.addAttribute("orderId",orderId);
        return "success";
    }
    @GetMapping("/historyOrders")
    public String historyOrders(HttpServletRequest request,Model model){
        User user =(User) request.getSession().getAttribute("user");
        Order order = new Order();
        order.setUserId(user.getId());
        List<Order> orders = orderService.findByOrders(order);
        model.addAttribute("orders",orders);
        return "historyOrders";
    }
    @GetMapping("/detail/{id}")
    public String detail(HttpServletRequest request,@PathVariable("id") String id,Model model){
        User user =(User) request.getSession().getAttribute("user");
        OrderItem orderItem=new OrderItem();
        orderItem.setOrderId(id);
        List<OrderItem> orderItems = orderItemService.findByOrderItems(orderItem);
        model.addAttribute("orderItems",orderItems);
        return "orderDetail";
    }

}
