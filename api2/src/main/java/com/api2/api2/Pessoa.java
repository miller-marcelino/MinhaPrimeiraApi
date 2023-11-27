/*Pacote que o projeto pertence */
package com.api2.api2;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/* @MappedSuperclass notação para garantir que a classe pessoa apenas será uma classe para herança, e não se tornar uma tabela */
@MappedSuperclass
public class Pessoa {

/* @NotBlank, @NotNull, @Size são notações de validações */
    @NotBlank(message = "O nome deverá ser informado")
    @NotNull(message = "Informe o nome")
    @Size(min = 3, max = 60, message = "o nome deverá ter entre 3 e 10 caracteres")
/* @Pattern notação responsável por definir as letras que serão aceitas de a-z, A-Z, á-ú e Á-Ú */
    @Pattern(regexp = "^[a-zA-Zá-úÁ-Ú\s]{3,60}$", message = "O nome deverá conter apenas letras")
/* @Column notação responsável por configurar o tipo, nome da coluna e deixar para permitir que a coluna fique vazia. */
	@Column(name = "nome", columnDefinition="VARCHAR(60)", nullable = false)
    public String nome;

    /* @NotBlank, @NotNull, @Size são notações de validações */
    @NotBlank(message = "O sobrenome deverá ser informado")
    @NotNull(message = "Informe o sobrenome")
    @Size(min = 3, max = 60, message = "o sobrenome deverá ter entre 3 e 10 caracteres")
/* @Pattern notação responsável por definir as letras que serão aceitas de a-z, A-Z, á-ú e Á-Ú */
    @Pattern(regexp = "^[a-zA-Zá-úÁ-Ú\s]{3,60}$", message = "O sobrenome deverá conter apenas letras")
/* @Column notação responsável por configurar o tipo, nome da coluna e deixar para permitir que a coluna fique vazia. */
	@Column(name = "sobrenome", columnDefinition="VARCHAR(60)", nullable = false)
    public String sobrenome;

/* @CPF notação de validação do CPF @Pattern e @Column comentário acima */    
    @CPF
    @Pattern(regexp = "^[0-9]{11}$", message = "O CPF deverá ser numérico e ter 11 dígitos")
	@Column(name = "cpf", columnDefinition="VARCHAR(15)", unique = true, nullable = false)
    public String cpf;

/* @Id responsável por tornar a matrícula como chave primária @Pattern e @Column comentários acima */    
    @Id
/*@GeneratedValue notação para definir a coluna como auto incremento */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matricula")
    public Long matricula;

}
