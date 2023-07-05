package com.lsl;


import com.lsl.entity.User;;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@MapperScan("com/lsl/mapper")
@SpringBootApplication
public class MybatisPlusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemoApplication.class, args);
    }

}
@RestController
class demo{
    @PostMapping("/test")
    public String a(@RequestParam  User user){
        User convert = user;
        System.out.println(convert);
        System.out.println(convert.getClass());
        return "sss";
    }
}
@Component
class rundemo implements CommandLineRunner{
    @Autowired
    private ConversionService conversionService;
    @Override
    public void run(String... args) throws Exception {
        User convert = conversionService.convert(1, User.class);
        System.out.println(convert);
        System.out.println(convert.getClass());
        User convert1 = conversionService.convert(2, User.class);
        System.out.println(convert1);
        System.out.println(convert1.getClass());
    }
}

@Component
class intToUser implements Converter<Integer,User> {

    @Override
    public User convert(Integer integer) {
        User user = new User();
        user.setName(String.valueOf(integer));
        return user;
    }

    @Override
    public <U> Converter<Integer, U> andThen(Converter<? super User, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}

@Component
class StringToUser implements Converter<String,User> {

    @Override
    public User convert(String integer) {
        User user = new User();
        user.setName(integer);
        return user;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super User, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}



