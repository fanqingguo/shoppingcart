package demo.springboot.service;

import demo.springboot.domain.Cart;
import demo.springboot.domain.OrderItem;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * OrderItem 业务接口层
 *
 * Created by bysocket on 30/09/2017.
 */
public interface OrderItemService {
    /**
     * 获取所有 OrderItem
     */
    List<OrderItem> findAll();

    /**
     * 新增 OrderItem
     *
     * @param orderItem {@link OrderItem}
     */
    OrderItem insertByOrderItem(OrderItem orderItem);

    /**
     * 更新 OrderItem
     *
     * @param orderItem {@link OrderItem}
     */
    OrderItem update(OrderItem orderItem);

    /**
     * 删除 OrderItem
     *
     * @param id 编号
     */
    OrderItem delete(Long id);

    /**
     * 获取 OrderItem
     *
     * @param id 编号
     */
    OrderItem findById(Long id);

    /**
     *
     * @param item
     * @return
     */
    List<OrderItem> findByOrderItems(OrderItem item);
}
