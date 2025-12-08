package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.groupDto.request.GroupRequest;
import peaksoft.dto.groupDto.request.GroupRequestRecord;
import peaksoft.dto.groupDto.response.GroupResponse;
import peaksoft.model.Group;
import peaksoft.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;

    @PostMapping
    public SimpleResponse saveGroup(@RequestBody GroupRequestRecord groupRequest) {
        return groupService.saveGroup(groupRequest);
    }

    @GetMapping
    public List<GroupResponse> getAllGroups() {
        return groupService.getAllGroup();
    }

    @GetMapping("/{id}")
    public GroupResponse getById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateGroup(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(id, groupRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }


    public SimpleResponse assignStudentToGroup(@PathVariable Long id, @RequestParam Long studentId) {
        return groupService.assignStudentToGroup(studentId, id);
    }

}
