package com.xcxyz.mini.dubbo.common.serialization.impl;

import com.xcxyz.mini.dubbo.common.serialization.ISerializer;
import org.apache.commons.lang3.reflect.MethodUtils;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  2:49 下午
 */
public class ProtocolBufferSerializer implements ISerializer {


    @Override
    public <T> byte[] serialize(T obj) {
        try {
            return (byte[]) MethodUtils.invokeMethod(obj, "toByteArray");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> cls) {
        try {
            Object o = MethodUtils.invokeStaticMethod(cls, "getDefaultInstance");
            return (T) MethodUtils.invokeMethod(o, "parseFrom", new Object[]{data});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
