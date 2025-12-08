package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.model.Group;
import peaksoft.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;



    @PostMapping
    public Group saveGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroup();
    }

    @GetMapping("/{id}")
    public Group getById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable Long id, @RequestBody Group group) {
        return groupService.updateGroup(id, group);
    }

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }


    public SimpleResponse assignStudentToGroup(@PathVariable Long id, @RequestParam Long studentId) {
        return groupService.assignStudentToGroup(studentId, id);
    }

}
