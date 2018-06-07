package com.xdht.disease.sys.model;

import javax.persistence.*;

@Table(name = "record_funds_data")
public class RecordFundsData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 调查表id
     */
    @Column(name = "funds_id")
    private Long fundsId;

    /**
     * 调查项目id
     */
    @Column(name = "funds_project_id")
    private Long fundsProjectId;

    /**
     * 预计或实际支出（万元）
     */
    @Column(name = "expact_or_pay")
    private Long expactOrPay;

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
     * @return funds_id - 调查表id
     */
    public Long getFundsId() {
        return fundsId;
    }

    /**
     * 设置调查表id
     *
     * @param fundsId 调查表id
     */
    public void setFundsId(Long fundsId) {
        this.fundsId = fundsId;
    }

    /**
     * 获取调查项目id
     *
     * @return funds_project_id - 调查项目id
     */
    public Long getFundsProjectId() {
        return fundsProjectId;
    }

    /**
     * 设置调查项目id
     *
     * @param fundsProjectId 调查项目id
     */
    public void setFundsProjectId(Long fundsProjectId) {
        this.fundsProjectId = fundsProjectId;
    }

    /**
     * 获取预计或实际支出（万元）
     *
     * @return expact_or_pay - 预计或实际支出（万元）
     */
    public Long getExpactOrPay() {
        return expactOrPay;
    }

    /**
     * 设置预计或实际支出（万元）
     *
     * @param expactOrPay 预计或实际支出（万元）
     */
    public void setExpactOrPay(Long expactOrPay) {
        this.expactOrPay = expactOrPay;
    }
}