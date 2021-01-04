package demo.springboot.service.impl;

import demo.springboot.domain.Cart;
import demo.springboot.domain.CartRepository;
import demo.springboot.domain.Product;
import demo.springboot.domain.ProductRepository;
import demo.springboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Cart 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart insertByCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart delete(Long id) {
        Cart cart = cartRepository.findById(id).get();
        cartRepository.delete(cart);
        return cart;
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findById(id).get();
    }
    @Override
    public List<Cart> findByCarts(Cart cart) {
        List<Cart> all = cartRepository.findAll(Example.of(cart));
        return all;
    }
    @Override
    @Transactional
    public boolean addCart(Cart cart,Long userId) {
        boolean flag=true;
        cart.setUserId(userId);
        Product product = productRepository.findById(cart.getProdcutId()).get();
        List<Cart> carts = findByCarts(cart);
        if (null!=carts&&carts.size()>0){
            Cart qCart = carts.get(0);
            qCart.setNum(qCart.getNum()+1);
            qCart.setPrice(product.getPrice());
            qCart.setUserId(userId);
            qCart.setProdcutId(cart.getProdcutId());
            qCart.setProductName(product.getName());
            update(qCart);
        }else{
            Cart cCart = new Cart();
            cCart.setNum(1L);
            cCart.setUserId(userId);
            cCart.setProdcutId(cart.getProdcutId());
            cCart.getPrice();
            cCart.setPrice(product.getPrice());
            cCart.setProductName(product.getName());
            insertByCart(cCart);
        }
        return flag;
    }
}
