package capstoneds2.creditcard_module.Service;

import capstoneds2.creditcard_module.Model.HistoricoCartao;
import capstoneds2.creditcard_module.Repository.HistoricoCartaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HistoricoCartaoService {

    private final HistoricoCartaoRepository historicoCartaoRepository;

    public HistoricoCartaoService(HistoricoCartaoRepository historicoCartaoRepository) {
        this.historicoCartaoRepository = historicoCartaoRepository;
    }

    public Page<HistoricoCartao> buscarHistorico(Integer cartaoId, LocalDate inicio, LocalDate fim, Pageable pageable) {
        return historicoCartaoRepository.findByCartao_Cartao_idAndData_alteracaoBetweenOrderByData_alteracaoDesc(
                cartaoId, inicio, fim, pageable);
    }
}