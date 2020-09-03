package com.pbj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
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
public class EduExamqucont implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
    private String cont;
    @Field(type = FieldType.Text)
    private String ans;
    @Field(type = FieldType.Text)
    @TableField("prepA")
    private String prepA;
    @Field(type = FieldType.Text)
    @TableField("prepB")
    private String prepB;
    @Field(type = FieldType.Text)
    @TableField("prepC")
    private String prepC;
    @Field(type = FieldType.Text)
    @TableField("prepD")
    private String prepD;
    @Field(type = FieldType.Text)
    @TableField("prepE")
    private String prepE;
    @Field(type = FieldType.Text)
    @TableField("prepF")
    private String prepF;
    @Field(type = FieldType.Text)
    @TableField("prepG")
    private String prepG;
    @Field(type = FieldType.Text)
    @TableField("prepH")
    private String prepH;
    @Field(type = FieldType.Long)
    @TableField("quId")
    private Long quId;
    @Field(type = FieldType.Long)
    @TableField("picId")
    private Long picId;
    @Field(type = FieldType.Integer)
    @TableField("isAuto")
    private Integer isAuto;

    @Field(type = FieldType.Text)
    private String analysis;

    @Field(type = FieldType.Text)
    @TableField("errNum")
    private String errNum;

    /**
     * 正确率d
     */
    @Field(type = FieldType.Text)
    @TableField("trueFreq")
    private String trueFreq;

    /**
     * 被使用次数
     */
    @Field(type = FieldType.Text)
    @TableField("useNum")
    private String useNum;

    /**
     * 错误率
     */
    @Field(type = FieldType.Text)
    @TableField("errFreq")
    private String errFreq;

    @Field(type = FieldType.Long)
    @TableField("anspicId")
    private Long anspicId;

    @TableField("prepApicId")
    @Field(type = FieldType.Long)
    private Long prepApicId;

    @TableField("prepBpicId")
    @Field(type = FieldType.Long)
    private Long prepBpicId;

    @TableField("prepCpicId")
    @Field(type = FieldType.Long)
    private Long prepCpicId;

    @TableField("prepDpicId")
    @Field(type = FieldType.Long)
    private Long prepDpicId;

    @TableField("prepEpicId")
    @Field(type = FieldType.Long)
    private Long prepEpicId;

    @TableField("prepFpicId")
    @Field(type = FieldType.Long)
    private Long prepFpicId;

    @TableField("prepGpicId")
    @Field(type = FieldType.Long)
    private Long prepGpicId;

    @TableField("prepHpicId")
    @Field(type = FieldType.Long)
    private Long prepHpicId;

    @TableField("keyPointCode")
    @Field(type = FieldType.Text)
    private String keyPointCode;

    @TableField("analysispicId")
    @Field(type = FieldType.Long)
    private Long analysispicId;

    /**
     * 小题类型 1为选择题2非选择
     */
    @TableField("typeId")
    @Field(type = FieldType.Long)
    private Long typeId;

    /**
     * 0不需要同步,1需要同步,2已同步
     */
    @TableField("syncType")
    @Field(type = FieldType.Long)
    private Long syncType;

    /**
     * 答案图片宽
     */
    @TableField("ansImageWidth")
    @Field(type = FieldType.Float)
    private Float ansImageWidth;

    /**
     * 解析图片宽
     */
    @TableField("analysisImageWidth")
    @Field(type = FieldType.Float)
    private Float analysisImageWidth;


}
