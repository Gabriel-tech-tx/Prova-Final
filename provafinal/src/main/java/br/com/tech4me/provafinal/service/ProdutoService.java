package br.com.tech4me.provafinal.service;

import java.util.List;
import java.util.Optional;


import br.com.tech4me.provafinal.shared.ProdutoDto;

public interface ProdutoService {
    List<ProdutoDto> obterTodos();
    ProdutoDto criarProduto(ProdutoDto produto);
    Optional<ProdutoDto> obterPorId(String id);
}
//vender só vai ter post e get