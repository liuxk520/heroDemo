package cn.liuixiaokang.heroesapi2.controller;

import cn.liuixiaokang.heroesapi2.domain.Hero;
import cn.liuixiaokang.heroesapi2.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(value = "${api.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class HeroController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/heroes")
    public List<Hero> findAllHeroes() {
        return heroService.getAllHeroes();
    }

    @GetMapping("/heroes/{id}")
    public Hero getHeroById(@PathVariable("id") Long id) {
        return heroService.getHeroById(id);
    }

    @GetMapping("/heroes/")
    public List<Hero> searchHeroes(@RequestParam("name") String name) {
        return heroService.findHeroesByName(name);
    }

    @PostMapping("/heroes")
    public Hero addHero(@Valid @RequestBody Hero hero) {
        log.info(hero.getName());
        return heroService.saveHero(hero);
    }

    @PutMapping("/heroes")
    public Hero updateHero(@Valid @RequestBody Hero hero, BindingResult result) {
        /*if (result.hasErrors()) {
            StringBuffer sb = new StringBuffer();
            // 获取错误字段集合
            List<FieldError> fieldErrors = result.getFieldErrors();
            // 获取本地local, zh_CN
            Locale currrentLocale = LocaleContextHolder.getLocale();
            // 遍历错误字段获取错误的信息
            for (FieldError fieldError: fieldErrors) {
                // 获取错误信息
                String errorMessage = messageSource.getMessage(fieldError, currrentLocale);
                // 添加错误信息到集合内
                sb.append(fieldError.getField() + ":" + errorMessage + "     ");
            }
        }*/
        return heroService.saveHero(hero);
    }

    @DeleteMapping("/heroes/{id}")
    public void deleteHero(@PathVariable("id") Long id) {
        heroService.deleteHero(id);
    }



    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, Object>> handlerDataAccessException(DataAccessException e) {
        log.error(e.getMessage(), e);
        Map<String, Object> body = new HashMap<>();
        body.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(body);
    }
}
