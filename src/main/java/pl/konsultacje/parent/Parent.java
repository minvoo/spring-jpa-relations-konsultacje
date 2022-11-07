package pl.konsultacje.parent;


import lombok.Data;
import pl.konsultacje.child.Child;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name = "parent")
public class Parent {

    "select id from parents where id in (select )"

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "FIRST_NAME")
    private String firstName;

    @Column(nullable = false, name = "LAST_NAME")
    private String lastName;

    @Column(nullable = false, name = "AGE")
    private Integer age;

    @OneToMany(fetch = FetchType, cascade = CascadeType.ALL)
    @JoinColumn(name = "child_id")
    private List<Child> child;


    p = new Parent(1, "A", "b0", 3, List.of())
    parentrepo.save(p)

}
