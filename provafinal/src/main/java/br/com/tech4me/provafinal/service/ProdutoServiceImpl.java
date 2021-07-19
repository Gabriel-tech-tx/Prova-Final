package br.com.tech4me.provafinal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.provafinal.model.Produto;
import br.com.tech4me.provafinal.repository.ProdutoRepository;
import br.com.tech4me.provafinal.shared.ProdutoDto;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    @Autowired
    private ProdutoRepository prodRepo;
    
    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = prodRepo.findAll();

        return produtos.stream().map(prod -> new ModelMapper().map(prod, ProdutoDto.class)).collect(Collectors.toList());
        
    }

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        ModelMapper mapa = new ModelMapper();
        Produto prod = mapa.map(produto, Produto.class);
        prod = prodRepo.save(prod);
        return mapa.map(prod, ProdutoDto.class);
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> prod = prodRepo.findById(id);

        if(prod.isPresent()){
           return Optional.of(new ModelMapper().map(prod.get(), ProdutoDto.class));
        }
        return Optional.empty();
    }
    
}
