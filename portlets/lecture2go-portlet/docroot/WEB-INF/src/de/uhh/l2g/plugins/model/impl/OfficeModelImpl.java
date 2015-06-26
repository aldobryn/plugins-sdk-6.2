/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.uhh.l2g.plugins.model.Office;
import de.uhh.l2g.plugins.model.OfficeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Office service. Represents a row in the &quot;LG_Office&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.uhh.l2g.plugins.model.OfficeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OfficeImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OfficeImpl
 * @see de.uhh.l2g.plugins.model.Office
 * @see de.uhh.l2g.plugins.model.OfficeModel
 * @generated
 */
public class OfficeModelImpl extends BaseModelImpl<Office>
	implements OfficeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a office model instance should use the {@link de.uhh.l2g.plugins.model.Office} interface instead.
	 */
	public static final String TABLE_NAME = "LG_Office";
	public static final Object[][] TABLE_COLUMNS = {
			{ "officeId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "www", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "institutionId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table LG_Office (officeId LONG not null primary key,name VARCHAR(75) null,www VARCHAR(75) null,email VARCHAR(75) null,institutionId LONG)";
	public static final String TABLE_SQL_DROP = "drop table LG_Office";
	public static final String ORDER_BY_JPQL = " ORDER BY office.officeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_Office.officeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Office"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Office"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Office"),
			true);
	public static long INSTITUTIONID_COLUMN_BITMASK = 1L;
	public static long OFFICEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.Office"));

	public OfficeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _officeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Office.class;
	}

	@Override
	public String getModelClassName() {
		return Office.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeId", getOfficeId());
		attributes.put("name", getName());
		attributes.put("www", getWww());
		attributes.put("email", getEmail());
		attributes.put("institutionId", getInstitutionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String www = (String)attributes.get("www");

		if (www != null) {
			setWww(www);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long institutionId = (Long)attributes.get("institutionId");

		if (institutionId != null) {
			setInstitutionId(institutionId);
		}
	}

	@Override
	public long getOfficeId() {
		return _officeId;
	}

	@Override
	public void setOfficeId(long officeId) {
		_officeId = officeId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getWww() {
		if (_www == null) {
			return StringPool.BLANK;
		}
		else {
			return _www;
		}
	}

	@Override
	public void setWww(String www) {
		_www = www;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public long getInstitutionId() {
		return _institutionId;
	}

	@Override
	public void setInstitutionId(long institutionId) {
		_columnBitmask |= INSTITUTIONID_COLUMN_BITMASK;

		if (!_setOriginalInstitutionId) {
			_setOriginalInstitutionId = true;

			_originalInstitutionId = _institutionId;
		}

		_institutionId = institutionId;
	}

	public long getOriginalInstitutionId() {
		return _originalInstitutionId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Office.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Office toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Office)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OfficeImpl officeImpl = new OfficeImpl();

		officeImpl.setOfficeId(getOfficeId());
		officeImpl.setName(getName());
		officeImpl.setWww(getWww());
		officeImpl.setEmail(getEmail());
		officeImpl.setInstitutionId(getInstitutionId());

		officeImpl.resetOriginalValues();

		return officeImpl;
	}

	@Override
	public int compareTo(Office office) {
		long primaryKey = office.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Office)) {
			return false;
		}

		Office office = (Office)obj;

		long primaryKey = office.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		OfficeModelImpl officeModelImpl = this;

		officeModelImpl._originalInstitutionId = officeModelImpl._institutionId;

		officeModelImpl._setOriginalInstitutionId = false;

		officeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Office> toCacheModel() {
		OfficeCacheModel officeCacheModel = new OfficeCacheModel();

		officeCacheModel.officeId = getOfficeId();

		officeCacheModel.name = getName();

		String name = officeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			officeCacheModel.name = null;
		}

		officeCacheModel.www = getWww();

		String www = officeCacheModel.www;

		if ((www != null) && (www.length() == 0)) {
			officeCacheModel.www = null;
		}

		officeCacheModel.email = getEmail();

		String email = officeCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			officeCacheModel.email = null;
		}

		officeCacheModel.institutionId = getInstitutionId();

		return officeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{officeId=");
		sb.append(getOfficeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", www=");
		sb.append(getWww());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", institutionId=");
		sb.append(getInstitutionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Office");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeId</column-name><column-value><![CDATA[");
		sb.append(getOfficeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>www</column-name><column-value><![CDATA[");
		sb.append(getWww());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>institutionId</column-name><column-value><![CDATA[");
		sb.append(getInstitutionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Office.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Office.class };
	private long _officeId;
	private String _name;
	private String _www;
	private String _email;
	private long _institutionId;
	private long _originalInstitutionId;
	private boolean _setOriginalInstitutionId;
	private long _columnBitmask;
	private Office _escapedModel;
}