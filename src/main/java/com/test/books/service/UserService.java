package com.test.books.service;

import com.test.books.model.User;


public interface UserService extends BaseService<User,Long> {
    User findByName(String userName);
}
