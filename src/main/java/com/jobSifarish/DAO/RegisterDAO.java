package com.jobSifarish.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobSifarish.DO.UserDO;

@Repository
public interface RegisterDAO extends JpaRepository<UserDO, Long> {

	UserDO findByEmailAddress(String userName);

//	UserModel findByUser_id(Long userId);

}
