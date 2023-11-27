/*Pacote que o projeto pertence */
package com.api2.api2;

/*Blibliotecas utilizadas */
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProfessor extends JpaRepository <Professor, Long> {
    
}
