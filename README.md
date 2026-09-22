# DevSpace API

API REST desenvolvida com Java e Spring Boot para gerenciamento de perfis, projetos, tecnologias e feedbacks.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Bean Validation
- Maven

## Estrutura do domínio

A aplicação possui as seguintes entidades:

- Profile
- Project
- Technology
- Feedback

### Relacionamentos

- Profile possui vários Projects — 1:N
- Project possui várias Technologies e uma Technology pode estar em vários Projects — N:N
- Project possui vários Feedbacks — 1:N

## Endpoints

### Perfis

Criar perfil:

```http
POST /api/profiles