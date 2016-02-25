/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.rivetlogic.suggestionbox.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rivetlogic.suggestionbox.model.Suggestion;
import com.rivetlogic.suggestionbox.model.SuggestionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Suggestion service. Represents a row in the &quot;rivetlogic_suggestion_box_Suggestion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rivetlogic.suggestionbox.model.SuggestionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SuggestionImpl}.
 * </p>
 *
 * @author Manrique Varela
 * @see SuggestionImpl
 * @see com.rivetlogic.suggestionbox.model.Suggestion
 * @see com.rivetlogic.suggestionbox.model.SuggestionModel
 * @generated
 */
public class SuggestionModelImpl extends BaseModelImpl<Suggestion>
	implements SuggestionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a suggestion model instance should use the {@link com.rivetlogic.suggestionbox.model.Suggestion} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_suggestion_box_Suggestion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "suggestionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "category", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "receivedDate", Types.TIMESTAMP },
			{ "receivedComment", Types.VARCHAR },
			{ "receivedUserId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table rivetlogic_suggestion_box_Suggestion (suggestionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,category VARCHAR(75) null,title VARCHAR(75) null,description TEXT null,status VARCHAR(75) null,receivedDate DATE null,receivedComment TEXT null,receivedUserId LONG)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_suggestion_box_Suggestion";
	public static final String ORDER_BY_JPQL = " ORDER BY suggestion.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_suggestion_box_Suggestion.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.suggestionbox.model.Suggestion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.suggestionbox.model.Suggestion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rivetlogic.suggestionbox.model.Suggestion"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static long CREATEDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.suggestionbox.model.Suggestion"));

	public SuggestionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _suggestionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSuggestionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _suggestionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Suggestion.class;
	}

	@Override
	public String getModelClassName() {
		return Suggestion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("suggestionId", getSuggestionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("category", getCategory());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("receivedDate", getReceivedDate());
		attributes.put("receivedComment", getReceivedComment());
		attributes.put("receivedUserId", getReceivedUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long suggestionId = (Long)attributes.get("suggestionId");

		if (suggestionId != null) {
			setSuggestionId(suggestionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date receivedDate = (Date)attributes.get("receivedDate");

		if (receivedDate != null) {
			setReceivedDate(receivedDate);
		}

		String receivedComment = (String)attributes.get("receivedComment");

		if (receivedComment != null) {
			setReceivedComment(receivedComment);
		}

		Long receivedUserId = (Long)attributes.get("receivedUserId");

		if (receivedUserId != null) {
			setReceivedUserId(receivedUserId);
		}
	}

	@Override
	public long getSuggestionId() {
		return _suggestionId;
	}

	@Override
	public void setSuggestionId(long suggestionId) {
		_suggestionId = suggestionId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getCategory() {
		if (_category == null) {
			return StringPool.BLANK;
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		_category = category;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	@Override
	public Date getReceivedDate() {
		return _receivedDate;
	}

	@Override
	public void setReceivedDate(Date receivedDate) {
		_receivedDate = receivedDate;
	}

	@Override
	public String getReceivedComment() {
		if (_receivedComment == null) {
			return StringPool.BLANK;
		}
		else {
			return _receivedComment;
		}
	}

	@Override
	public void setReceivedComment(String receivedComment) {
		_receivedComment = receivedComment;
	}

	@Override
	public long getReceivedUserId() {
		return _receivedUserId;
	}

	@Override
	public void setReceivedUserId(long receivedUserId) {
		_receivedUserId = receivedUserId;
	}

	@Override
	public String getReceivedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getReceivedUserId(), "uuid",
			_receivedUserUuid);
	}

	@Override
	public void setReceivedUserUuid(String receivedUserUuid) {
		_receivedUserUuid = receivedUserUuid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Suggestion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Suggestion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Suggestion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SuggestionImpl suggestionImpl = new SuggestionImpl();

		suggestionImpl.setSuggestionId(getSuggestionId());
		suggestionImpl.setGroupId(getGroupId());
		suggestionImpl.setCompanyId(getCompanyId());
		suggestionImpl.setUserId(getUserId());
		suggestionImpl.setCreateDate(getCreateDate());
		suggestionImpl.setModifiedDate(getModifiedDate());
		suggestionImpl.setCategory(getCategory());
		suggestionImpl.setTitle(getTitle());
		suggestionImpl.setDescription(getDescription());
		suggestionImpl.setStatus(getStatus());
		suggestionImpl.setReceivedDate(getReceivedDate());
		suggestionImpl.setReceivedComment(getReceivedComment());
		suggestionImpl.setReceivedUserId(getReceivedUserId());

		suggestionImpl.resetOriginalValues();

		return suggestionImpl;
	}

	@Override
	public int compareTo(Suggestion suggestion) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), suggestion.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Suggestion)) {
			return false;
		}

		Suggestion suggestion = (Suggestion)obj;

		long primaryKey = suggestion.getPrimaryKey();

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
		SuggestionModelImpl suggestionModelImpl = this;

		suggestionModelImpl._originalGroupId = suggestionModelImpl._groupId;

		suggestionModelImpl._setOriginalGroupId = false;

		suggestionModelImpl._originalCompanyId = suggestionModelImpl._companyId;

		suggestionModelImpl._setOriginalCompanyId = false;

		suggestionModelImpl._originalUserId = suggestionModelImpl._userId;

		suggestionModelImpl._setOriginalUserId = false;

		suggestionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Suggestion> toCacheModel() {
		SuggestionCacheModel suggestionCacheModel = new SuggestionCacheModel();

		suggestionCacheModel.suggestionId = getSuggestionId();

		suggestionCacheModel.groupId = getGroupId();

		suggestionCacheModel.companyId = getCompanyId();

		suggestionCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			suggestionCacheModel.createDate = createDate.getTime();
		}
		else {
			suggestionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			suggestionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			suggestionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		suggestionCacheModel.category = getCategory();

		String category = suggestionCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			suggestionCacheModel.category = null;
		}

		suggestionCacheModel.title = getTitle();

		String title = suggestionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			suggestionCacheModel.title = null;
		}

		suggestionCacheModel.description = getDescription();

		String description = suggestionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			suggestionCacheModel.description = null;
		}

		suggestionCacheModel.status = getStatus();

		String status = suggestionCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			suggestionCacheModel.status = null;
		}

		Date receivedDate = getReceivedDate();

		if (receivedDate != null) {
			suggestionCacheModel.receivedDate = receivedDate.getTime();
		}
		else {
			suggestionCacheModel.receivedDate = Long.MIN_VALUE;
		}

		suggestionCacheModel.receivedComment = getReceivedComment();

		String receivedComment = suggestionCacheModel.receivedComment;

		if ((receivedComment != null) && (receivedComment.length() == 0)) {
			suggestionCacheModel.receivedComment = null;
		}

		suggestionCacheModel.receivedUserId = getReceivedUserId();

		return suggestionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{suggestionId=");
		sb.append(getSuggestionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", receivedDate=");
		sb.append(getReceivedDate());
		sb.append(", receivedComment=");
		sb.append(getReceivedComment());
		sb.append(", receivedUserId=");
		sb.append(getReceivedUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.suggestionbox.model.Suggestion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>suggestionId</column-name><column-value><![CDATA[");
		sb.append(getSuggestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivedDate</column-name><column-value><![CDATA[");
		sb.append(getReceivedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivedComment</column-name><column-value><![CDATA[");
		sb.append(getReceivedComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivedUserId</column-name><column-value><![CDATA[");
		sb.append(getReceivedUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Suggestion.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Suggestion.class
		};
	private long _suggestionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _category;
	private String _title;
	private String _description;
	private String _status;
	private Date _receivedDate;
	private String _receivedComment;
	private long _receivedUserId;
	private String _receivedUserUuid;
	private long _columnBitmask;
	private Suggestion _escapedModel;
}