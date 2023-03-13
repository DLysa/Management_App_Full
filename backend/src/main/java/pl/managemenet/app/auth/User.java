package pl.managemenet.app.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

    @Document(value = "User")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class User {

        @Id
        private int id;
        private String firstName;
        private String lastName;
        private String email;
    }


