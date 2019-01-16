package com.neusoft;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       String string = new String("张榕是猪");
        Result parse = NlpAnalysis.parse(string);
        List<Term> terms = parse.getTerms();
        for(Term term:terms){
            System.out.println(term.getName());
        }
    }
}
