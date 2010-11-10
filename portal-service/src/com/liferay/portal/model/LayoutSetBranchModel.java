/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LayoutSetBranch service. Represents a row in the &quot;LayoutSetBranch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.LayoutSetBranchModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.LayoutSetBranchImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetBranch
 * @see com.liferay.portal.model.impl.LayoutSetBranchImpl
 * @see com.liferay.portal.model.impl.LayoutSetBranchModelImpl
 * @generated
 */
public interface LayoutSetBranchModel extends BaseModel<LayoutSetBranch> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a layout set branch model instance should use the {@link LayoutSetBranch} interface instead.
	 */

	/**
	 * Gets the primary key of this layout set branch.
	 *
	 * @return the primary key of this layout set branch
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this layout set branch
	 *
	 * @param pk the primary key of this layout set branch
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the layout set branch id of this layout set branch.
	 *
	 * @return the layout set branch id of this layout set branch
	 */
	public long getLayoutSetBranchId();

	/**
	 * Sets the layout set branch id of this layout set branch.
	 *
	 * @param layoutSetBranchId the layout set branch id of this layout set branch
	 */
	public void setLayoutSetBranchId(long layoutSetBranchId);

	/**
	 * Gets the group id of this layout set branch.
	 *
	 * @return the group id of this layout set branch
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this layout set branch.
	 *
	 * @param groupId the group id of this layout set branch
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this layout set branch.
	 *
	 * @return the company id of this layout set branch
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this layout set branch.
	 *
	 * @param companyId the company id of this layout set branch
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this layout set branch.
	 *
	 * @return the user id of this layout set branch
	 */
	public long getUserId();

	/**
	 * Sets the user id of this layout set branch.
	 *
	 * @param userId the user id of this layout set branch
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this layout set branch.
	 *
	 * @return the user uuid of this layout set branch
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this layout set branch.
	 *
	 * @param userUuid the user uuid of this layout set branch
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this layout set branch.
	 *
	 * @return the user name of this layout set branch
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this layout set branch.
	 *
	 * @param userName the user name of this layout set branch
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this layout set branch.
	 *
	 * @return the create date of this layout set branch
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this layout set branch.
	 *
	 * @param createDate the create date of this layout set branch
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this layout set branch.
	 *
	 * @return the modified date of this layout set branch
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this layout set branch.
	 *
	 * @param modifiedDate the modified date of this layout set branch
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the private layout of this layout set branch.
	 *
	 * @return the private layout of this layout set branch
	 */
	public boolean getPrivateLayout();

	/**
	 * Determines if this layout set branch is private layout.
	 *
	 * @return <code>true</code> if this layout set branch is private layout; <code>false</code> otherwise
	 */
	public boolean isPrivateLayout();

	/**
	 * Sets whether this layout set branch is private layout.
	 *
	 * @param privateLayout the private layout of this layout set branch
	 */
	public void setPrivateLayout(boolean privateLayout);

	/**
	 * Gets the name of this layout set branch.
	 *
	 * @return the name of this layout set branch
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this layout set branch.
	 *
	 * @param name the name of this layout set branch
	 */
	public void setName(String name);

	/**
	 * Gets the description of this layout set branch.
	 *
	 * @return the description of this layout set branch
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this layout set branch.
	 *
	 * @param description the description of this layout set branch
	 */
	public void setDescription(String description);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(LayoutSetBranch layoutSetBranch);

	public int hashCode();

	public LayoutSetBranch toEscapedModel();

	public String toString();

	public String toXmlString();
}