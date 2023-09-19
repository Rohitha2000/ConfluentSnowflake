package com.snow.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snow.model.CustomerModel;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Integer>{
//	@Query(value = "SELECT email FROM USER_DATABASE", nativeQuery = true)
//	  public List<String> findEmailAddress();
//	
//	@Query(value="SELECT USERNAME FROM USER_DATABASE", nativeQuery=true)
//	public List<String> findUserNames();
//	
//	@Query(value="SELECT POLICY_NAME FROM USER_DATABASE", nativeQuery=true)
//	public List<String> findPolicyNames();
}
