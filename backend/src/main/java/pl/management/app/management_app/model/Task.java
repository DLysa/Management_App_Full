package pl.management.app.management_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "Task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    private String id;
    private String title;
    private String description;
    private String userId;
    private List<Comment> commentList;

}
