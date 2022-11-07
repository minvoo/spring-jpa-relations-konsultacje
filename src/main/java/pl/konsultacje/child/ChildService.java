package pl.konsultacje.child;

import java.util.List;
import java.util.Optional;

public interface ChildService {

    List<Child> findAllChildren();

    Optional<List<Child>> findChildrenByParentsAge(Integer age);

    Optional<Child> findByChildId(Long id);

    Child updateByChildId(Child child, Long id);

    Child saveChild(Child child);

    void deleteChild(Long id);

}
