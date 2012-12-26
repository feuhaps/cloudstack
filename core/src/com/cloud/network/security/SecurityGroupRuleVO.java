// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.network.security;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cloud.async.AsyncInstanceCreateStatus;
import com.google.gson.annotations.Expose;
import org.apache.cloudstack.api.InternalIdentity;

@Entity
@Table(name = ("security_group_rule"))
public class SecurityGroupRuleVO implements SecurityRule, InternalIdentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "security_group_id")
    private long securityGroupId;

    @Column(name = "start_port")
    private int startPort;

    @Column(name = "end_port")
    private int endPort;

    @Column(name = "type")
    private String type;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "allowed_network_id", nullable = true)
    private Long allowedNetworkId = null;

    @Column(name = "allowed_ip_cidr", nullable = true)
    private String allowedSourceIpCidr = null;

    @Expose
    @Column(name = "create_status", updatable = true, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AsyncInstanceCreateStatus createStatus;

    @Column(name = "uuid")
    private String uuid;
    
    public SecurityGroupRuleVO() {
    	this.uuid = UUID.randomUUID().toString();
    }

    public SecurityGroupRuleVO(SecurityRuleType type,long securityGroupId, int fromPort, int toPort, String protocol, long allowedNetworkId ) {
        this.securityGroupId = securityGroupId;
        this.startPort = fromPort;
        this.endPort = toPort;
        this.protocol = protocol;
        this.allowedNetworkId = allowedNetworkId;
    	this.uuid = UUID.randomUUID().toString();
        if (type == SecurityRuleType.IngressRule) {
            this.type = SecurityRuleType.IngressRule.getType();
        } else {
            this.type = SecurityRuleType.EgressRule.getType();
        }
    }

    public SecurityGroupRuleVO(SecurityRuleType type,long securityGroupId, int fromPort, int toPort, String protocol, String allowedIpCidr) {
        this.securityGroupId = securityGroupId;
        this.startPort = fromPort;
        this.endPort = toPort;
        this.protocol = protocol;
        this.allowedSourceIpCidr = allowedIpCidr;
    	this.uuid = UUID.randomUUID().toString();
        if (type == SecurityRuleType.IngressRule) {
            this.type = SecurityRuleType.IngressRule.getType();
        } else {
            this.type = SecurityRuleType.EgressRule.getType();
        }
    }

    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public long getSecurityGroupId() {
        return securityGroupId;
    }
    
    public SecurityRuleType getRuleType() {
        if ("ingress".equalsIgnoreCase(this.type))
            return SecurityRuleType.IngressRule;
        else
            return SecurityRuleType.EgressRule;
    }
    
    @Override
    public int getStartPort() {
        return startPort;
    }

    @Override
    public int getEndPort() {
        return endPort;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public AsyncInstanceCreateStatus getCreateStatus() {
        return createStatus;
    }

    public void setCreateStatus(AsyncInstanceCreateStatus createStatus) {
        this.createStatus = createStatus;
    }

    @Override
    public Long getAllowedNetworkId() {
        return allowedNetworkId;
    }

    @Override
    public String getAllowedSourceIpCidr() {
        return allowedSourceIpCidr;
    }
    
    @Override
    public String getUuid() {
    	return this.uuid;
    }
    
    public void setUuid(String uuid) {
    	this.uuid = uuid;
    }
}
