package pl.management.app.management_app.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

    @Document(collection = "User")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class User {

        //@Transient
        //public static final String SEQUENCE_NAME = "user_sequence";

        @Id
        private String  id;
        private String username;
        private String password;
        private Set<Role> roles;
        private String firstName;
        private String lastName;
        private String email;
    }


