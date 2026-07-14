package pl.edu.pja.s30855.tpo_04_blog.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleID;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();


    public Role(){}

    public Role(String name){
        this.name = name;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String toString() {
        return "Role{id=" + roleID + ", name ='" + name + "'}";
    }
}
