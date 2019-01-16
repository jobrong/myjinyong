package com.neusoft.secondstep;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2019/1/14.
 */

public class SecondStepMap extends Mapper<LongWritable,Text,Text,LongWritable>{
//    Set<Text> set = new HashSet<>();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] strings = value.toString().split(" ");
        for (int i = 0;i<strings.length;i++){
            for (int j = 0;j<strings.length;j++){
                if (!strings[i].equals(strings[j])){
                    String s ="<" + strings[i] + "," + strings[j] +">";
//                    set.add(new Text(s));
                    context.write(new Text(s),new LongWritable(1));
                }
            }
        }
    }
}
