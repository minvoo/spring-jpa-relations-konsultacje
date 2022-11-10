package pl.konsultacje.child;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konsultacje.parent.Parent;
import pl.konsultacje.parent.ParentRepo;
import pl.konsultacje.parent.ParentService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ChildServiceImpl implements ChildService {

    private ChildRepo childRepo;
    private ParentRepo parentRepo;

    @Autowired
    private ParentService parentService;

    @Autowired
    private ChildFormMapper childFormMapper;

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
    public Optional<List<Child>> findChildrenByParentsAge(Integer age) {
        return Optional.empty();
    }

    @Override
    public Optional<Child> findByChildId(Long id) {
        return childRepo.findById(id);
    }

    @Override
    public Child updateByChildId(ChildFormDto requestDto, Long id) {

        Child childEntity = childRepo.findById(id).orElseThrow(() -> new RuntimeException("Child doesnt exists"));

        Child requestEntity = childFormMapper.mapToEntity(requestDto);

        System.out.println(requestEntity.getParent());

        childEntity.setFirstName(requestEntity.getFirstName());
        childEntity.setLastName(requestEntity.getLastName());
        childEntity.setAge(requestEntity.getAge());
        childEntity.setParent(requestEntity.getParent());


        Child response = saveChild(childFormMapper.mapToDto(childEntity));
        return response;
    }

    @Override
    public Child saveChild(ChildFormDto childFormDto) {

        Child child = childFormMapper.mapToEntity(childFormDto);
        childRepo.saveAndFlush(child);
        Parent parent = child.getParent();
        parent.setChild(child);
        parentService.saveParent(parent);
        return child;
    }

    @Override
    public void deleteChild(Long id) {
        childRepo.deleteById(id);

    }
}
