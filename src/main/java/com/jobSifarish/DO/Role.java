/**
 * 
 */
package com.jobSifarish.DO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author Kumar
 *

	Jul 24, 2020
 */

public class Role {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
  
    private String name;

  // @ManyToMany(mappedBy = "roles")
   // private List < UserModel > users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List < UserModel > getUsers() {
//        return users;
//    }
//
//    public void setUsers(List < UserModel > users) {
//        this.users = users;
//    }		

}
