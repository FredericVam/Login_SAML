SAML Login Demo (Spring Boot)
Description

Ce projet est une application Java Spring Boot démontrant l’implémentation d’un login SAML 2.0 côté Service Provider (SP).

L’application permet de rediriger un utilisateur vers un Identity Provider (IdP),
de recevoir une assertion SAML, de valider l’authentification,
 d’afficher les attributs utilisateur.

Concepts utilisés : 
SAML 2.0
SSO (Single Sign-On)
Identity Provider (IdP)
Service Provider (SP)
Assertions XML
Spring Security SAML2

Technologies:
Java 17+
Spring Boot 3.3.x
Spring Security
OpenSAML (via Spring)
Maven

Prérequis :
Java installé 
Maven installé

Lancer l’application :
mvn spring-boot:run

Accès:
http://localhost:8080/

