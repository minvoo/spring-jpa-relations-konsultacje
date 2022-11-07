package pl.konsultacje.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParentRepo extends JpaRepository<Parent, Long> {
    @Query(nativeQuery = true, value = "SELECT * from parents p join child c on p.child_id = c.id where c.age = {age} ")
    List<Parent> findAllByChild_Age(Integer age);
}
