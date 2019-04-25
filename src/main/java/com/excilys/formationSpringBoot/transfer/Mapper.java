package com.excilys.formationSpringBoot.transfer;

public interface Mapper<U,V> {
	public V toDTO(U model);
	public U toModel(V DTO);
}
