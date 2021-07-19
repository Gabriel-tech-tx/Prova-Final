package br.com.tech4me.venda.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.venda.shered.VendaDto;

public interface VendaService {
    List<VendaDto> obterTodos();
    VendaDto criarVenda(VendaDto venda);
    Optional<VendaDto> obterPorId(String id);
    void removerVenda(String id);
   // List<VendaDto> obterPorNome(String nome);
    
}
