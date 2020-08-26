package com.jobSifarish.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobSifarish.model.UserModel;
@Repository
public interface RegisterDao extends JpaRepository<UserModel, Long> {
	
	UserModel findByUserName(String userNmae);

	

}