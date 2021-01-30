package io.github.vicenteMourao.pdCase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.vicenteMourao.pdCase.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query ("Select id,email,enabled,name,surname,phone,register_date,username,password from Users u where upper(u.name) like upper(:name) or upper(u.username) like upper(:username) or  upper(u.email) like upper(:email)")
	List<Users> findByNomeandUsernameAndEmail(@Param ("name") String name, @Param ("username")String username, @Param ("email")String email);

}
