package br.com.cdb.bancodigital.validacoes;

import org.springframework.stereotype.Component;

import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.exceptions.ValidacoesException;

@Component
public class ValidacoesCliente {

    public void validarNome(String nome) throws ValidacoesException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacoesException("O nome é obrigatório.");
        }
        if (nome.length() > 100) {
            throw new ValidacoesException("O nome deve ter no máximo 100 caracteres.");
        }
        if (!nome.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ\\s]+$")) {
            throw new ValidacoesException("Nome inválido. Deve conter apenas letras e espaços.");
        }
    }

    public void validarCpf(String cpf) throws ValidacoesException {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new ValidacoesException("O CPF é obrigatório.");
        }
        if (!cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$|^\\d{11}$")) {
            throw new ValidacoesException("CPF inválido. Deve estar no formato XXX.XXX.XXX-XX ou XXXXXXXXXXX.");
        }
    }

    public void validarEndereco(String endereco) throws ValidacoesException {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new ValidacoesException("O endereço é obrigatório.");
        }
        if (endereco.length() < 5 || endereco.length() > 200) {
            throw new ValidacoesException("O endereço deve ter entre 5 e 200 caracteres.");
        }
        if (!endereco.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ\\s\\d,\\-]+$")) {
            throw new ValidacoesException("Endereço inválido. Deve conter apenas letras, números, espaços, vírgulas e hífens.");
        }
    }

    public void validarCep(String cep) throws ValidacoesException {
        if (cep == null || cep.trim().isEmpty()) {
            throw new ValidacoesException("O CEP é obrigatório.");
        }
        if (!cep.matches("^\\d{5}\\-\\d{3}$|^\\d{8}$")) {
            throw new ValidacoesException("CEP inválido. Deve estar no formato XXXXX-XXX ou XXXXXXXX.");
        }
    }

    public void validarTelefone(String telefone) throws ValidacoesException {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new ValidacoesException("O telefone é obrigatório.");
        }
        if (!telefone.matches("^\\(\\d{2}\\) \\d{5}\\-\\d{4}$|^\\d{11}$")) {
            throw new ValidacoesException("Telefone inválido. Deve estar no formato (XX) XXXXX-XXXX ou XXXXXXXXXXX.");
        }
    }

    public void validarDataNascimento(String dataNascimento) throws ValidacoesException {
        if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
            throw new ValidacoesException("A data de nascimento é obrigatória.");
        }
        if (!dataNascimento.matches("^\\d{2}\\/\\d{2}\\/\\d{4}$|^\\d{2}\\-\\d{2}\\-\\d{4}$|^\\d{4}\\-\\d{2}\\-\\d{2}$|^\\d{8}$|^\\d{8}$")) {
            throw new ValidacoesException("Data de nascimento inválida. Deve estar nos formatos DD/MM/AAAA, DD-MM-AAAA, AAAA-MM-DD, AAAAMMDD ou DDMMYYYY.");
        }
    }

    public void validarCliente(Cliente cliente) throws ValidacoesException {
        validarNome(cliente.getNome());
        validarCpf(cliente.getCpf());
        validarEndereco(cliente.getEndereco());
        validarCep(cliente.getCep());
        validarTelefone(cliente.getTelefone());
        validarDataNascimento(cliente.getDataNascimento());
    }
}