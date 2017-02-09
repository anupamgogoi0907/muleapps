package com.anupam.os;

import java.io.Serializable;

import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.util.store.AbstractObjectStore;

public class MyObjectStore implements ObjectStore<Serializable> {

	@Override
	public boolean contains(Serializable key) throws ObjectStoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void store(Serializable key, Serializable value) throws ObjectStoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Serializable retrieve(Serializable key) throws ObjectStoreException {
		System.out.println("Retrirving data.");
		return null;
	}

	@Override
	public Serializable remove(Serializable key) throws ObjectStoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() throws ObjectStoreException {
		// TODO Auto-generated method stub
		
	}

	

}
