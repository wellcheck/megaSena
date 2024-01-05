package br.com.mega.virada.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "mega_result")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MegaResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "concurso")
    private Integer concurso;

    @Column(name = "data")
    private String data;

    @Column(name = "bola1")
    private Integer bola1;

    @Column(name = "bola2")
    private Integer bola2;

    @Column(name = "bola3")
    private Integer bola3;

    @Column(name = "bola4")
    private Integer bola4;

    @Column(name = "bola5")
    private Integer bola5;

    @Column(name = "bola6")
    private Integer bola6;

}
