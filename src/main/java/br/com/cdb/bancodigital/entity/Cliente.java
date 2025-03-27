package br.com.cdb.bancodigital.entity;

import br.com.cdb.bancodigital.enuns.TipoCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ\\s]+$", message = "Nome inválido. Deve conter apenas letras e espaços")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$|^\\d{11}$", message = "CPF inválido. Deve estar no formato XXX.XXX.XXX-XX ou XXXXXXXXXXX")
    @Column(nullable = false, length = 14)
    private String cpf;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(min = 5, max = 200, message = "O endereço deve ter entre 5 e 200 caracteres")
    @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ\\s\\d,\\-]+$", message = "Endereço inválido. Deve conter apenas letras, números, espaços, vírgulas e hífens")
    @Column(nullable = false, length = 200)
    private String endereco;

    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "^\\d{5}\\-\\d{3}$|^\\d{8}$", message = "CEP inválido. Deve estar no formato XXXXX-XXX ou XXXXXXXX")
    @Column(nullable = false, length = 9)
    private String cep;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "^\\(\\d{2}\\) \\d{5}\\-\\d{4}$|^\\d{11}$", message = "Telefone inválido. Deve estar no formato (XX) XXXXX-XXXX ou XXXXXXXXXXX")
    @Column(nullable = false, length = 20)
    private String telefone;

    @NotBlank(message = "A data de nascimento é obrigatória")
    @Pattern(regexp = "^\\d{2}\\/\\d{2}\\/\\d{4}$|^\\d{2}\\-\\d{2}\\-\\d{4}$|^\\d{4}\\-\\d{2}\\-\\d{2}$|^\\d{8}$|^\\d{8}$", message = "Data de nascimento inválida. Deve estar nos formatos DD/MM/AAAA, DD-MM-AAAA, AAAA-MM-DD, AAAAMMDD ou DDMMYYYY")
    @Column(nullable = false, length = 10)
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCliente tipoCliente;

    public Cliente() {}

    public Cliente(String nome, String cpf, String endereco, String cep, String telefone, String dataNascimento, TipoCliente tipoCliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.tipoCliente = tipoCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}