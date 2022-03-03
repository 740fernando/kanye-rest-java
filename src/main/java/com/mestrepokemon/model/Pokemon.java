package com.mestrepokemon.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Os atributos desse modelo foram gerados automaticamente pelo site
 * jsonschema2pojo.org. Para isso, usamos o JSON de retorno da API do pokeapi.
 * 
 * @see <a href="https://www.jsonschema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://pokeapi.co/docs/v2#pokemon">pokemon</a>
 * 
 * @author 740Fernando
 */

@Entity
public class Pokemon {
	
	@Id
	private Integer id;
	private String name;
	private Integer baseExperience;
	private Integer height;
	private Boolean isDefault;
	private Integer order;
	private Integer weight;
	
	public Integer getId() {
		return id;
		}

		public void setId(Integer id) {
		this.id = id;
		}

		public String getName() {
		return name;
		}

		public void setName(String name) {
		this.name = name;
		}

		public Integer getBaseExperience() {
		return baseExperience;
		}

		public void setBaseExperience(Integer baseExperience) {
		this.baseExperience = baseExperience;
		}

		public Integer getHeight() {
		return height;
		}

		public void setHeight(Integer height) {
		this.height = height;
		}

		public Boolean getIsDefault() {
		return isDefault;
		}

		public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
		}

		public Integer getOrder() {
		return order;
		}

		public void setOrder(Integer order) {
		this.order = order;
		}

		public Integer getWeight() {
		return weight;
		}

		public void setWeight(Integer weight) {
		this.weight = weight;
		}

}
