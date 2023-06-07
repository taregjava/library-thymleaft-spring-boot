package com.booklibrary.booklibrary;

import com.booklibrary.booklibrary.entity.Role;
import com.booklibrary.booklibrary.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepoistoryTest {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role savedRole =null ;
        if (roleAdmin==null){
            savedRole  = repo.save(roleAdmin);
        }
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

}
