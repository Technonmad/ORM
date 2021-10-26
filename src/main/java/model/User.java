package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_table", schema = "public", catalog = "postgres")
public class User {
    private int id;
    private String login;
    private String password;
    private String сomments;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = -1)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "сomments", nullable = true, length = -1)
    public String getСomments() {
        return сomments;
    }

    public void setСomments(String сomments) {
        this.сomments = сomments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(сomments, user.сomments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, сomments);
    }
}
