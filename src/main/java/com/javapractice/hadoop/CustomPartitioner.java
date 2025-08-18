package com.javapractice.hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @ClassName: CustomPartition
 * @Description:
 * @Author: Kanra
 * @Date: 2025/7/17
 */
public class CustomPartitioner extends Partitioner<Text, PartitionBean> {
    @Override
    public int getPartition(Text text, PartitionBean partitionBean, int numPartitions) {
        int partition=0;
        final String appkey = text.toString();
        if(appkey.equals("kar")){
            partition=1;
        } else if (appkey.equals("nex")){
            partition=2;
        } else {
            partition=0;
        }
        return partition;
    }
 }
