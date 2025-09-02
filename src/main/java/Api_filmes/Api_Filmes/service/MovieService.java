package Api_filmes.Api_Filmes.service;

import Api_filmes.Api_Filmes.entity.Movie;
import Api_filmes.Api_Filmes.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public  MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    // Buscar todos os filmes
    public List<Movie> findAll() {

        return repository.findAll();
    }

    // Buscar filme por id ou lancar exceção se não existir
    public Movie findByIdOrThrow(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    // Buscar por gênero
    public List<Movie> byGenre(String genre) {

        return repository.findByGenreContainingIgnoreCase(genre);
    }

    // Buscar por nota mínima
    public List<Movie> byMinRating(Double rating) {

        return repository.findByRatingGreaterThanEqual(rating);
    }

    // Buscar po titulo
    public List<Movie> searchByTitle(String title) {

        return repository.findByTitleContainingIgnoreCase(title);
    }

    // Criar filme
    public Movie create(Movie movie) {

        return repository.save(movie);
    }

    // Atualizar filme
    public Movie update(Long id, Movie movie) {

        Movie existing = findByIdOrThrow(id);
        existing.setTitle(movie.getTitle());
        existing.setGenre(movie.getGenre());
        existing.setRating(movie.getRating());
        existing.setReleaseDate(movie.getReleaseDate());
        return  repository.save(existing);
    }

    // Deletar filme
    public void delete(Long id) {
        Movie existing = findByIdOrThrow(id);
        repository.delete(existing);
    }

}
