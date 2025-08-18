package com.javapractice.hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName: PartitionCombiner
 * @Description:
 * @Author: Kanra
 * @Date: 2025/7/29
 */
public class PartitionCombiner  extends Reducer<Text, PartitionBean, Text, PartitionBean> {

    @Override
    protected void reduce(Text key, Iterable<PartitionBean> values, Reducer<Text, PartitionBean, Text, PartitionBean>.Context context) throws IOException, InterruptedException {
        for (PartitionBean bean : values) {
            context.write(key, bean);
        }
    }
}
