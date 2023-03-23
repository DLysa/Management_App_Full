package pl.management.app.management_app.auth.model;

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
        private String login;
        private String password;
        private String role;
        private String firstName;
        private String lastName;
        private String email;
    }


