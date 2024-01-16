package pl.management.app.management_app.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    @Transient
    public static final String SEQUENCE_NAME = "status_sequence";

    @Id
    private int id;
    private String name;

}
