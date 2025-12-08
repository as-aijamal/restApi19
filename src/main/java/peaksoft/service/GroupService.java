package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.model.Group;

import java.util.List;

public interface GroupService {
    Group saveGroup(Group group);

    List<Group> getAllGroup();

    Group getGroupById(Long id);

    Group updateGroup(Long id, Group group);

    String deleteGroup(Long id);

    SimpleResponse assignStudentToGroup(Long studentId, Long groupId);
}
