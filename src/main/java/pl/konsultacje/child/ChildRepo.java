package pl.konsultacje.child;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.konsultacje.child.Child;

public interface ChildRepo extends JpaRepository<Child, Long> {
}
