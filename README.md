# DevSpace API

API REST desenvolvida com Java e Spring Boot para gerenciamento de perfis, projetos, tecnologias e feedbacks.

A aplicação possui regras de negócio para avaliação de projetos, cálculo de nota média, upvotes, filtragem por tecnologia, paginação, tratamento global de erros e documentação interativa com Swagger/OpenAPI.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Bean Validation
- Maven
- Swagger / OpenAPI
- Docker

## Infraestrutura

- Banco de dados em produção: Supabase PostgreSQL
- Deploy da API: Render
- Deploy contínuo integrado ao GitHub
- Credenciais configuradas por variáveis de ambiente

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