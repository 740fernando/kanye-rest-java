package com.conselhosdokanyerest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conselhosdokanyerest.entities.Conselho;

/**
 * CrudRepository - Strategy - interface que obriga a seguir uma estratégia de
 * implementacao.
 * 
 * obs : Só o fato de extendendo para CrudRepository, o spring já entende que eu
 * quero implementar algo concreto para acesso e persistencia de dados e vai
 * fazer a injeção de dependencia. Não é necessário colocar o '@Repository', mas
 * foi colocado para melhorar a leitura e entendimento do código.
 * 
 * @author 740fernando
 *
 */

@Repository
public interface ConselhoRepository extends CrudRepository<Conselho, String> {

}
