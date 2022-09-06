package com.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Answer;
import com.model.Question;
import com.model.User;
import com.model.request;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	User findByUsername(String username);

	@Query("select m from User m where m.username = :username and m.password = :password ")
	User authenticateuser(@Param("username") String username, @Param("password") String password);

	void save(Question question);

	@Query("select m from Question m where m.id = :id")
	public Question findbyid(@Param("id") int id);

	void save(Answer answer);

	@Query("select m from Question m")
	List<Question> getAllQuestion();
	
	@Query("select m from Question m where m.userid = :id")
	List<Question> findUserQuestions(@Param("id") int id);

	@Modifying
	@Transactional
	@Query("update User c set c.phone =:phn where c.id = :id")
	public void updateUser(@Param("id") int id,@Param("phn") String phone);
	
	@Modifying
	@Transactional
	@Query("delete from User c where c.id = :id")
	public void deleteUser(@Param("id") int id);

}
