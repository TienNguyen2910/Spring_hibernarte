package pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity // mapping với table trong database
@Table(name = "department")
public final class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentId")
    private int id;
    private String DepartmentName;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
//    private  Employee employees;

    public int getId() {
        return id;
    }


    public String getName() {
        return DepartmentName;
    }

    public void setName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }
}
