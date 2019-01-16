package com.neusoft.fourthstep;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by Administrator on 2019/1/14.
 */

public class FourthStepMap extends Mapper<LongWritable,Text,Text,Text>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

    }
}
