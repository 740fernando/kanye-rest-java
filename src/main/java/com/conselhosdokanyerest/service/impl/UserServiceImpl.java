package com.conselhosdokanyerest.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conselhosdokanyerest.dao.ConselhoRepository;
import com.conselhosdokanyerest.dao.UserRepository;
import com.conselhosdokanyerest.entities.Conselho;
import com.conselhosdokanyerest.entities.User;
import com.conselhosdokanyerest.exceptions.UserExceptions;
import com.conselhosdokanyerest.service.IConselhoService;
import com.conselhosdokanyerest.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ConselhoRepository conselhoRepository;

	@Autowired
	private IConselhoService iconselhoService;

	@Override
	public Iterable<User> buscarTodos() {
		return userRepository.findAll();
	}

	@Override
	public User buscarPorId(Long id) {
		Optional<User> user = userRepository.findById(id);
		validaUserId(user);
		return user.get();
	}

	@Override
	public void inserir(User user) {
		validaUserNome(user);
		salvarUser(user);
	}

	@Override
	public void atualizar(Long id, User user) {
		Optional<User> userBd = userRepository.findById(id);
		if (userBd.isPresent()) {
			salvarUser(user);
		}
	}

	@Override
	public void deletar(Long id) {
		userRepository.deleteById(id);
	}

	private void salvarUser(User user) {

		String quote = user.getConselho().getQuote();
		Conselho conselho = conselhoRepository.findById(quote).orElseGet(() -> {
			Conselho novoConselho = iconselhoService.consultarPorId(quote);
			conselhoRepository.save(novoConselho);
			return novoConselho;
		});
		user.setConselho(conselho);
		userRepository.save(user);
	}

	private void validaUserNome(User user) {
		if (user.getNome() == null) {
			throw new UserExceptions("Nao foi encontrado o usuário");
		}
	}

	private void validaUserId(Optional<User> user) {
		if (!user.isPresent()) {
			throw new UserExceptions("Nao foi encontrado o usuário");
		}
	}

}
