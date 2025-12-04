package peaksoft.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_gen")
    @SequenceGenerator(
            name = "group_gen",
            sequenceName = "group_seq",
            allocationSize = 1
    )
    private Long id;
    private String groupName;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfStart;
    @OneToMany(mappedBy = "group")
    private List<Student> students;

    public Group(String groupName, String description, Long id, LocalDate dateOfStart, List<Student> students) {
        this.groupName = groupName;
        this.description = description;
        this.id = id;
        this.dateOfStart = dateOfStart;
        this.students = students;
    }

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
