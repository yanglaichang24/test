package com.ylch.test.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by yanglaichang1 on 2017/4/12.
 */
public class SimpleLuceneTest {

    private static String file_dir = "D:/luceneTxt";// 带索引的本地文件目录

    private static String index_dir = "D:/luceneTxt";

    @Test
    public void test() throws IOException {
        Analyzer analyzer = new StandardAnalyzer();
        Path path = Paths.get(index_dir);
        Directory directorty = FSDirectory.open(path);
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setInfoStream(System.out);
        IndexWriter writer = new IndexWriter(directorty, config);
        Document doc = new Document();
        StringField id = new StringField("id", "1", Field.Store.YES);
        //new Field()
        TextField textField = new TextField("name", "中国我是", Field.Store.YES);
        doc.add(id);
        writer.addDocument(doc);
        //writer.commit();
        writer.close();
    }

    @Test
    public void test1() throws IOException {
        Path path = Paths.get(index_dir);
        Directory directorty = FSDirectory.open(path);
       //new IndexReader()
    }


    @Test
    public void test3() throws IOException {
        Analyzer analyzer = new StandardAnalyzer();
        Path path = Paths.get(index_dir);
        Directory directorty = FSDirectory.open(path);
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setInfoStream(System.out);
        IndexWriter writer = new IndexWriter(directorty, config);
        ;
        Document doc = new Document();
        StringField id = new StringField("id", "1", Field.Store.YES);
        TextField textField = new TextField("name", "中国我是", Field.Store.YES);
        doc.add(id);
        doc.add(textField);

        //writer.updateDocument();
        //writer.commit();
        writer.close();
    }







}
