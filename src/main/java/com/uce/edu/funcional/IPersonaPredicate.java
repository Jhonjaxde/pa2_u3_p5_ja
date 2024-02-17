package com.uce.edu.funcional;
@FunctionalInterface
// sirve para controlar que sean interface funcional
public interface IPersonaPredicate <T>{
	public boolean evaluar(T arg);
}
