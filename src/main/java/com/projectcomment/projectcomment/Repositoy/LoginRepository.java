package com.projectcomment.projectcomment.Repositoy;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectcomment.projectcomment.Entity.LoginEntity;
@Repository

public interface LoginRepository extends JpaRepository<LoginEntity,Integer>{

	
	List<LoginEntity> findByEmailId(String emailId);
	
	List<LoginEntity> findByEmailIdAndPassword(String emailId, String password);
	
	List<LoginEntity> findByEmailIdAndSecreteCode(String emailId, String secreteCode);
}
