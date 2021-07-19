package br.com.tech4me.venda.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.venda.model.Venda;
import br.com.tech4me.venda.repository.VendaRepositorio;
import br.com.tech4me.venda.shered.VendaDto;

@Service
public class VendaServiceImpl implements VendaService{
    @Autowired
    private VendaRepositorio vendaRepo;
    

    @Override
    public List<VendaDto> obterTodos() {
        List<Venda> vendas = vendaRepo.findAll();

        return vendas.stream().map(v -> new ModelMapper()
        .map(v, VendaDto.class)).collect(Collectors.toList());
        
    }

    @Override
    public VendaDto criarVenda(VendaDto venda) {
        ModelMapper mapa = new ModelMapper();
        Venda ven = mapa.map(venda, Venda.class);
        ven = vendaRepo.save(ven);
        return mapa.map(ven, VendaDto.class);
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
        Optional<Venda> ven = vendaRepo.findById(id);

        if(ven.isPresent()){
           return Optional.of(new ModelMapper().map(ven.get(), VendaDto.class));
        }
        return Optional.empty();
        
    }

    @Override
    public void removerVenda(String id) {
        vendaRepo.deleteById(id);
        
    }     
        
}
