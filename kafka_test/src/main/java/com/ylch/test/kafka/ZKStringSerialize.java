
package com.ylch.test.kafka;


import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * Created by yanglaichang1 on 2017/10/9.
 */

public class ZKStringSerialize implements ZkSerializer {

    public byte[] serialize(Object data) throws ZkMarshallingError {
        if(data instanceof String){
            try {
                return ((String)data).getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        if (bytes == null)
            return null;
        else
            try {
                return new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        return null;
    }
}

