package com.assgn.signUp.dao;

import com.assgn.signUp.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends JpaRepository<Users, Integer>,QueryByExampleExecutor <Users>{
    public  Users findByUsername(String username);
}
