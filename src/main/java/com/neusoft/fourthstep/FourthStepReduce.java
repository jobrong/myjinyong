package com.neusoft.fourthstep;



import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/14.
 */
public class FourthStepReduce extends Reducer<Text,Text,Text,Text> {
    String list = "";
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Double sum = 0.0;
        for (Text string :values){
            if (string.toString().contains("#")){
                list = string.toString();
            }else{
                sum += Double.parseDouble(string.toString());
            }
        }
        context.write(key,new Text(sum+list));
    }
}
