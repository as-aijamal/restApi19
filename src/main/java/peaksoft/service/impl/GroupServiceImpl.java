package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Group;
import peaksoft.model.Student;
import peaksoft.repository.GroupRepository;
import peaksoft.repository.StudentRepository;
import peaksoft.service.GroupService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Override
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "Group with id: " + id + " is not found"));
    }

    @Override
    public Group updateGroup(Long id, Group group) {
        Group oldGroup = groupRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "Group with id: " + id + " is not found"));
        oldGroup.setGroupName(group.getGroupName());
        oldGroup.setDescription(group.getDescription());
        oldGroup.setDateOfStart(group.getDateOfStart());
        groupRepository.save(oldGroup);
        return oldGroup;
    }

    @Override
    public String deleteGroup(Long id) {
        if (!groupRepository.existsById(id)) {
            throw new NoSuchElementException(
                    "Group with id: " + id + " is not found");
        }
        groupRepository.deleteById(id);
        return "Group with id: " + id + " is deleted!";
    }

    @Override
    public String assignStudentToGroup(Long studentId, Long groupId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new NoSuchElementException(
                        "Student with id :" + studentId + " is not found"));

        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NoSuchElementException(
                        "Group with id: " + groupId + " is not found"));

        student.setGroup(group);
        group.getStudents().add(student);
        return "Successfully assigned!";
    }
}
