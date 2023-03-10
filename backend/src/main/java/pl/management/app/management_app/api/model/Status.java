package pl.management.app.management_app.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    @Id
    private int id;
    private String name;

}
