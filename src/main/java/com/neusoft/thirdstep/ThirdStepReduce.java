package com.neusoft.thirdstep;



import com.google.common.base.Joiner;
import org.apache.hadoop.io.LongWritable;
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
public class ThirdStepReduce extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        List<String> list1 = new ArrayList();
        List<Double> list2 = new ArrayList();
        Double sum = 0.0;
        String string = "0.1#";
        for (Text value : values) {
            String[] split = value.toString().split(":");
            sum += Double.parseDouble(split[1]);
            list2.add(Double.parseDouble(split[1]));
            list1.add(split[0]);
        }
        for (int i=0;i<list1.size();i++){
            if (i == list1.size()-1){
                string += list1.get(i) + ":" + list2.get(i)/sum;
                break;
            }
            string += list1.get(i) + ":" + list2.get(i)/sum + ";";
        }
        context.write(key,new Text(string));
    }
}
