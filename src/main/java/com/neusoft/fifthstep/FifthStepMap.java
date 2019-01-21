package com.neusoft.fifthstep;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2019/1/14.
 */

public class FifthStepMap extends Mapper<LongWritable,Text,Text,Text>{
    int i = 1;
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("[#|\t]");
        context.write(new Text(i+"#"+split[0]),new Text(split[1]+"#"+split[2]));
        i++;
    }
}
