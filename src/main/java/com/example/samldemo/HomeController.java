package com.example.samldemo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/")
    public String publicPage() {
        return """
                <h1>Page publique</h1>
                <p><a href="/profile">Se connecter avec SAML</a></p>
                """;
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {

        StringBuilder html = new StringBuilder();

        html.append("<h1>Utilisateur connecté</h1>");
        html.append("<p><b>NameID :</b> ").append(principal.getName()).append("</p>");

        html.append("<h2>Attributs SAML reçus</h2>");
        html.append("<ul>");

        for (Map.Entry<String, List<Object>> entry : principal.getAttributes().entrySet()) {
            html.append("<li><b>")
                    .append(entry.getKey())
                    .append("</b> : ")
                    .append(entry.getValue())
                    .append("</li>");
        }

        html.append("</ul>");
        html.append("<p><a href='/logout'>Se déconnecter</a></p>");

        return html.toString();
    }
}