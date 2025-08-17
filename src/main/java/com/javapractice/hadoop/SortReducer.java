package com.javapractice.hadoop;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName: SortReducer
 * @Description:
 * @Author: Kanra
 * @Date: 2025/08/13
 */
public class SortReducer extends Reducer<Text, SortBean, NullWritable, SortBean> {

    @Override
    protected void reduce(Text key, Iterable<SortBean> values, Reducer<Text, SortBean, NullWritable, SortBean>.Context context) throws IOException, InterruptedException {
        for (SortBean value : values) {
            context.write(NullWritable.get(), value);
        }
    }
}
