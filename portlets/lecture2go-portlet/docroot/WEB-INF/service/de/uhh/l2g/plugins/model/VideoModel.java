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

package de.uhh.l2g.plugins.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Video service. Represents a row in the &quot;LG_Video&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.model.impl.VideoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.model.impl.VideoImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video
 * @see de.uhh.l2g.plugins.model.impl.VideoImpl
 * @see de.uhh.l2g.plugins.model.impl.VideoModelImpl
 * @generated
 */
public interface VideoModel extends BaseModel<Video> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a video model instance should use the {@link Video} interface instead.
	 */

	/**
	 * Returns the primary key of this video.
	 *
	 * @return the primary key of this video
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this video.
	 *
	 * @param primaryKey the primary key of this video
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the video ID of this video.
	 *
	 * @return the video ID of this video
	 */
	public long getVideoId();

	/**
	 * Sets the video ID of this video.
	 *
	 * @param videoId the video ID of this video
	 */
	public void setVideoId(long videoId);

	/**
	 * Returns the title of this video.
	 *
	 * @return the title of this video
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this video.
	 *
	 * @param title the title of this video
	 */
	public void setTitle(String title);

	/**
	 * Returns the tags of this video.
	 *
	 * @return the tags of this video
	 */
	@AutoEscape
	public String getTags();

	/**
	 * Sets the tags of this video.
	 *
	 * @param tags the tags of this video
	 */
	public void setTags(String tags);

	/**
	 * Returns the lectureseries ID of this video.
	 *
	 * @return the lectureseries ID of this video
	 */
	public long getLectureseriesId();

	/**
	 * Sets the lectureseries ID of this video.
	 *
	 * @param lectureseriesId the lectureseries ID of this video
	 */
	public void setLectureseriesId(long lectureseriesId);

	/**
	 * Returns the producer ID of this video.
	 *
	 * @return the producer ID of this video
	 */
	public long getProducerId();

	/**
	 * Sets the producer ID of this video.
	 *
	 * @param producerId the producer ID of this video
	 */
	public void setProducerId(long producerId);

	/**
	 * Returns the container format of this video.
	 *
	 * @return the container format of this video
	 */
	@AutoEscape
	public String getContainerFormat();

	/**
	 * Sets the container format of this video.
	 *
	 * @param containerFormat the container format of this video
	 */
	public void setContainerFormat(String containerFormat);

	/**
	 * Returns the filename of this video.
	 *
	 * @return the filename of this video
	 */
	@AutoEscape
	public String getFilename();

	/**
	 * Sets the filename of this video.
	 *
	 * @param filename the filename of this video
	 */
	public void setFilename(String filename);

	/**
	 * Returns the resolution of this video.
	 *
	 * @return the resolution of this video
	 */
	@AutoEscape
	public String getResolution();

	/**
	 * Sets the resolution of this video.
	 *
	 * @param resolution the resolution of this video
	 */
	public void setResolution(String resolution);

	/**
	 * Returns the duration of this video.
	 *
	 * @return the duration of this video
	 */
	@AutoEscape
	public String getDuration();

	/**
	 * Sets the duration of this video.
	 *
	 * @param duration the duration of this video
	 */
	public void setDuration(String duration);

	/**
	 * Returns the host ID of this video.
	 *
	 * @return the host ID of this video
	 */
	public long getHostId();

	/**
	 * Sets the host ID of this video.
	 *
	 * @param hostId the host ID of this video
	 */
	public void setHostId(long hostId);

	/**
	 * Returns the file size of this video.
	 *
	 * @return the file size of this video
	 */
	@AutoEscape
	public String getFileSize();

	/**
	 * Sets the file size of this video.
	 *
	 * @param fileSize the file size of this video
	 */
	public void setFileSize(String fileSize);

	/**
	 * Returns the generation date of this video.
	 *
	 * @return the generation date of this video
	 */
	@AutoEscape
	public String getGenerationDate();

	/**
	 * Sets the generation date of this video.
	 *
	 * @param generationDate the generation date of this video
	 */
	public void setGenerationDate(String generationDate);

	/**
	 * Returns the open access of this video.
	 *
	 * @return the open access of this video
	 */
	public int getOpenAccess();

	/**
	 * Sets the open access of this video.
	 *
	 * @param openAccess the open access of this video
	 */
	public void setOpenAccess(int openAccess);

	/**
	 * Returns the download link of this video.
	 *
	 * @return the download link of this video
	 */
	public int getDownloadLink();

	/**
	 * Sets the download link of this video.
	 *
	 * @param downloadLink the download link of this video
	 */
	public void setDownloadLink(int downloadLink);

	/**
	 * Returns the metadata ID of this video.
	 *
	 * @return the metadata ID of this video
	 */
	public long getMetadataId();

	/**
	 * Sets the metadata ID of this video.
	 *
	 * @param metadataId the metadata ID of this video
	 */
	public void setMetadataId(long metadataId);

	/**
	 * Returns the surl of this video.
	 *
	 * @return the surl of this video
	 */
	@AutoEscape
	public String getSurl();

	/**
	 * Sets the surl of this video.
	 *
	 * @param surl the surl of this video
	 */
	public void setSurl(String surl);

	/**
	 * Returns the hits of this video.
	 *
	 * @return the hits of this video
	 */
	public int getHits();

	/**
	 * Sets the hits of this video.
	 *
	 * @param hits the hits of this video
	 */
	public void setHits(int hits);

	/**
	 * Returns the upload date of this video.
	 *
	 * @return the upload date of this video
	 */
	public Date getUploadDate();

	/**
	 * Sets the upload date of this video.
	 *
	 * @param uploadDate the upload date of this video
	 */
	public void setUploadDate(Date uploadDate);

	/**
	 * Returns the permitted to segment of this video.
	 *
	 * @return the permitted to segment of this video
	 */
	public int getPermittedToSegment();

	/**
	 * Sets the permitted to segment of this video.
	 *
	 * @param permittedToSegment the permitted to segment of this video
	 */
	public void setPermittedToSegment(int permittedToSegment);

	/**
	 * Returns the root institution ID of this video.
	 *
	 * @return the root institution ID of this video
	 */
	public long getRootInstitutionId();

	/**
	 * Sets the root institution ID of this video.
	 *
	 * @param rootInstitutionId the root institution ID of this video
	 */
	public void setRootInstitutionId(long rootInstitutionId);

	/**
	 * Returns the citation2go of this video.
	 *
	 * @return the citation2go of this video
	 */
	public int getCitation2go();

	/**
	 * Sets the citation2go of this video.
	 *
	 * @param citation2go the citation2go of this video
	 */
	public void setCitation2go(int citation2go);

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
	public int compareTo(Video video);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Video> toCacheModel();

	@Override
	public Video toEscapedModel();

	@Override
	public Video toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}