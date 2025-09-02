package Api_filmes.Api_Filmes.controller;

import Api_filmes.Api_Filmes.entity.Movie;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Api_filmes.Api_Filmes.service.MovieService;
import java.util.List;

@RestController
@RequestMapping("/api/movies")

public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {

        this.service = service;
    }

    // Listar todos os filmes
    @GetMapping
    public List<Movie> getAll(){

        return service.findAll();
    }

    //Buscar filme por id
    @GetMapping("/{id}")
    public Movie getone(@PathVariable Long id) {

        return service.findByIdOrThrow(id);
    }

    // Buscar por gênero
    @GetMapping("/genre{genre}")
    public List<Movie> getone(@PathVariable String genre) {

        return service.byGenre(genre);
    }

    // Buscar por nota mínima
    @GetMapping("/rating-min/{rating}")
    public List<Movie> byMinRating(@PathVariable Double rating) {

        return service.byMinRating(rating);
    }

    // Buscar por título (contendo texto)
    @GetMapping("/search")
    public List<Movie> search(@RequestParam String q) {

        return service.searchByTitle(q);
    }

    // Criar filme
    @PostMapping
    public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie) {

        return ResponseEntity.ok(service.create(movie));
    }

    // Atualizar filme
    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable Long id, @Valid @RequestBody Movie movie) {

        return ResponseEntity.ok(service.update(id, movie));
    }

    // Deletar filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
