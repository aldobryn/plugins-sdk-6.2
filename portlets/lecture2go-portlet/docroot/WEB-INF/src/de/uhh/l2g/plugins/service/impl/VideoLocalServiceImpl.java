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

package de.uhh.l2g.plugins.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.base.VideoLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.VideoFinderUtil;

/**
 * The implementation of the video local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.VideoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.VideoLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.VideoLocalServiceUtil
 */
public class VideoLocalServiceImpl extends VideoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.VideoLocalServiceUtil} to access the video local service.
	 */
	public int unlinkLectureseriesFromVideos(Long lectureseriesId){
		return VideoFinderUtil.unlinkLectureseriesFromVideos(lectureseriesId);
	}

	public List<Video> getByInstitution(Long facilityId) throws SystemException{
		List<Video> vl = videoPersistence.findByInstitution(facilityId);
		return vl;
	}
	
	public List<Video> getByProducer(Long producerId) throws SystemException{
		List<Video> vl = videoPersistence.findByProducer(producerId);
		return vl;
	}
	
	public List<Video> getByLectureseries(Long lectureseriesId) throws SystemException{
		List<Video> vl =  videoPersistence.findByLectureseries(lectureseriesId);
		return vl;
	}

	public List<Video> getByProducerAndLectureseries(Long producerId, Long lectureseriesId) throws SystemException{
		List<Video> vl =  videoPersistence.findByProducerAndLectureseries(producerId, lectureseriesId);
		return vl;
	}
}