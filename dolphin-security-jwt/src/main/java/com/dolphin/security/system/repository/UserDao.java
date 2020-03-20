package com.dolphin.security.system.repository;

import com.dolphin.security.system.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shuang.kou
 */
@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer id);

    int deleteByUsername(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User findByUsername(String username);

    List<User> findAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
