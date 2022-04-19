package egg.edu.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    @Id
    @NotBlank(message = "Username is required")
    @Column(name = "users_username", length = 100, nullable = false)
    private String username;

    @NotBlank(message = "Name is required")
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @NotBlank(message = "Surname is required")
    @Column(name = "surname", length = 100, nullable = false)
    private String surname;

    public User() {
    }

    public User(String username, String name, String surname) {
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
