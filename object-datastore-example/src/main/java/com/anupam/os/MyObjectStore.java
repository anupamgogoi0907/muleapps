package com.anupam.os;

import java.io.Serializable;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.mule.api.MuleContext;
import org.mule.api.execution.ExecutionCallback;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.api.transaction.TransactionConfig;
import org.mule.config.i18n.CoreMessages;
import org.mule.execution.TransactionalExecutionTemplate;
import org.mule.transaction.MuleTransactionConfig;

public class MyObjectStore implements ObjectStore<Serializable> {

	private String insertQueryKey;
	private String selectQueryKey;
	private String deleteQueryKey;
	private String clearQueryKey;
	private DataSource dataSource;
	private TransactionConfig transactionConfig;
	QueryRunner queryRunner;

	@Inject
	MuleContext muleContext;

	public void init() {
		System.out.println("initialised");
		transactionConfig = new MuleTransactionConfig();
		queryRunner = new QueryRunner(dataSource);
	}

	@Override
	public boolean contains(Serializable key) throws ObjectStoreException {
		if (key == null) {
			throw new ObjectStoreException(CoreMessages.objectIsNull("id"));
		}
		Serializable value = retrieve(key);
		return value != null;
	}

	@Override
	public void store(Serializable key, Serializable value) throws ObjectStoreException {
		Object[] arguments = new Object[2];
		arguments[0] = key;
		arguments[1] = value;
		update(insertQueryKey, arguments);
	}

	@Override
	public Serializable retrieve(Serializable key) throws ObjectStoreException {
		System.out.println("Retrirving data.");
		Object[] row = (Object[]) ((Object[]) this.query(selectQueryKey, new ArrayHandler(), new Object[] { key }));
		if (row == null) {
			return null;
		} else {
			return (Serializable) row[1];
		}
	}

	@Override
	public Serializable remove(Serializable key) throws ObjectStoreException {
		if (key == null) {
			throw new ObjectStoreException(CoreMessages.objectIsNull("id"));
		}
		Serializable value = retrieve(key);
		this.update(deleteQueryKey, new Object[] { key });
		return value;
	}

	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() throws ObjectStoreException {
		update(clearQueryKey, new Object[0]);
	}

	private Object query(final String sql, final ResultSetHandler handler, final Object... arguments)
			throws ObjectStoreException {
		try {
			ExecutionCallback<Object> e = new ExecutionCallback<Object>() {
				public Object process() throws Exception {
					return MyObjectStore.this.queryRunner.query(sql, handler, arguments);
				}
			};
			return executeInTransactionTemplate(e);
		} catch (SQLException var5) {
			throw new ObjectStoreException(var5);
		} catch (Exception var6) {
			throw new ObjectStoreException(var6);
		}
	}

	private Object update(final String sql, final Object... arguments) throws ObjectStoreException {
		try {
			ExecutionCallback<Object> e = new ExecutionCallback<Object>() {
				public Object process() throws Exception {
					return Integer.valueOf(MyObjectStore.this.queryRunner.update(sql, arguments));
				}
			};
			return this.executeInTransactionTemplate(e);
		} catch (SQLException var4) {
			throw new ObjectStoreException(var4);
		} catch (Exception var5) {
			throw new ObjectStoreException(var5);
		}
	}

	private Object executeInTransactionTemplate(ExecutionCallback<Object> processingCallback) throws Exception {
		TransactionalExecutionTemplate<Object> executionTemplate = TransactionalExecutionTemplate
				.createTransactionalExecutionTemplate(muleContext, this.transactionConfig);
		return executionTemplate.execute(processingCallback);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
