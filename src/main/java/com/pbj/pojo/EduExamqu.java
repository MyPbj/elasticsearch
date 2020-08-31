package com.pbj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>
 * 
 * </p>
 *
 * @author PBJ
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Document(indexName = "edu",type = "class_qu",shards = 1)
public class EduExamqu implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    /**
     * 题目编号：E20180118121213000000243
     */
    @Field(type = FieldType.Text)
    @TableField("questionId")
    private String questionId;

    /**
     * 学科Id
     */
    @TableField("subId")
    private Long subId;

    /**
     * 题目类型Id
     */
    @TableField("typeId")
    private Long typeId;

    /**
     * 材料主干
     */
    private String material;

    /**
     * 分数
     */
    private Float score;

    /**
     * 创建人
     */
    @TableField("createrId")
    private Long createrId;

    /**
     * 学期
     */
    @TableField("gradeId")
    private Long gradeId;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 层次
     */
    @TableField("levelId")
    private Long levelId;

    @TableField("picId")
    private Long picId;

    @TableField("getLikeNum")
    private Integer getLikeNum;

    /**
     * 章节
     */
    @TableField("unitId")
    private String unitId;

    @TableField("isNew")
    private Integer isNew;

    /**
     * 学校Id
     */
    @TableField("schoolId")
    private Long schoolId;

    /**
     * 听力音频地址
     */
    @TableField("listeningURL")
    private String listeningURL;

    @TableField("actualLevel")
    private Long actualLevel;

    @TableField("classificationId")
    private String classificationId;

    /**
     * 难度
     */
    @TableField("flowId")
    private Long flowId;

    /**
     * 知识点个数
     */
    @TableField("keyPointNum")
    private Long keyPointNum;

    /**
     * 引用次数
     */
    @TableField("quoteNum")
    private Long quoteNum;

    /**
     * 下载次数
     */
    @TableField("downloadNum")
    private Long downloadNum;

    /**
     * 采集zjw题库为1，名师题库为2，采集xkw题库为4，其他题库为0
     */
    @TableField("bankType")
    private Integer bankType;

    /**
     * 知识点：2013,201323，
     */
    @TableField("knowledgeCodes")
    private String knowledgeCodes;

    @TableField("trueTypeId")
    private Long trueTypeId;

    /**
     * 收藏次数
     */
    @TableField("collectionNum")
    private Long collectionNum;

    /**
     * 知识点名称，以逗号隔开
     */
    @TableField("knowledgeNames")
    private String knowledgeNames;

    /**
     * 题目被使用次数
     */
    @TableField("useNum")
    private Long useNum;

    /**
     * 题目错误次数
     */
    @TableField("errorNum")
    private Long errorNum;

    @TableField("trueType")
    private Long trueType;

    /**
     * 源id
     */
    @TableField("sourceId")
    private Integer sourceId;

    /**
     * 源路径
     */
    @TableField("sourceUrl")
    private String sourceUrl;

    /**
     * 类型名称
     */
    @TableField("sourceTypeName")
    private String sourceTypeName;

    @TableField("IsSync")
    private Boolean IsSync;

    /**
     * 题目查重Hash值
     */
    @TableField("HashCode")
    private String HashCode;

    /**
     * 题目类型别名
     */
    @TableField("typeAlise")
    private String typeAlise;

    /**
     * 临时同步，用完删除
     */
    @TableField("needSync")
    private Integer needSync;

    /**
     * 原来题库类型
     */
    @TableField("oldBankType")
    private Integer oldBankType;


}
