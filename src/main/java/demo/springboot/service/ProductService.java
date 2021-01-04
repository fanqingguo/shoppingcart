package demo.springboot.service;

import demo.springboot.domain.Product;

import java.util.List;

/**
 * Book 业务接口层
 *
 * Created by bysocket on 30/09/2017.
 */
public interface ProductService {
    /**
     * 获取所有 product
     */
    List<Product> findAll();

    /**
     * 新增 product
     *
     * @param product {@link Product}
     */
    Product insertByProduct(Product product);

    /**
     * 更新 Product
     *
     * @param product {@link Product}
     */
    Product update(Product product);

    /**
     * 删除 Product
     *
     * @param id 编号
     */
    Product delete(Long id);

    /**
     * 获取 Product
     *
     * @param id 编号
     */
    Product findById(Long id);
    /**
     * 获取 Product
     *
     * @param product 编号
     */
    List<Product> findByProducts(Product product);
}
