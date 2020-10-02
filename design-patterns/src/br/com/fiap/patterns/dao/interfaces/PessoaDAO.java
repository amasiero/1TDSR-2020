package br.com.fiap.patterns.dao.interfaces;

import java.util.List;

public interface PessoaDAO {
    List<String> findAll();
    String findById(long id);
    void save(String person);
    void update(String person);
    void delete(long id);
}
