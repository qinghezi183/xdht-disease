package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_control_effect_project")
public class RecordControlEffectProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 调查项目
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 状态（0正常 1删除）
     */
    private String status;

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
     * 获取调查项目
     *
     * @return project_name - 调查项目
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置调查项目
     *
     * @param projectName 调查项目
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取状态（0正常 1删除）
     *
     * @return status - 状态（0正常 1删除）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1删除）
     *
     * @param status 状态（0正常 1删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }
}