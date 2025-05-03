package capstoneds2.creditcard_module.View.Controller;

import capstoneds2.creditcard_module.Model.HistoricoCartao;
import capstoneds2.creditcard_module.Service.HistoricoCartaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/historico")
public class HistoricoCartaoController {

    private final HistoricoCartaoService historicoCartaoService;

    public HistoricoCartaoController(HistoricoCartaoService historicoCartaoService) {
        this.historicoCartaoService = historicoCartaoService;
    }

    @GetMapping("/{cartaoId}")
    public Page<HistoricoCartao> obterHistorico(
            @PathVariable Integer cartaoId,
            @RequestParam(required = false) String inicio,
            @RequestParam(required = false) String fim,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        LocalDate dataInicio = inicio != null ? LocalDate.parse(inicio) : LocalDate.now().minusDays(30);
        LocalDate dataFim = fim != null ? LocalDate.parse(fim) : LocalDate.now();
        return historicoCartaoService.buscarHistorico(cartaoId, dataInicio, dataFim, PageRequest.of(page, size));
    }
}