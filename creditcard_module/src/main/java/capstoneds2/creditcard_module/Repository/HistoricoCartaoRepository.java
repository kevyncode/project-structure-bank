package capstoneds2.creditcard_module.Repository;

import capstoneds2.creditcard_module.Model.HistoricoCartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface HistoricoCartaoRepository extends JpaRepository<HistoricoCartao, Long> {
    Page<HistoricoCartao> findByCartao_Cartao_idAndData_alteracaoBetweenOrderByData_alteracaoDesc(
            Integer cartaoId, LocalDate inicio, LocalDate fim, Pageable pageable);
}