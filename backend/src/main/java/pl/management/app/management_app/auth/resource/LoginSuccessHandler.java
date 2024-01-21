package pl.management.app.management_app.auth.resource;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.stream.Collectors;

public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> roles = authentication.getAuthorities().stream()
                .map(grantedAuthority -> ((SimpleGrantedAuthority) grantedAuthority).getAuthority())
                .collect(Collectors.toSet());

        String username = authentication.getName();

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("roles", roles);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

        String userInfo ="{\"username\":\"" + username + "\", \"roles\":" + roles + "}";
        response.getWriter().write(userInfo);
        System.out.println(userInfo);

        System.out.println(roles);

        if (roles.contains("ROLE_ADMIN ")) {

            System.out.println("admin");
            getRedirectStrategy().sendRedirect(request, response, "http://localhost:4200/admin");
        } else {
            System.out.println("nie admin");
            getRedirectStrategy().sendRedirect(request, response, "http://localhost:4200");
        }
    }
}
