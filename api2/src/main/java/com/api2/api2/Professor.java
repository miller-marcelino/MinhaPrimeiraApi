/*Pacote que o projeto pertence */
package com.api2.api2;

/*Bibliotecas utilizadas */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "professor")
public class Professor extends Pessoa {


@Column(name = "disciplina", columnDefinition="Varchar(60)", nullable = false)    
    public String disciplina;
}
