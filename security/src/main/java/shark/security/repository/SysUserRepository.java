package shark.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shark.security.entity.SysUser;

/**
 * @author zhuhh 2019/1/23
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
