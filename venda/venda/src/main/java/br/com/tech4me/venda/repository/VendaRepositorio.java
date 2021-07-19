package br.com.tech4me.venda.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.venda.model.Venda;

public interface VendaRepositorio extends MongoRepository<Venda, String> {
    
    
}
