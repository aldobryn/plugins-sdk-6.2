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

package de.uhh.l2g.plugins.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;

/**
 * The extended model base implementation for the Video_Lectureseries service. Represents a row in the &quot;LG_Video_Lectureseries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Video_LectureseriesImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_LectureseriesImpl
 * @see de.uhh.l2g.plugins.model.Video_Lectureseries
 * @generated
 */
public abstract class Video_LectureseriesBaseImpl
	extends Video_LectureseriesModelImpl implements Video_Lectureseries {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a video_ lectureseries model instance should use the {@link Video_Lectureseries} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Video_LectureseriesLocalServiceUtil.addVideo_Lectureseries(this);
		}
		else {
			Video_LectureseriesLocalServiceUtil.updateVideo_Lectureseries(this);
		}
	}
}