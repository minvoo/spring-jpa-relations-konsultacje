package pl.konsultacje.child;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import pl.konsultacje.parent.Parent;

import javax.persistence.*;
@Accessors(chain = true)
@Data
public class ChildFormDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Long parentId;


}
