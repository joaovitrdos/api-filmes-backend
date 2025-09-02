Beleza! Vou criar um README.md no estilo detalhado, usando títulos em markdown (`#` para h1, `##` para h2, etc), exemplos de comandos com `httpie` e tudo mais, baseado no seu projeto de API Filmes.

Segue o conteúdo:

````markdown
# API Filmes

API REST para gerenciar filmes (CRUD), feita com Spring Boot, JPA/Hibernate e MySQL.  
Ideal para desenvolvedores backend júnior que querem praticar conceitos como API REST, validação, e uso de banco relacional.

---

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Hibernate](https://hibernate.org/)
- [Jakarta Validation](https://beanvalidation.org/)
- [MySQL](https://dev.mysql.com/downloads/)
- [Lombok](https://projectlombok.org/)
- Maven

---

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST com Spring MVC
- Validação dos dados com annotations
- Tratamento de erros básico (exceções)
- Uso de Spring Data JPA para consultas customizadas
- Organização do código em camadas (controller, service, repository, entity)
- Configuração automática do Hibernate para criação/atualização do schema no MySQL

---

## Como executar

1. Clone o repositório:

```bash
git clone <url-do-repositorio>
cd Api_Filmes
````

2. Configure o banco MySQL:

```sql
CREATE DATABASE apifilmes;
```

3. Atualize o arquivo `src/main/resources/application.properties` com suas credenciais do MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/apifilmes
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

4. Build e execute o projeto com Maven:

```bash
mvn clean spring-boot:run
```

A aplicação estará rodando em [http://localhost:8080](http://localhost:8080).

---

## API Endpoints

As requisições a seguir foram testadas com a ferramenta [httpie](https://httpie.io/).

### Criar Filme

```bash
http POST :8080/api/movies title="Matrix" genre="Sci-Fi" rating:=9.0 releaseDate="1999-03-31"
```

Resposta:

```json
{
  "id": 1,
  "title": "Matrix",
  "genre": "Sci-Fi",
  "rating": 9.0,
  "releaseDate": "1999-03-31"
}
```

---

### Listar Todos os Filmes

```bash
http GET :8080/api/movies
```

Resposta:

```json
[
  {
    "id": 1,
    "title": "Matrix",
    "genre": "Sci-Fi",
    "rating": 9.0,
    "releaseDate": "1999-03-31"
  },
  {
    "id": 2,
    "title": "Inception",
    "genre": "Action",
    "rating": 8.5,
    "releaseDate": "2010-07-16"
  }
]
```

---

### Buscar Filme por ID

```bash
http GET :8080/api/movies/1
```

Resposta:

```json
{
  "id": 1,
  "title": "Matrix",
  "genre": "Sci-Fi",
  "rating": 9.0,
  "releaseDate": "1999-03-31"
}
```

---

### Buscar Filmes por Gênero

```bash
http GET :8080/api/movies/genreSci-Fi
```

Resposta:

```json
[
  {
    "id": 1,
    "title": "Matrix",
    "genre": "Sci-Fi",
    "rating": 9.0,
    "releaseDate": "1999-03-31"
  }
]
```

---

### Buscar Filmes por Nota Mínima

```bash
http GET :8080/api/movies/rating-min/8.0
```

Resposta:

```json
[
  {
    "id": 1,
    "title": "Matrix",
    "genre": "Sci-Fi",
    "rating": 9.0,
    "releaseDate": "1999-03-31"
  },
  {
    "id": 2,
    "title": "Inception",
    "genre": "Action",
    "rating": 8.5,
    "releaseDate": "2010-07-16"
  }
]
```

---

### Buscar Filmes pelo Título (Contendo Texto)

```bash
http GET :8080/api/movies/search?q=mat
```

Resposta:

```json
[
  {
    "id": 1,
    "title": "Matrix",
    "genre": "Sci-Fi",
    "rating": 9.0,
    "releaseDate": "1999-03-31"
  }
]
```

---

### Atualizar Filme

```bash
http PUT :8080/api/movies/1 title="Matrix Reloaded" genre="Sci-Fi" rating:=8.7 releaseDate="2003-05-15"
```

Resposta:

```json
{
  "id": 1,
  "title": "Matrix Reloaded",
  "genre": "Sci-Fi",
  "rating": 8.7,
  "releaseDate": "2003-05-15"
}
```

---

### Deletar Filme

```bash
http DELETE :8080/api/movies/1
```

Resposta: (No Content - HTTP 204)

---

## Observações

* O campo `rating` aceita valores entre 0 e 10.
* `releaseDate` deve ser data passada ou presente.
* Caso o filme não seja encontrado, a API retorna erro 404 com mensagem.
* Use o cabeçalho `Content-Type: application/json` para POST e PUT.

