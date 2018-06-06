package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_control_effect_data")
public class RecordControlEffectData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 调查表id
     */
    @Column(name = "pre_evaluation_id")
    private Long preEvaluationId;

    /**
     * 调查项目id
     */
    @Column(name = "pre_evaluation_project_id")
    private Long preEvaluationProjectId;

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
     * @return pre_evaluation_id - 调查表id
     */
    public Long getPreEvaluationId() {
        return preEvaluationId;
    }

    /**
     * 设置调查表id
     *
     * @param preEvaluationId 调查表id
     */
    public void setPreEvaluationId(Long preEvaluationId) {
        this.preEvaluationId = preEvaluationId;
    }

    /**
     * 获取调查项目id
     *
     * @return pre_evaluation_project_id - 调查项目id
     */
    public Long getPreEvaluationProjectId() {
        return preEvaluationProjectId;
    }

    /**
     * 设置调查项目id
     *
     * @param preEvaluationProjectId 调查项目id
     */
    public void setPreEvaluationProjectId(Long preEvaluationProjectId) {
        this.preEvaluationProjectId = preEvaluationProjectId;
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