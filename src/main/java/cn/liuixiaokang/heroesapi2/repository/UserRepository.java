package cn.liuixiaokang.heroesapi2.repository;

import cn.liuixiaokang.heroesapi2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
