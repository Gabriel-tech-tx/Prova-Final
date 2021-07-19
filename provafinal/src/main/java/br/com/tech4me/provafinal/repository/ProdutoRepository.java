package br.com.tech4me.provafinal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.provafinal.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{
    
}
