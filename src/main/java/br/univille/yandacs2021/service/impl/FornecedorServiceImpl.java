package br.univille.yandacs2021.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.yandacs2021.model.Fornecedor;
import br.univille.yandacs2021.repository.FornecedorRepository;
import br.univille.yandacs2021.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public void delete(Fornecedor fornecedor) {
        fornecedorRepository.delete(fornecedor);
    }

}