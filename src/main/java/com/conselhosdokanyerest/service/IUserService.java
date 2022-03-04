package com.conselhosdokanyerest.service;

import com.conselhosdokanyerest.entities.User;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio do Mestre. Com isso,
 * se necessário, podemos ter multiplas implementacoes dessa mesma interface
 * 
 * @author 740fernando
 *
 */

public interface IUserService {

	Iterable<User> buscarTodos();

	User buscarPorId(Long id);

	void inserir(User user);

	void atualizar(Long id, User user);

	void deletar(Long id);

}
