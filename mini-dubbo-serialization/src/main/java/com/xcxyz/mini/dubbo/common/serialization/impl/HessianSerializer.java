package com.xcxyz.mini.dubbo.common.serialization.impl;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.xcxyz.mini.dubbo.common.serialization.ISerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  2:54 下午
 */
public class HessianSerializer implements ISerializer {


    @Override
    public byte[] serialize(Object obj) {
        if (obj == null)
            throw new NullPointerException();

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            HessianOutput ho = new HessianOutput(os);
            ho.writeObject(obj);
            return os.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        if (data == null)
            throw new NullPointerException();

        try {
            ByteArrayInputStream is = new ByteArrayInputStream(data);
            HessianInput hi = new HessianInput(is);
            return (T) hi.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
