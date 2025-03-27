package br.com.cdb.bancodigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.exceptions.ValidacoesException;
import br.com.cdb.bancodigital.repository.ClienteRepository;
import br.com.cdb.bancodigital.validacoes.ValidacoesCliente; // Importe a classe ValidacoesCliente

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ValidacoesCliente validacoesCliente; // Adicione a dependência

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) throws ValidacoesException {
        if (id == null || id <= 0) {
            throw new ValidacoesException("ID do cliente inválido");
        }

        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ValidacoesException("Cliente não encontrado");
        }
        return cliente;
    }

    public Cliente createCliente(Cliente cliente) throws ValidacoesException {
        validacoesCliente.validarCliente(cliente); // Valida o cliente antes de salvar
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente clienteAtualizado) throws ValidacoesException {
        Cliente cliente = getClienteById(id);
        validacoesCliente.validarCliente(clienteAtualizado); // Valida o cliente antes de atualizar
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        cliente.setCep(clienteAtualizado.getCep());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setDataNascimento(clienteAtualizado.getDataNascimento());

        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) throws ValidacoesException {
        getClienteById(id);
        clienteRepository.deleteById(id);
    }
}