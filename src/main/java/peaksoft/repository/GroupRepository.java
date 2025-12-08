package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.groupDto.response.GroupResponse;
import peaksoft.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("select new peaksoft.dto.groupDto.response.GroupResponse(g.id,g.groupName,g.description,g.starts,g.finishes) from Group g")
    List<GroupResponse> getAllGroups();

    Optional<GroupResponse> getGroupById(Long id);

}