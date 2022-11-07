package pl.konsultacje.parent;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konsultacje.child.Child;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "FIRST_NAME")
    private String firstName;
    @Column(nullable = false, name = "LAST_NAME")
    private String lastName;
    @Column(nullable = false, name = "AGE")
    private Integer age;

    @OneToOne(mappedBy = "parent")
    @JsonIgnore
    private Child child;
}
