package com.pbj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
    @Field(type = FieldType.Long)
    private Long subId;

    /**
     * 题目类型Id
     */
    @TableField("typeId")
    @Field(type = FieldType.Long)
    private Long typeId;

    /**
     * 材料主干
     */
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",analyzer = "ik_max_word")
    //TODO
    private String material;

    /**
     * 分数
     */
    @Field(type = FieldType.Float)
    private Float score;

    /**
     * 创建人
     */
    @TableField("createrId")
    @Field(type = FieldType.Long)
    private Long createrId;

    /**
     * 学期
     */
    @TableField("gradeId")
    @Field(type = FieldType.Long)
    private Long gradeId;

    /**
     * 创建时间
     */
    @TableField("createTime")
    @Field(type = FieldType.Date)
    private Date createTime;

    /**
     * 层次
     */
    @TableField("levelId")
    @Field(type = FieldType.Long)
    private Long levelId;

    @TableField("picId")
    @Field(type = FieldType.Long)
    private Long picId;

    @TableField("getLikeNum")
    @Field(type = FieldType.Integer)
    private Integer getLikeNum;

    /**
     * 章节
     */
    @TableField("unitId")
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",analyzer = "ik_max_word")
    //TODO
    private String unitId;

    @TableField("isNew")
    private Integer isNew;

    /**
     * 学校Id
     */
    @TableField("schoolId")
    @Field(type = FieldType.Long)
    private Long schoolId;

    /**
     * 听力音频地址
     */
    @TableField("listeningURL")
    @Field(type = FieldType.Text)
    private String listeningURL;

    @TableField("actualLevel")
    @Field(type = FieldType.Long)
    private Long actualLevel;

    @TableField("classificationId")
    @Field(type = FieldType.Text)
    private String classificationId;

    /**
     * 难度
     */
    @TableField("flowId")
    @Field(type = FieldType.Long)
    private Long flowId;

    /**
     * 知识点个数
     */
    @TableField("keyPointNum")
    @Field(type = FieldType.Long)
    private Long keyPointNum;

    /**
     * 引用次数
     */
    @TableField("quoteNum")
    @Field(type = FieldType.Long)
    private Long quoteNum;

    /**
     * 下载次数
     */
    @TableField("downloadNum")
    @Field(type = FieldType.Long)
    private Long downloadNum;

    /**
     * 采集zjw题库为1，名师题库为2，采集xkw题库为4，其他题库为0
     */
    @TableField("bankType")
    @Field(type = FieldType.Integer)
    private Integer bankType;

    /**
     * 知识点：2013,201323，
     */
    @TableField("knowledgeCodes")
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",analyzer = "ik_max_word")
    //TODO
    private String knowledgeCodes;

    @TableField("trueTypeId")
    @Field(type = FieldType.Long)
    private Long trueTypeId;

    /**
     * 收藏次数
     */
    @TableField("collectionNum")
    @Field(type = FieldType.Long)
    private Long collectionNum;

    /**
     * 知识点名称，以逗号隔开
     */
    @TableField("knowledgeNames")
    @Field(type = FieldType.Text)
    private String knowledgeNames;

    /**
     * 题目被使用次数
     */
    @TableField("useNum")
    @Field(type = FieldType.Long)
    private Long useNum;

    /**
     * 题目错误次数
     */
    @TableField("errorNum")
    @Field(type = FieldType.Long)
    private Long errorNum;

    @TableField("trueType")
    @Field(type = FieldType.Long)
    private Long trueType;

    /**
     * 源id
     */
    @TableField("sourceId")
    @Field(type = FieldType.Integer)
    private Integer sourceId;

    /**
     * 源路径
     */
    @TableField("sourceUrl")
    @Field(type = FieldType.Text)
    private String sourceUrl;

    /**
     * 类型名称
     */
    @TableField("sourceTypeName")
    @Field(type = FieldType.Text)
    private String sourceTypeName;

    @TableField("IsSync")
    @Field(type = FieldType.Boolean)
    private Boolean IsSync;

    /**
     * 题目查重Hash值
     */
    @TableField("HashCode")
    @Field(type = FieldType.Text)
    private String HashCode;

    /**
     * 题目类型别名
     */
    @TableField("typeAlise")
    @Field(type = FieldType.Text)
    private String typeAlise;

    /**
     * 临时同步，用完删除
     */
    @TableField("needSync")
    @Field(type = FieldType.Integer)
    private Integer needSync;

    /**
     * 原来题库类型
     */
    @TableField("oldBankType")
    @Field(type = FieldType.Integer)
    private Integer oldBankType;

    /*小题集合*/
    @TableField(exist = false)
    @Field(type = FieldType.Object)
    private List<EduExamqucont> eduExamqucontList;


}
