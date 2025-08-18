package com.javapractice.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @ClassName: PartitionMapper
 * @Description:
 * @Author: Kanra
 * @Date: 2025/7/16
 */
public class PartitionMapper extends Mapper<LongWritable, Text, Text, PartitionBean> {

    Text model = new Text();
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, PartitionBean>.Context context)
            throws IOException, InterruptedException {
        //一行文字を取得
        String str = value.toString();
        //文字を区切って単語数組になる
        String[] strs = str.split(" ");
        String[] modelStr = strs[1].split("_");
        String modelKey = modelStr[0];
        PartitionBean partitionBean = new PartitionBean();
        partitionBean.setId(strs[0]);
        partitionBean.setModel(strs[1]);
        partitionBean.setNetIp(strs[2]);
        partitionBean.setUsageTime(strs[3]);
        //出力
        model.set(modelKey);
        context.write(model, partitionBean);
    }
}
