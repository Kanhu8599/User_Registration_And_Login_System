package com.springboot.User.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.User.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	Role findByName(String name);

}
