package com.neusoft.sixstep;

import com.neusoft.FileUtil;
import com.neusoft.firststep.FirstStepMap;
import com.neusoft.firststep.FirstStepReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by Administrator on 2019/1/14.
 */
public class SixStepDriver {

    public static void main(String[] args) throws Exception {
        boolean res = false;
        for (int i = 1; i < 7; i++) {
            int j=i-1;
            if (i == 1){
                FileUtil.deleteDir("output6/output6-1");

                System.setProperty("hadoop.home.dir", "e:/hadoop-2.8.3");
                System.setProperty("HADOOP_USER_NAME", "root") ;

                //该对象会默认读取环境中的 hadoop 配置。当然，也可以通过 set 重新进行配置
                Configuration conf = new Configuration();

                //job 是 yarn 中任务的抽象。
                Job job = Job.getInstance(conf);

            /*job.setJar("/home/hadoop/wc.jar");*/
                //指定本程序的jar包所在的本地路径
                job.setJarByClass(SixStepDriver.class);

                //指定本业务job要使用的mapper/Reducer业务类
                job.setMapperClass(SixStepMap.class);
                job.setReducerClass(SixStepReduce.class);
                //        job.setCombinerClass(FirstStepReduce.class);

                //指定mapper输出数据的kv类型。需要和 Mapper 中泛型的类型保持一致
                job.setMapOutputKeyClass(Text.class);
                job.setMapOutputValueClass(Text.class);

                //指定最终输出的数据的kv类型。这里也是 Reduce 的 key，value类型。
                job.setOutputKeyClass(Text.class);
                job.setOutputValueClass(Text.class);

                //指定job的输入原始文件所在目录
                FileInputFormat.setInputPaths(job, new Path("output5/part-r-00000"));
                //指定job的输出结果所在目录
                FileOutputFormat.setOutputPath(job, new Path("output6/output6-1"));

                //将job中配置的相关参数，以及job所用的java类所在的jar包，提交给yarn去运行
            /*job.submit();*/
                res = job.waitForCompletion(true);
            }else {
                FileUtil.deleteDir("output6/output6-"+i+"/");

                System.setProperty("hadoop.home.dir", "e:/hadoop-2.8.3");
                System.setProperty("HADOOP_USER_NAME", "root") ;


                //该对象会默认读取环境中的 hadoop 配置。当然，也可以通过 set 重新进行配置
                Configuration conf = new Configuration();

                //job 是 yarn 中任务的抽象。
                Job job = Job.getInstance(conf);

            /*job.setJar("/home/hadoop/wc.jar");*/
                //指定本程序的jar包所在的本地路径
                job.setJarByClass(SixStepDriver.class);

                //指定本业务job要使用的mapper/Reducer业务类
                job.setMapperClass(SixStepMap.class);
                job.setReducerClass(SixStepReduce.class);
                //        job.setCombinerClass(FirstStepReduce.class);

                //指定mapper输出数据的kv类型。需要和 Mapper 中泛型的类型保持一致
                job.setMapOutputKeyClass(Text.class);
                job.setMapOutputValueClass(Text.class);

                //指定最终输出的数据的kv类型。这里也是 Reduce 的 key，value类型。
                job.setOutputKeyClass(Text.class);
                job.setOutputValueClass(Text.class);

                //指定job的输入原始文件所在目录
                FileInputFormat.setInputPaths(job, new Path("output6/output6-"+j+"/part-r-00000"));
                //指定job的输出结果所在目录
                FileOutputFormat.setOutputPath(job, new Path("output6/output6-"+i+"/"));

                //将job中配置的相关参数，以及job所用的java类所在的jar包，提交给yarn去运行
                /*job.submit();*/
                res = job.waitForCompletion(true);
            }
        }
        System.exit(res?0:1);
    }
}
