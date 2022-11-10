package pl.konsultacje.child;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.konsultacje.parent.Parent;
import pl.konsultacje.parent.ParentRepo;
import pl.konsultacje.parent.ParentService;

@Component
@Slf4j
public class ChildFormMapper {

    @Autowired
    private ParentRepo parentRepo;


    public Child mapToEntity(ChildFormDto childFormDto) {

        Long parentId = childFormDto.getParentId();
        System.out.println(parentId);

        Parent parentFromId = parentRepo.findById(childFormDto.getParentId()).orElseThrow(() -> new RuntimeException());

        Child child = new Child().setId(childFormDto.getId())
                .setAge(childFormDto.getAge())
                .setFirstName(childFormDto.getFirstName())
                .setLastName(childFormDto.getLastName())
                .setParent(parentFromId);

        return child;
    }

    public ChildFormDto mapToDto(Child child) {

        return new ChildFormDto()
                .setId(child.getId())
                .setLastName(child.getLastName())
                .setFirstName(child.getFirstName())
                .setParentId(child.getParent().getId())
                .setAge(child.getAge());
    }
}
