package cn.liuixiaokang.heroesapi2;

import cn.liuixiaokang.heroesapi2.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroesApi2ApplicationTests {

    @Autowired
    private Config config;
    @Test
    public void contextLoads() {

        System.out.println(config.getCors().getAllowedHeaders());
    }

}
