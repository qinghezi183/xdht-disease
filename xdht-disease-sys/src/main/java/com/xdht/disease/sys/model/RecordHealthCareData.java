package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_health_care_data")
public class RecordHealthCareData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 调查表id
     */
    @Column(name = "health_care_id")
    private Long healthCareId;

    /**
     * 调查项目id
     */
    @Column(name = "health_care_project_id")
    private Long healthCareProjectId;

    /**
     * 调查结果
     */
    @Column(name = "survey_results")
    private String surveyResults;

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
     * @return health_care_id - 调查表id
     */
    public Long getHealthCareId() {
        return healthCareId;
    }

    /**
     * 设置调查表id
     *
     * @param healthCareId 调查表id
     */
    public void setHealthCareId(Long healthCareId) {
        this.healthCareId = healthCareId;
    }

    /**
     * 获取调查项目id
     *
     * @return health_care_project_id - 调查项目id
     */
    public Long getHealthCareProjectId() {
        return healthCareProjectId;
    }

    /**
     * 设置调查项目id
     *
     * @param healthCareProjectId 调查项目id
     */
    public void setHealthCareProjectId(Long healthCareProjectId) {
        this.healthCareProjectId = healthCareProjectId;
    }

    /**
     * 获取调查结果
     *
     * @return survey_results - 调查结果
     */
    public String getSurveyResults() {
        return surveyResults;
    }

    /**
     * 设置调查结果
     *
     * @param surveyResults 调查结果
     */
    public void setSurveyResults(String surveyResults) {
        this.surveyResults = surveyResults;
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