package com.anupam.os;

import java.io.Serializable;

import javax.inject.Inject;

import org.mule.api.MuleContext;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.transport.jdbc.JdbcConnector;

public class MyObjectStore implements ObjectStore<Serializable> {

	private JdbcConnector jdbcConnector;
	private String insertQueryKey;
	private String selectQueryKey;
	private String deleteQueryKey;
	private String clearQueryKey;

	@Inject
	MuleContext muleContext;

	public void init() {
		System.out.println("initialised");
	}

	@Override
	public boolean contains(Serializable key) throws ObjectStoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void store(Serializable key, Serializable value) throws ObjectStoreException {
		System.out.println("Storing Data");

	}

	@Override
	public Serializable retrieve(Serializable key) throws ObjectStoreException {
		System.out.println("Retrirving data.");
		return 100;
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

	public JdbcConnector getJdbcConnector() {
		return jdbcConnector;
	}

	public void setJdbcConnector(JdbcConnector jdbcConnector) {
		this.jdbcConnector = jdbcConnector;
	}

	public String getInsertQueryKey() {
		return insertQueryKey;
	}

	public void setInsertQueryKey(String insertQueryKey) {
		this.insertQueryKey = insertQueryKey;
	}

	public String getSelectQueryKey() {
		return selectQueryKey;
	}

	public void setSelectQueryKey(String selectQueryKey) {
		this.selectQueryKey = selectQueryKey;
	}

	public String getDeleteQueryKey() {
		return deleteQueryKey;
	}

	public void setDeleteQueryKey(String deleteQueryKey) {
		this.deleteQueryKey = deleteQueryKey;
	}

	public String getClearQueryKey() {
		return clearQueryKey;
	}

	public void setClearQueryKey(String clearQueryKey) {
		this.clearQueryKey = clearQueryKey;
	}

}
