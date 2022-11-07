package pl.konsultacje.parent;

import org.springframework.stereotype.Service;
import pl.konsultacje.child.Child;
import pl.konsultacje.child.ChildRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {

    private ChildRepo childRepo;
    private ParentRepo parentRepo;

    public ParentServiceImpl(ChildRepo childRepo, ParentRepo parentRepo) {
        this.childRepo = childRepo;
        this.parentRepo = parentRepo;
    }

    @Override
    public List<Parent> findAllParents() {
        return parentRepo.findAll();
    }


    //TODO
    @Override
    public Optional<List<Parent>> findParentsByChildrenAge(Integer age) {
        return Optional.empty();
    }

    @Override
    public Optional<Parent> findByParentId(Long id) {
        return parentRepo.findById(id);
    }

    @Override
    public Parent updateByParentId(Parent request, Long id) {

        Parent parentEntity = parentRepo.findById(id).orElseThrow(() -> new RuntimeException("Parent doesnt exists"));

        parentEntity.setFirstName(request.getFirstName());
        parentEntity.setLastName(request.getLastName());
        parentEntity.setAge(request.getAge());

        Parent response = saveParent(parentEntity);
        return response;
    }

    @Override
    public Parent saveParent(Parent parent) {
        return parentRepo.saveAndFlush(parent);
    }


    @Override
    public void deleteParent(Long id) {
        parentRepo.deleteById(id);
    }
}
