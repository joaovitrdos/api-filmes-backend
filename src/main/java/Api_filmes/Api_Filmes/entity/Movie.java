package Api_filmes.Api_Filmes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titulo é obrigatório")
    private String title;

    @NotBlank(message = "Gênero é obrigatório")
    private String genre;

    @Min(value = 0, message = "Nota mínima é 0")
    @Max(value = 10, message = "Nota máxima é 10")
    private Double rating = 0.0;

    @NotNull(message = "A data de lancamento é obrigatória")
    @PastOrPresent(message = "A data de lançamento deve ser no passado ou hoje")
    private LocalDate releaseDate;

}
