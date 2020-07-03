import com.tcsoft.security.mapper.UserMapper;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test01 {

    @Resource
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
        DelegatingPasswordEncoder encoder1 = new DelegatingPasswordEncoder("bcrypt", encoders);
        DelegatingPasswordEncoder encoder2 = new DelegatingPasswordEncoder("MD5", encoders);
        DelegatingPasswordEncoder encoder3 = new DelegatingPasswordEncoder("noop", encoders);
        String e1 = encoder1.encode("123456");
        String e2 = encoder2.encode("123456");
        String e3 = encoder3.encode("123456");
        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
    }

    @Test
    public void test01(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = "123456";
        System.out.println(encoder.encode(rawPassword));
    }
}
