package bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ydc on 16-11-7.
 */
@Entity
@Table
public class User {

    private int id;
    private String name;
    private String pwd;
    private Date brithday;
    private Department dept;

    public User() {
    }

    public User(int id, String name, String pwd, Date brithday, Department dept) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.brithday = brithday;
        this.dept = dept;
    }

    @javax.persistence.Id
    @GeneratedValue
    @Column(length = 36, nullable = false, updatable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 100, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Temporal(value = TemporalType.DATE)
    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    @ManyToOne
    @JoinColumn
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", brithday=" + brithday +
                ", dept=" + dept.getName() +
                '}';
    }
}
