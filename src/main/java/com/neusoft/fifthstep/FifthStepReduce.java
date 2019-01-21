package com.neusoft.fifthstep;



import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/14.
 */
//1#上官#0.021478781211719835 曾铁鸥:0.016666666666666666;桑飞虹:0.125;徐铮:0.016666666666666666;书生:0.13333333333333333;殷仲翔:0.016666666666666
public class FifthStepReduce extends Reducer<Text,Text,Text,Text> {
//    Map<String,String> map1 = new HashMap();
//    Map<String,String> map2 = new HashMap();
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
//        String s1 = key.toString();
//        String s2 = values.iterator().next().toString();
//        map1.put(s1,s2);
//        map2.put(s1.split("#")[1],s1.split("#")[2]);
        context.write(key,values.iterator().next());
    }
//    @Override
//    protected void cleanup(Context context) throws IOException, InterruptedException {
//        for(Map.Entry<String,String> entry1:map1.entrySet()){
//            String s="";
//            String value = entry1.getValue();
//                for (Map.Entry<String,String> entry2:map2.entrySet()){
//                    if (value.contains(entry2.getKey())){
//                        s+=entry2.getKey()+":"+entry2.getValue()+";";
//                    }
//                }
//            context.write(new Text(entry1.getKey()),new Text(s));
//        }
//    }
}
