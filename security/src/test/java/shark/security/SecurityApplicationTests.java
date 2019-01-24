package shark.security;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import shark.security.entity.SysRole;
import shark.security.entity.SysUser;
import shark.security.repository.SysRoleRepository;
import shark.security.repository.SysUserRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class SecurityApplicationTests {

    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    SysRoleRepository sysRoleRepository;


    @Test
    public void createRole() {
        SysRole role = new SysRole();
        role.setName("ROLE_ADMIN");
        sysRoleRepository.save(role);
        System.out.println(role);
        role = new SysRole();
        role.setName("ROLE_USER");
        sysRoleRepository.save(role);
        System.out.println(role);
    }

    @Test
    public void createSysUser() {
        SysUser newUser = new SysUser();
        newUser.setPassword("zhh");
        newUser.setUsername("zhh");
        List<SysRole> roles = sysRoleRepository.findAll();
        newUser.setRoles(roles);
        sysUserRepository.save(newUser);
        newUser = new SysUser();
        newUser.setUsername("root");
        newUser.setPassword("root");
        newUser.setRoles(roles);
        sysUserRepository.save(newUser);
        System.out.println(newUser);
    }

    @Test
    public void changePassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        List<SysUser> users = sysUserRepository.findAll();
        for (SysUser user : users) {
            String encodedPassword = passwordEncoder.encode(user.getPassword().trim());
            user.setPassword(encodedPassword);
            sysUserRepository.save(user);
        }
    }

    @Test
    public void qryUser() {
        System.out.println(sysUserRepository.findByUsername("zhh"));
    }
}

