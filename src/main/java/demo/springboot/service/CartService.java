package demo.springboot.service;

import demo.springboot.domain.Cart;

import java.util.List;

/**
 * Book 业务接口层
 *
 * Created by bysocket on 30/09/2017.
 */
public interface CartService {
    /**
     * 获取所有 cart
     */
    List<Cart> findAll();

    /**
     * 新增 cart
     *
     * @param cart {@link Cart}
     */
    Cart insertByCart(Cart cart);

    /**
     * 更新 Cart
     *
     * @param cart {@link Cart}
     */
    Cart update(Cart cart);

    /**
     * 删除 Cart
     *
     * @param id 编号
     */
    Cart delete(Long id);

    /**
     * 获取 Cart
     *
     * @param id 编号
     */
    Cart findById(Long id);
    /**
     * 获取 Cart
     *
     * @param cart 编号
     */
    List<Cart> findByCarts(Cart cart);

    /**
     *
     * @param cart
     * @param userId
     * @return
     */
    boolean addCart(Cart cart,Long userId) ;
}
