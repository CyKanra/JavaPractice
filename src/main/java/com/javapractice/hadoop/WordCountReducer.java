package com.javapractice.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName: WordcountReducer
 * @Description:
 * @Author: Kanra
 * @Date: 2023/02/23
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    Integer sum;
    IntWritable intWritable = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {
        sum = 0;
        //累積加算
        for (IntWritable value : values) {
            sum += value.get();
        }
        //出力
        intWritable.set(sum);
        context.write(key,intWritable);
    }
}
