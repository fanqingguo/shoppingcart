package demo.springboot.service.impl;

import demo.springboot.common.utils.Guid;
import demo.springboot.domain.*;
import demo.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Order 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order insertByOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order delete(Long id) {
        Order order = orderRepository.findById(id).get();
        orderRepository.delete(order);
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    @Transactional
    public String genOrder(Long userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        List<Cart> userCarts = cartRepository.findAll(Example.of(cart));
        String orderId = Guid.get();
        BigDecimal sums=new BigDecimal(0);
        for (Cart lCart:userCarts){
            BigDecimal sum=new BigDecimal(lCart.getNum()).multiply(lCart.getPrice());
            sums = sum.add(sums);
            cartRepository.deleteById(lCart.getId());
        }
        for (Cart lCart:userCarts){
            OrderItem orderItem = new OrderItem();
            orderItem.setNum(lCart.getNum());
            orderItem.setPrice(lCart.getPrice());
            orderItem.setOrderId(orderId);
            orderItem.setProductName(lCart.getProductName());
            orderItem.setSumPrice(sums);
            orderItemRepository.save(orderItem);
        }
        Order order=new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        orderRepository.save(order);
        return orderId;
    }
    @Override
    public List<Order> findByOrders(Order order){
        List<Order> all = orderRepository.findAll(Example.of(order));
        return all;
    }



}
