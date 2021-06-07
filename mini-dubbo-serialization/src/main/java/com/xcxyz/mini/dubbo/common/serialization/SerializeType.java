package com.xcxyz.mini.dubbo.common.serialization;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  2:11 下午
 */
public enum SerializeType {
    DefaultJavaSerializer("DefaultJavaSerializer"),
    HessianSerializer("HessianSerializer"),
    JSONSerializer("JSONSerializer"),
    ProtoStuffSerializer("ProtoStuffSerializer"),
    XmlSerializer("XmlSerializer"),
    MarshallingSerializer("MarshallingSerializer"),

    AvroSerializer("AvroSerializer"),
    ProtocolBufferSerializer("ProtocolBufferSerializer"),
    ThriftSerializer("ThriftSerializer");

    private String serializeType;

    private SerializeType(String serializeType) {
        this.serializeType = serializeType;
    }


    public static SerializeType queryByType(String serializeType) {
        if (StringUtils.isBlank(serializeType)) {
            return null;
        }

        for (SerializeType serialize : SerializeType.values()) {
            if (StringUtils.equals(serializeType, serialize.getSerializeType())) {
                return serialize;
            }
        }
        return null;
    }

    public String getSerializeType() {
        return serializeType;
    }

}
