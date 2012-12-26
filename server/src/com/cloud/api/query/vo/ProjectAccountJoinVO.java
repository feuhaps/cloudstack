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
package com.cloud.api.query.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.cloud.projects.ProjectAccount.Role;
import org.apache.cloudstack.api.InternalIdentity;

@Entity
@Table(name="project_account_view")
public class ProjectAccountJoinVO extends BaseViewVO implements InternalIdentity {

    @Column(name="id", updatable=false, nullable = false)
    private long id;

    @Column(name="account_id")
    private long accountId;

    @Column(name="account_uuid")
    private String accountUuid;

    @Column(name="account_name")
    private String accountName;

    @Column(name="account_type")
    private short accountType;

    @Column(name="account_role")
    @Enumerated(value=EnumType.STRING)
    private Role accountRole;

    @Column(name="domain_id")
    private long domainId;

    @Column(name="domain_uuid")
    private String domainUuid;

    @Column(name="domain_name")
    private String domainName;

    @Column(name="domain_path")
    private String domainPath;

    @Column(name="project_id")
    private long projectId;

    @Column(name="project_uuid")
    private String projectUuid;

    @Column(name="project_name")
    private String projectName;


    public ProjectAccountJoinVO() {
    }

    @Override
    public long getId() {
        return id;
    }


    @Override
    public void setId(long id) {
        this.id = id;

    }

    public long getDomainId() {
        return domainId;
    }

    public void setDomainId(long domainId) {
        this.domainId = domainId;
    }

    public String getDomainUuid() {
        return domainUuid;
    }

    public void setDomainUuid(String domainUuid) {
        this.domainUuid = domainUuid;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainPath() {
        return domainPath;
    }

    public void setDomainPath(String domainPath) {
        this.domainPath = domainPath;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }



    public String getAccountUuid() {
        return accountUuid;
    }



    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }



    public String getAccountName() {
        return accountName;
    }



    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }



    public short getAccountType() {
        return accountType;
    }



    public void setAccountType(short accountType) {
        this.accountType = accountType;
    }



    public Role getAccountRole() {
        return accountRole;
    }



    public void setAccountRole(Role accountRole) {
        this.accountRole = accountRole;
    }



    public long getProjectId() {
        return projectId;
    }



    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }



    public String getProjectUuid() {
        return projectUuid;
    }



    public void setProjectUuid(String projectUuid) {
        this.projectUuid = projectUuid;
    }



    public String getProjectName() {
        return projectName;
    }



    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }



}
