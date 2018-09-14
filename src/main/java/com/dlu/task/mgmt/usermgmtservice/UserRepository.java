package com.dlu.task.mgmt.usermgmtservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmailAddress(String emailAddress);

    List<User> findUsersByRole(String role);

}
