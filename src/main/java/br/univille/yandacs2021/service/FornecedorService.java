package br.univille.yandacs2021.service;

import org.springframework.stereotype.Service;
import br.univille.yandacs2021.model.Fornecedor;
import java.util.List;

@Service
public interface FornecedorService {

    public List<Fornecedor> getAllFornecedores();
    public Fornecedor save(Fornecedor fornecedor);
    public void delete(Fornecedor fornecedor);
    
}