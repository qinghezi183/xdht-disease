package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_hazard_factors_data")
public class RecordHazardFactorsData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_id")
    private Long officeId;

    /**
     * 职业病危害因素
     */
    @Column(name = "hazard_factors")
    private String hazardFactors;

    /**
     * 暴露方式
     */
    @Column(name = "exposure_mode")
    private String exposureMode;

    /**
     * 暴露时间
     */
    @Column(name = "exposure_time")
    private String exposureTime;

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
     * @return office_id
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * @param officeId
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取职业病危害因素
     *
     * @return hazard_factors - 职业病危害因素
     */
    public String getHazardFactors() {
        return hazardFactors;
    }

    /**
     * 设置职业病危害因素
     *
     * @param hazardFactors 职业病危害因素
     */
    public void setHazardFactors(String hazardFactors) {
        this.hazardFactors = hazardFactors;
    }

    /**
     * 获取暴露方式
     *
     * @return exposure_mode - 暴露方式
     */
    public String getExposureMode() {
        return exposureMode;
    }

    /**
     * 设置暴露方式
     *
     * @param exposureMode 暴露方式
     */
    public void setExposureMode(String exposureMode) {
        this.exposureMode = exposureMode;
    }

    /**
     * 获取暴露时间
     *
     * @return exposure_time - 暴露时间
     */
    public String getExposureTime() {
        return exposureTime;
    }

    /**
     * 设置暴露时间
     *
     * @param exposureTime 暴露时间
     */
    public void setExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
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