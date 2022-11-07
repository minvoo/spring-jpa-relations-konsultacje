package pl.konsultacje.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParentController {

    @Autowired
    private ParentService service;

    @GetMapping("/parents")
    public List<Parent> findAllParents() {
        return service.findAllParents();
    }

    @GetMapping("/parents/{id}")
    public Parent findParentById(@PathVariable("id") Long id) {
        return service.findByParentId(id).orElseThrow(() -> new RuntimeException());
    }

    @PostMapping("/parents")
    public Parent saveParent(@RequestBody Parent parent) {
        return service.saveParent(parent);
    }

    @PatchMapping("/parents/{id}")
    public Parent updateParent(@PathVariable("id") Long id,
                               @RequestBody Parent parent) {
        return service.updateByParentId(parent, id);
    }

    @DeleteMapping("/parents/{id}")
    public void deleteChild(@PathVariable("id") Long id) {
        service.deleteParent(id);
    }
}
