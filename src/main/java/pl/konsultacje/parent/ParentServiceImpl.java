package pl.konsultacje.parent;

import org.springframework.stereotype.Service;
import pl.konsultacje.child.Child;
import pl.konsultacje.child.ChildRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Parent> findParentsByChildrenAge(Integer age) {
        return childRepo.findAllByAge(age).stream()
                .map(child -> child.getParent())
                .collect(Collectors.toList());
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
        parent.getChild().add(new Child(1,));
        return parentRepo.saveAndFlush(parent);
    }


    @Override
    public void deleteParent(Long id) {
        parentRepo.deleteById(id);
    }
}
