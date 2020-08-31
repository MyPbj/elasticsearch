package com.pbj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
    private Long id;

    private String cont;

    private String ans;

    @TableField("prepA")
    private String prepA;

    @TableField("prepB")
    private String prepB;

    @TableField("prepC")
    private String prepC;

    @TableField("prepD")
    private String prepD;

    @TableField("prepE")
    private String prepE;

    @TableField("prepF")
    private String prepF;

    @TableField("prepG")
    private String prepG;

    @TableField("prepH")
    private String prepH;

    @TableField("quId")
    private Long quId;

    @TableField("picId")
    private Long picId;

    @TableField("isAuto")
    private Integer isAuto;

    private String analysis;

    @TableField("errNum")
    private String errNum;

    /**
     * 正确率d
     */
    @TableField("trueFreq")
    private String trueFreq;

    /**
     * 被使用次数
     */
    @TableField("useNum")
    private String useNum;

    /**
     * 错误率
     */
    @TableField("errFreq")
    private String errFreq;

    @TableField("anspicId")
    private Long anspicId;

    @TableField("prepApicId")
    private Long prepApicId;

    @TableField("prepBpicId")
    private Long prepBpicId;

    @TableField("prepCpicId")
    private Long prepCpicId;

    @TableField("prepDpicId")
    private Long prepDpicId;

    @TableField("prepEpicId")
    private Long prepEpicId;

    @TableField("prepFpicId")
    private Long prepFpicId;

    @TableField("prepGpicId")
    private Long prepGpicId;

    @TableField("prepHpicId")
    private Long prepHpicId;

    @TableField("keyPointCode")
    private String keyPointCode;

    @TableField("analysispicId")
    private Long analysispicId;

    /**
     * 小题类型 1为选择题2非选择
     */
    @TableField("typeId")
    private Long typeId;

    /**
     * 0不需要同步,1需要同步,2已同步
     */
    @TableField("syncType")
    private Long syncType;

    /**
     * 答案图片宽
     */
    @TableField("ansImageWidth")
    private Float ansImageWidth;

    /**
     * 解析图片宽
     */
    @TableField("analysisImageWidth")
    private Float analysisImageWidth;


}
