package com.xcxyz.mini.dubbo.common.serialization.impl;

import com.xcxyz.mini.dubbo.common.serialization.ISerializer;
import org.jboss.marshalling.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  2:58 下午
 */
public class MarshallingSerializer implements ISerializer {

    final static MarshallingConfiguration configuration = new MarshallingConfiguration();
    //获取序列化工厂对象,参数serial标识创建的是java序列化工厂对象
    final static MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");

    static {
        configuration.setVersion(5);
    }


    @Override
    public byte[] serialize(Object obj) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            final Marshaller marshaller = marshallerFactory.createMarshaller(configuration);
            marshaller.start(Marshalling.createByteOutput(byteArrayOutputStream));
            marshaller.writeObject(obj);
            marshaller.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }


    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            final Unmarshaller unmarshaller = marshallerFactory.createUnmarshaller(configuration);
            unmarshaller.start(Marshalling.createByteInput(byteArrayInputStream));
            Object object = unmarshaller.readObject();
            unmarshaller.finish();
            return (T) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
