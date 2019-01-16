package com.neusoft.firststep;



import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by Administrator on 2019/1/14.
 */
public class FirstStepReduce extends Reducer<LongWritable,Text,NullWritable,Text> {
    @Override
    protected void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Text strNameLine = values.iterator().next();
        if(!strNameLine.toString().equals(""))
        {
            context.write(NullWritable.get(),strNameLine);
        }

    }
}
