package cn.liuixiaokang.heroesapi2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HeroNotFoundException extends RuntimeException{

    public HeroNotFoundException(String message, Object... args) {
        super(String.format(message, args));
    }

    public HeroNotFoundException(Long id) {
        this("Could not find hero with id '%s'", id);
    }

    public HeroNotFoundException(String username) {
        this("Could not find hero with username '%s'", username);
    }
}
