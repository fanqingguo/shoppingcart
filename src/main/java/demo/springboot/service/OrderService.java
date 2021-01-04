package demo.springboot.service;

import demo.springboot.domain.Cart;
import demo.springboot.domain.Order;

import java.util.List;

/**
 * Order 业务接口层
 *
 * Created by bysocket on 30/09/2017.
 */
public interface OrderService {
    /**
     * 获取所有 Order
     */
    List<Order> findAll();

    /**
     * 新增 Order
     *
     * @param order {@link Order}
     */
    Order insertByOrder(Order order);

    /**
     * 更新 Order
     *
     * @param order {@link Order}
     */
    Order update(Order order);

    /**
     * 删除 Order
     *
     * @param id 编号
     */
    Order delete(Long id);

    /**
     * 获取 Order
     *
     * @param id 编号
     */
    Order findById(Long id);

    /**
     *
     * @param userId
     * @return
     */
    String genOrder(Long userId);
    /**
     * 获取 orders
     *
     * @param order 编号
     */
    List<Order> findByOrders(Order order);
}
