/*Pacote que o projeto pertence */
package com.api2.api2;

/*Bibliotecas utilizadas */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/* @Entity para criar a tabela e @Table para nomear a tabela */
@Entity
@Table(name = "aluno")
public class Aluno extends Pessoa {

/*@Column serve para criar  uma coluna e definir suas particularidades */
@Column(name = "nota", columnDefinition="FLOAT", nullable = false)
    public float nota;

       
}
