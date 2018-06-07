package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_health_management_data")
public class RecordHealthManagementData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 调查表id
     */
    @Column(name = "health_management_id")
    private Long healthManagementId;

    /**
     * 调查项目id
     */
    @Column(name = "health_management_project_id")
    private Long healthManagementProjectId;

    /**
     * 建立情况
     */
    @Column(name = "set_up_info")
    private String setUpInfo;

    /**
     * 执行情况
     */
    @Column(name = "implement_info")
    private String implementInfo;

    /**
     * 备注
     */
    private String remarks;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取调查表id
     *
     * @return health_management_id - 调查表id
     */
    public Long getHealthManagementId() {
        return healthManagementId;
    }

    /**
     * 设置调查表id
     *
     * @param healthManagementId 调查表id
     */
    public void setHealthManagementId(Long healthManagementId) {
        this.healthManagementId = healthManagementId;
    }

    /**
     * 获取调查项目id
     *
     * @return health_management_project_id - 调查项目id
     */
    public Long getHealthManagementProjectId() {
        return healthManagementProjectId;
    }

    /**
     * 设置调查项目id
     *
     * @param healthManagementProjectId 调查项目id
     */
    public void setHealthManagementProjectId(Long healthManagementProjectId) {
        this.healthManagementProjectId = healthManagementProjectId;
    }

    /**
     * 获取建立情况
     *
     * @return set_up_info - 建立情况
     */
    public String getSetUpInfo() {
        return setUpInfo;
    }

    /**
     * 设置建立情况
     *
     * @param setUpInfo 建立情况
     */
    public void setSetUpInfo(String setUpInfo) {
        this.setUpInfo = setUpInfo;
    }

    /**
     * 获取执行情况
     *
     * @return implement_info - 执行情况
     */
    public String getImplementInfo() {
        return implementInfo;
    }

    /**
     * 设置执行情况
     *
     * @param implementInfo 执行情况
     */
    public void setImplementInfo(String implementInfo) {
        this.implementInfo = implementInfo;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}