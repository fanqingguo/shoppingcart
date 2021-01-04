package demo.springboot.service;

import demo.springboot.domain.User;

import java.util.List;

/**
 * Book 业务接口层
 *
 * Created by bysocket on 30/09/2017.
 */
public interface UserService {
    /**
     * 获取所有 user
     */
    List<User> findAll();

    /**
     * 新增 user
     *
     * @param user {@link User}
     */
    User insertByUser(User user);

    /**
     * 更新 User
     *
     * @param user {@link User}
     */
    User update(User user);

    /**
     * 删除 User
     *
     * @param id 编号
     */
    User delete(Long id);

    /**
     * 获取 User
     *
     * @param id 编号
     */
    User findById(Long id);
    /**
     * 获取 User
     *
     * @param user 编号
     */
    List<User> findByUsers(User user);
}
