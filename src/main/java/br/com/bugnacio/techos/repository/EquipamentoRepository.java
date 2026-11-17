package br.com.bugnacio.techos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bugnacio.techos.model.Equipamento;
import br.com.bugnacio.techos.model.TipoEquipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    boolean existsByTipo(TipoEquipamento tipo);

    boolean existsByTipoAndIdNot(TipoEquipamento tipo, Long id);

}