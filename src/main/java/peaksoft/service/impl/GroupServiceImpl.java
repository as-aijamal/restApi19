package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.groupDto.request.GroupRequest;
import peaksoft.dto.groupDto.request.GroupRequestRecord;
import peaksoft.dto.groupDto.response.GroupResponse;
import peaksoft.model.Group;
import peaksoft.model.Student;
import peaksoft.repository.GroupRepository;
import peaksoft.repository.StudentRepository;
import peaksoft.service.GroupService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Override
    public SimpleResponse saveGroup(GroupRequestRecord groupRequest) {
        Group group = new Group();
        group.setGroupName(groupRequest.groupName());
        group.setDescription(groupRequest.description());
        group.setStarts(LocalDate.now());
        group.setFinishes(groupRequest.finishes());
        groupRepository.save(group);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Group with id: %s is successfully saved", group.getId()))
                .build();
    }

    @Override
    public List<GroupResponse> getAllGroup() {
        return groupRepository.getAllGroups();
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        return groupRepository.getGroupById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "Group with id: " + id + " is not found"));
    }

    @Override
    public SimpleResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "Group with id: " + id + " is not found"));
        group.setGroupName(groupRequest.getGroupName());
        group.setDescription(groupRequest.getDescription());
        group.setStarts(LocalDate.now());
        group.setFinishes(groupRequest.getFinishes());
        groupRepository.save(group);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Group with id: %s is successfully updated", group.getId()))
                .build();
    }

    @Override
    public SimpleResponse deleteGroup(Long id) {
        if (!groupRepository.existsById(id)) {
            throw new NoSuchElementException(
                    "Group with id: " + id + " is not found");
        }
        groupRepository.deleteById(id);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Group with id: %s is successfully deleted", id))
                .build();
    }

    @Override
    public SimpleResponse assignStudentToGroup(Long studentId, Long groupId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new NoSuchElementException(
                        "Student with id :" + studentId + " is not found"));

        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NoSuchElementException(
                        "Group with id: " + groupId + " is not found"));

        student.setGroup(group);
        group.getStudents().add(student);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Student with id: " + studentId + " is assigned to group with id: " + groupId)
                .build();
    }
}
