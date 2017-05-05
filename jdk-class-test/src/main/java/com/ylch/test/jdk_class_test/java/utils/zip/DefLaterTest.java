package com.ylch.test.jdk_class_test.java.utils.zip;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Created by yanglaichang1 on 2017/4/18.
 *
 * This class provides support for general purpose compression using the popular ZLIB compression library.
 * The ZLIB compression library was initially developed as part of the PNG graphics standard and is not protected by patents.
 * It is fully described in the specifications at the java.util.zip package description.
 * The following code fragment demonstrates a trivial compression and decompression of a string
 * using Deflater and Inflater.
 *
 */
public class DefLaterTest {

    private String inputString = "blahblahblahsolaiujtrfowejmportfiuqjw0p[o9rjkjflkasjoldfijowjflsml;fkjaspl;iojrfopewijfoljas;lijfoewijrfolj" +
            "spaijfopwejlfkjna;olwsijhfgolwwijhghfolaiwjkgfolisjdolgfijowiejrflgtkmjndslakjgoliwjeaolfknml;sdkijfoaijsogjnlewikjfgoiwejsflo" +
            "aslikjgff;ol;wiehjgfoliewhjkngfoljfoiajwleoijfaprij4pwemfp;soifp343mwlrrfkjsd" +
            "posijarfmwelfkjmasolijvlakmsdfvl;kajssjdodaiufow;gdk'pgoi[pwajfpeowjorfpiuwjoejrf" +
            "lfiajweermnfglsijhagpoahyglknwoliujrfofglksaojlkkfjsodiflkew';sapfusklafdjowelfkodshfiwqklerfl" +
            "slidfoweenflkgholasdfwoiuerflwq[pjalndlfk" +
            "fasklierlkjflsldv8 aykkntlng" +
            "slsaidufomnelkgmoaunglkjadof" +
            "laksiuyfaiehljkflakjg" +
            "aoiutglkndmsalijfg" +
            "aliurelkntr;lkmg" +
            "liwjelkgmlajhgo8yghbb" +
            "aoiygtnalhijaofd" +
            "oliaulgmlkuy orewjtglk" +
            "lialkghlhbyhaklofiyjtgrr" +
            "";


    @Test
    public void demonstrates(){
        try {
            byte[] input = inputString.getBytes("UTF-8");

            System.out.println("压缩过前的数据" + Arrays.toString(input));
            System.out.println("压缩过前的数据" + input.length);
            // Compress the bytes
            byte[] output = new byte[1000];
            Deflater compresser = new Deflater();
            compresser.setInput(input);
            compresser.finish();
            int compressedDataLength = compresser.deflate(output);
            compresser.end();

            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("压缩过后的数据" + Arrays.toString(output));
           // System.out.println("压缩过后的数据" + new String(output,"UTF-8"));
            System.out.println("压缩过后的数据" + compressedDataLength);

            //new String()

            // Decompress the bytes
            Inflater decompresser = new Inflater();
            decompresser.setInput(output, 0, compressedDataLength);
            byte[] result = new byte[1000];
            int resultLength = decompresser.inflate(result);
            decompresser.end();

            // Decode the bytes into a String
            String outputString = new String(result, 0, resultLength, "UTF-8");
            System.out.println("解压过后的" + outputString);
            System.out.println("解压过后的" + resultLength);

        } catch(java.io.UnsupportedEncodingException ex) {
            // handle
        } catch (java.util.zip.DataFormatException ex) {
            // handle
        }
    }


    /***
     *   有问题
     */
    @Test
    public void demonstrates2() throws DataFormatException, UnsupportedEncodingException {
        byte[] input = inputString.getBytes();
        System.out.println(input.length);
        ByteArrayOutputStream bos = new ByteArrayOutputStream(input.length);

        Deflater compresser = new Deflater();
        compresser.setLevel(Deflater.BEST_SPEED);
        compresser.deflate(input,0,input.length);
        compresser.finish();

        final byte[] buf = new byte[1024];
        while (!compresser.finished()) {
            int count = compresser.deflate(buf);
            System.out.println("count : "+count);
            bos.write(buf, 0, count);
        }

        System.out.println(bos.toByteArray().length);
        System.out.println(Arrays.toString(bos.toByteArray()));

        byte[] output = bos.toByteArray();
        Inflater decompresser = new Inflater();
        decompresser.setInput(output, 0, output.length);
        byte[] result = new byte[1024];
        int resultLength = decompresser.inflate(result);
        decompresser.end();
        // Decode the bytes into a String
        String outputString = new String(result, 0, resultLength, "UTF-8");

        System.out.println(outputString);
    }



}
