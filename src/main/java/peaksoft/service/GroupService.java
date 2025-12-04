package peaksoft.service;

import peaksoft.model.Group;

import java.util.List;

public interface GroupService {
    Group saveGroup(Group group);

    List<Group> getAllGroup();

    Group getGroupById(Long id);

    Group updateGroup(Long id, Group group);

    String deleteGroup(Long id);

    String assignStudentToGroup(Long studentId, Long groupId);
}
