package pl.management.app.management_app.auth.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Role")
@Getter
@Setter
@NoArgsConstructor
public class Role {


    @Id
    private String role_id;
    private String role;

}
