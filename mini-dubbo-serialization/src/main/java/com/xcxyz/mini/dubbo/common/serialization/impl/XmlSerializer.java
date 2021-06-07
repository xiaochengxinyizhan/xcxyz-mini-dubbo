package com.xcxyz.mini.dubbo.common.serialization.impl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xcxyz.mini.dubbo.common.serialization.ISerializer;

/**
 * @author liuxiaocheng
 * @create 2021/6/1  2:52 下午
 */
public class XmlSerializer implements ISerializer {

    private static final XStream xStream = new XStream(new DomDriver());


    @Override
    public <T> byte[] serialize(T obj) {
        return xStream.toXML(obj).getBytes();
    }


    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        String xml = new String(data);
        return (T) xStream.fromXML(xml);
    }
}
