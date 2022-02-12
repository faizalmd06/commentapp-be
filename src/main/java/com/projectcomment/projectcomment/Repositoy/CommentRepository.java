package com.projectcomment.projectcomment.Repositoy;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectcomment.projectcomment.Entity.CommentEntity;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer>{

	
	List<CommentEntity> findByEmailId(String emailId); 

}
