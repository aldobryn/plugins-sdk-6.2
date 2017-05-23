/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins.migration.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the LegacyProducerLectureseries service. Represents a row in the &quot;producer_lectureseries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerLectureseriesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.migration.model.impl.LegacyProducerLectureseriesImpl}.
 * </p>
 *
 * @author unihh
 * @see LegacyProducerLectureseries
 * @see de.uhh.l2g.plugins.migration.model.impl.LegacyProducerLectureseriesImpl
 * @see de.uhh.l2g.plugins.migration.model.impl.LegacyProducerLectureseriesModelImpl
 * @generated
 */
public interface LegacyProducerLectureseriesModel extends BaseModel<LegacyProducerLectureseries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a legacy producer lectureseries model instance should use the {@link LegacyProducerLectureseries} interface instead.
	 */

	/**
	 * Returns the primary key of this legacy producer lectureseries.
	 *
	 * @return the primary key of this legacy producer lectureseries
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this legacy producer lectureseries.
	 *
	 * @param primaryKey the primary key of this legacy producer lectureseries
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this legacy producer lectureseries.
	 *
	 * @return the ID of this legacy producer lectureseries
	 */
	public long getId();

	/**
	 * Sets the ID of this legacy producer lectureseries.
	 *
	 * @param id the ID of this legacy producer lectureseries
	 */
	public void setId(long id);

	/**
	 * Returns the producer ID of this legacy producer lectureseries.
	 *
	 * @return the producer ID of this legacy producer lectureseries
	 */
	public long getProducerId();

	/**
	 * Sets the producer ID of this legacy producer lectureseries.
	 *
	 * @param producerId the producer ID of this legacy producer lectureseries
	 */
	public void setProducerId(long producerId);

	/**
	 * Returns the lectureseries ID of this legacy producer lectureseries.
	 *
	 * @return the lectureseries ID of this legacy producer lectureseries
	 */
	public long getLectureseriesId();

	/**
	 * Sets the lectureseries ID of this legacy producer lectureseries.
	 *
	 * @param lectureseriesId the lectureseries ID of this legacy producer lectureseries
	 */
	public void setLectureseriesId(long lectureseriesId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries legacyProducerLectureseries);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries> toCacheModel();

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries toEscapedModel();

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseries toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}