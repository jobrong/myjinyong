package com.neusoft.firststep;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
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

public class FirstStepMap extends Mapper<LongWritable,Text,LongWritable,Text>{
    Set<String> nameSets = new HashSet<String>();
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        File file = new File ("person/jinyong_all_person.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        while(s != null){
            DicLibrary.insert(DicLibrary.DEFAULT,s);
            nameSets.add(s);
            s = bufferedReader.readLine();
        }
    }
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Result parse = DicAnalysis.parse(value.toString());
        List<Term> terms = parse.getTerms();
        StringBuilder stringBuilder = new StringBuilder();
        for (Term term:terms){
            if (nameSets.contains(term.getName())){
                stringBuilder.append(term.getName()+" ");
            }
        }
        context.write(key,new Text(stringBuilder.toString()));
    }
}
