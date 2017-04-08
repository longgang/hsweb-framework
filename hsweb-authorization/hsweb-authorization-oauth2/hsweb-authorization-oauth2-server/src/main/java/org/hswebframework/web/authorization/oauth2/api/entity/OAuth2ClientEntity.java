/*
 *  Copyright 2016 http://www.hswebframework.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package org.hswebframework.web.authorization.oauth2.api.entity;

import org.hswebframework.web.commons.entity.GenericEntity;
import org.hswebframework.web.commons.entity.RecordCreationEntity;

import java.util.List;

/**
 * @author zhouhao
 */
public interface OAuth2ClientEntity extends GenericEntity<String>, RecordCreationEntity {

    // client_id
    @Override
    String getId();

    String getName();

    void setName(String name);

    // client_secret
    String getSecret();

    void setSecret(String secret);

    //redirect_uri
    String getRedirectUri();

    void setRedirectUri(String redirectUri);

    /**
     * @return 客户端所有者
     * @see org.hswebframework.web.authorization.User#getId()
     */
    String getOwnerId();

    void setOwnerId(String ownerId);

    String getDescribe();

    void setDescribe(String describe);

    String getType();

    void setType(String type);

    List<String> getSupportGrantType();

    void setSupportGrantType(List<String> supportGrantType);

    default boolean grantTypeIsSupport(String grantType) {
        if (getSupportGrantType() == null) return false;
        return getSupportGrantType().contains(grantType) || getSupportGrantType().contains("*");
    }
}