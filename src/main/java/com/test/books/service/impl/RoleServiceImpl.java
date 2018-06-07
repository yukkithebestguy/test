package com.test.books.service.impl;

import com.test.books.dao.RoleRepository;
import com.test.books.model.Role;
import com.test.books.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository roleRep;


    @Override
    @Transactional
    public Role save(Role role) {
        return roleRep.save(role);
    }

    @Override
    @Transactional
    public Role update(Role role) {
        return roleRep.save(role);
    }

    @Override
    @Transactional
    public Role findById(Long id){
        Optional<Role> role = roleRep.findById(id);
        return role.orElse(null);
    }

    @Override
    @Transactional
    public Iterable<Role> findAll() {
        return roleRep.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        roleRep.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Role role){
        roleRep.delete(role);
    }

}
