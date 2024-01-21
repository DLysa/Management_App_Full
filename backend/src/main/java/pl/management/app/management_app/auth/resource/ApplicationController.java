package pl.management.app.management_app.auth.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.management.app.management_app.auth.model.User;
import pl.management.app.management_app.auth.service.CustomUserDetails;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

    @GetMapping("/process")
    public String process() {

        return "processing..";
    }

    // In your Spring Boot Controller

    @GetMapping("/userinfo")
    public ResponseEntity<?> getUserInfo(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No authenticated user");
        }

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("firstName", customUserDetails.getFirstName());
        userInfo.put("lastName", customUserDetails.getLastName());
        userInfo.put("roles", authentication.getAuthorities());

        return ResponseEntity.ok(userInfo);
    }

}
