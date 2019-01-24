package shark.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shark.security.entity.SysRole;

/**
 * @author zhuhh 2019/1/23
 */
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {

    SysRole findByName(String name);
}
