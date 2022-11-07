package pl.konsultacje.child;

import org.springframework.stereotype.Service;
import pl.konsultacje.parent.ParentRepo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ChildServiceImpl implements ChildService {

    private ChildRepo childRepo;
    private ParentRepo parentRepo;

    public ChildServiceImpl(ChildRepo childRepo, ParentRepo parentRepo) {
        this.childRepo = childRepo;
        this.parentRepo = parentRepo;
    }

    @Override
    public List<Child> findAllChildren() {
        return childRepo.findAll();
    }


    //TODO
    @Override
    public List<Child> findChildrenByParentsAge(Integer age) {
        return Collections.emptyList();
    }

    @Override
    public Optional<Child> findByChildId(Long id) {
        return childRepo.findById(id);
    }

    @Override
    public Child updateByChildId(Child request, Long id) {

        Child childEntity = childRepo.findById(id).orElseThrow(() -> new RuntimeException("Child doesnt exists"));

        childEntity.setFirstName(request.getFirstName());
        childEntity.setLastName(request.getLastName());
        childEntity.setAge(request.getAge());

        Child response = saveChild(childEntity);
        return response;
    }

    @Override
    public Child saveChild(Child child) {
        return childRepo.saveAndFlush(child);
    }

    @Override
    public void deleteChild(Long id) {
        childRepo.deleteById(id);

    }
}
