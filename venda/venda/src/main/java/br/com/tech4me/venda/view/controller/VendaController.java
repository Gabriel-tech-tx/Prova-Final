package br.com.tech4me.venda.view.controller;




import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.venda.service.VendaService;
import br.com.tech4me.venda.shered.VendaDto;
import br.com.tech4me.venda.view.model.VendaRequest;
import br.com.tech4me.venda.view.model.VendaResponse;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    VendaService servico;

    @GetMapping
    public ResponseEntity<List<VendaResponse>> obterProdutos(){
        ModelMapper mapa = new ModelMapper();
        List<VendaDto> produtoDto = servico.obterTodos();
        List<VendaResponse> produtoResponses = produtoDto.stream()
        .map(prod -> mapa.map(prod, VendaResponse.class))
        .collect(Collectors.toList());


        return new ResponseEntity<>(produtoResponses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendaResponse> obterUmaVenda(@PathVariable String id){
        Optional<VendaDto> ven = servico.obterPorId(id);

        if(ven.isPresent()){
            return new ResponseEntity<>(new ModelMapper().map(ven.get(), VendaResponse.class), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<VendaResponse> criarVenda(@RequestBody @Valid VendaRequest produto){
        ModelMapper mapa = new ModelMapper();
        VendaDto vendaDto = mapa.map(produto, VendaDto.class);
        vendaDto = servico.criarVenda(vendaDto);
        return new ResponseEntity<>(mapa.map(vendaDto, VendaResponse.class), HttpStatus.CREATED);
    }

    @GetMapping(value = "/status")
    public String status(@Value("${local.sever.port}")String porta){
        return String.format("serviço rodando na porta %s", porta);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removerVenda(@PathVariable String id) {
        servico.removerVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
