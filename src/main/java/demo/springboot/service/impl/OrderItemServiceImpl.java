package demo.springboot.service.impl;

import demo.springboot.domain.OrderItem;
import demo.springboot.domain.OrderItemRepository;
import demo.springboot.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderItem 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem insertByOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem delete(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id).get();
        orderItemRepository.delete(orderItem);
        return orderItem;
    }

    @Override
    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id).get();
    }
    @Override
    public List<OrderItem> findByOrderItems(OrderItem item){
        return orderItemRepository.findAll(Example.of(item));
    }
}
