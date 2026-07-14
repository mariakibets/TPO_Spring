package pja.edu.pl.s30855.tpo12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration
public class RoleConfig {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMINISTRATOR > ROLE_LIBRARIAN \n" +
                "ROLE_LIBRARIAN > ROLE_PUBLISHER \n" +
                "ROLE_PUBLISHER > ROLE_READER";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }
}
