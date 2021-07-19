package br.com.tech4me.provafinal.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.tech4me.provafinal.service.ProdutoService;
import br.com.tech4me.provafinal.shared.ProdutoDto;
import br.com.tech4me.provafinal.view.model.ProdutoRequest;
import br.com.tech4me.provafinal.view.model.ProdutoResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService servico;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterProdutos(){
        ModelMapper mapa = new ModelMapper();
        List<ProdutoDto> produtoDto = servico.obterTodos();
        List<ProdutoResponse> produtoResponses = produtoDto.stream()
        .map(prod -> mapa.map(prod, ProdutoResponse.class))
        .collect(Collectors.toList());


        return new ResponseEntity<>(produtoResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarUmProduto(@RequestBody ProdutoRequest produto){
        ModelMapper mapa = new ModelMapper();
        ProdutoDto produtoDto = mapa.map(produto, ProdutoDto.class);
        produtoDto = servico.criarProduto(produtoDto);
        return new ResponseEntity<>(mapa.map(produtoDto, ProdutoResponse.class), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoResponse> obterUmProduto(@PathVariable String id){
        Optional<ProdutoDto> prod = servico.obterPorId(id);

        if(prod.isPresent()){
            return new ResponseEntity<>(new ModelMapper().map(prod.get(), ProdutoResponse.class), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
