package com.xdht.disease.shunfeng.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "record_sf_response_route")
public class RecordSfResponseRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String head;

    /**
     * 顺丰运单号
     */
    @Column(name = "mail_no")
    private String mailNo;

    /**
     * 客户订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 路由节点发生的时间
     */
    @Column(name = "accept_time")
    private Date acceptTime;

    /**
     * 路由节点发生的地点
     */
    @Column(name = "accept_address")
    private String acceptAddress;

    /**
     * 路由节点具体描述
     */
    private String remark;

    /**
     * 路由节点操作码
     */
    private String opcode;

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
     * @return head
     */
    public String getHead() {
        return head;
    }

    /**
     * @param head
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 获取顺丰运单号
     *
     * @return mail_no - 顺丰运单号
     */
    public String getMailNo() {
        return mailNo;
    }

    /**
     * 设置顺丰运单号
     *
     * @param mailNo 顺丰运单号
     */
    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }

    /**
     * 获取客户订单号
     *
     * @return order_id - 客户订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置客户订单号
     *
     * @param orderId 客户订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取路由节点发生的时间
     *
     * @return accept_time - 路由节点发生的时间
     */
    public Date getAcceptTime() {
        return acceptTime;
    }

    /**
     * 设置路由节点发生的时间
     *
     * @param acceptTime 路由节点发生的时间
     */
    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    /**
     * 获取路由节点发生的地点
     *
     * @return accept_address - 路由节点发生的地点
     */
    public String getAcceptAddress() {
        return acceptAddress;
    }

    /**
     * 设置路由节点发生的地点
     *
     * @param acceptAddress 路由节点发生的地点
     */
    public void setAcceptAddress(String acceptAddress) {
        this.acceptAddress = acceptAddress;
    }

    /**
     * 获取路由节点具体描述
     *
     * @return remark - 路由节点具体描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置路由节点具体描述
     *
     * @param remark 路由节点具体描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取路由节点操作码
     *
     * @return opcode - 路由节点操作码
     */
    public String getOpcode() {
        return opcode;
    }

    /**
     * 设置路由节点操作码
     *
     * @param opcode 路由节点操作码
     */
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }
}