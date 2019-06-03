package com.study.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 资源类型
 * @author Administrator
 */
@Getter
@AllArgsConstructor
public enum ResourceTypeEnum {
    /**
     * 图片资源
     */
    IMAGE("image", "图片资源"),

    /**
     * xml资源
     */
    XML("xml", "xml资源");

    /**
     * 类型
     */
    private final String type;
    /**
     * 描述
     */
    private final String description;
}