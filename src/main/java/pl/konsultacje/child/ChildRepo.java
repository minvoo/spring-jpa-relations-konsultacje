package pl.konsultacje.child;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.konsultacje.child.Child;

import java.util.List;

public interface ChildRepo extends JpaRepository<Child, Long> {
    List<Child> findAllByAge(Integer age);
}
