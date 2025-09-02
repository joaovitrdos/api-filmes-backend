package Api_filmes.Api_Filmes.repository;

import Api_filmes.Api_Filmes.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface MovieRepository extends JpaRepository<Movie, Long> {

        // Buscar filmes por gênero (contendo texto, ignorando maiúsculas/minúsculas)
        List<Movie> findByGenreContainingIgnoreCase(String genre);

        // Buscar filmes por título (contendo texto, ignorando maiúsculas/minúsculas)
        List<Movie> findByTitleContainingIgnoreCase(String title);

        // Buscar filmes com nota maior ou igual
        List<Movie> findByRatingGreaterThanEqual(Double rating);
}
