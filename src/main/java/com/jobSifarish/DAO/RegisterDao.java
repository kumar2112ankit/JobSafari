package com.jobSifarish.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobSifarish.model.UserModel;

@Repository
public interface RegisterDao extends JpaRepository<UserModel, Long> {

	UserModel findByUserName(String userNmae);

//	UserModel findByUser_id(Long userId);

}
