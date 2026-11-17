
package br.com.bugnacio.techos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bugnacio.techos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Verifica se já existe um cliente com o telefone informado.
    boolean existsByTelefone(String telefone);

    // Verifica se existe outro cliente com o mesmo telefone,
    // exceto o cliente que está sendo editado.
    boolean existsByTelefoneAndIdNot(String telefone, Long id);

    // Pesquisa clientes pelo nome, ignorando maiúsculas
    // e minúsculas.
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

}
