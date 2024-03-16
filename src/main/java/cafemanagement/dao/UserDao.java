package cafemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cafemanagement.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
