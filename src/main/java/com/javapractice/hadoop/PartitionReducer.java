package com.javapractice.hadoop;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName: PartitionReducer
 * @Description:
 * @Author: Kanra
 * @Date: 2025/7/16
 */
public class PartitionReducer extends Reducer<Text, PartitionBean, NullWritable, PartitionBean> {

    @Override
    protected void reduce(Text key, Iterable<PartitionBean> values, Reducer<Text, PartitionBean, NullWritable, PartitionBean>.Context context) throws IOException, InterruptedException {
        for (PartitionBean bean : values) {
            context.write(NullWritable.get(), bean);
        }
    }
}
