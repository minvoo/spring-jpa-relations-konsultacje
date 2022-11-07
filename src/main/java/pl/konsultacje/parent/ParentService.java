package pl.konsultacje.parent;

import pl.konsultacje.child.Child;

import java.util.List;
import java.util.Optional;

public interface ParentService {


    List<Parent> findAllParents();

    Optional<List<Parent>> findParentsByChildrenAge(Integer age);

    Optional<Parent> findByParentId(Long id);

    Parent updateByParentId(Parent parent, Long  id);

    Parent saveParent(Parent parent);

    void deleteParent(Long id);
}
