package com.javakc.pms.dispord.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "pms_disp_ord")
// ## 监听注解
@EntityListeners(AuditingEntityListener.class)
public class DispOrd {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "generator_uuid")
    @GenericGenerator(name = "generator_uuid", strategy = "uuid")
    @ApiModelProperty(value = "主键,采用hibernate的uuid生成32位字符串")
    private String id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "spec_type")
    private String specType;

    @Column(name = "priority")
    private String priority;

    @Column(name = "order_desc")
    private String orderDesc;

    // ## 创建时间
    @CreatedDate
    // ## 格式化时间  规定时间格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    /**
     * updatable = false 表示执行update时新增不做改动
     */
    @Column(name = "gmt_create", nullable = false, updatable = false)
    private Date gmtCreate;

    // ## 修改时间
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    /**
     * nullable = false //##nullable属性表示该字段是否可以为null值，默认为true
     * insertable = false //##insertable属性表示在使用“INSERT”SQL语句插入数据时是否需要插入该字段的值 表示做新增时间操作时 修改不做改动
     * updatable = false //##updatable属性表示在使用“UPDATE”SQL语句插入数据时是否需要更新该字段的值
     */
    @Column(name = "gmt_modified", nullable = false, insertable = false)
    private Date gmtModified;

}
