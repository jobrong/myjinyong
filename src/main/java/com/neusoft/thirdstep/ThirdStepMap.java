package com.neusoft.thirdstep;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/14.
 */

public class ThirdStepMap extends Mapper<LongWritable,Text,Text,Text>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("[<|>|,|\t]");
        context.write(new Text(split[1]),new Text(split[2]+":"+split[4]));
    }
}
