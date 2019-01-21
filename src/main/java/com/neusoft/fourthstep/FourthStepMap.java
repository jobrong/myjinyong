package com.neusoft.fourthstep;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/14.
 */

public class FourthStepMap extends Mapper<LongWritable,Text,Text,Text>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String string = value.toString();
        String[] kv1 = string.split("[\t|#]");
        context.write(new Text(kv1[0]),new Text("#"+kv1[2]));

        Double rank =Double.parseDouble( string.split("[#|\t]")[1]);
        String[] string2 = string.split("#")[1].split(";");
        for (String s:string2){
            String[] kv2 = s.split(":");
            context.write(new Text(kv2[0]),new Text(String.valueOf( Double.parseDouble(kv2[1]) * rank )));
        }
    }
}
