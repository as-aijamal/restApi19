package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.groupDto.request.GroupRequest;
import peaksoft.dto.groupDto.request.GroupRequestRecord;
import peaksoft.dto.groupDto.response.GroupResponse;
import peaksoft.model.Group;

import java.util.List;

public interface GroupService {
    SimpleResponse saveGroup(GroupRequestRecord groupRequest);

    List<GroupResponse> getAllGroup();

    GroupResponse getGroupById(Long id);

    SimpleResponse updateGroup(Long id, GroupRequest groupRequest);

    SimpleResponse deleteGroup(Long id);

    SimpleResponse assignStudentToGroup(Long studentId, Long groupId);
}
