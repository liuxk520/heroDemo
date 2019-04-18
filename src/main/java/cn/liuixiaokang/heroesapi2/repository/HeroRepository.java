package cn.liuixiaokang.heroesapi2.repository;

import cn.liuixiaokang.heroesapi2.domain.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {

    @Query("select h from Hero h where lower(name) like concat('%', lower(:name), '%') ")
    List<Hero> findByName(@Param("name") String name);
}
