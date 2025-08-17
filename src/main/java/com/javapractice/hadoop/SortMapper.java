package com.javapractice.hadoop;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @ClassName: SortMapper
 * @Description:
 * @Author: Kanra
 * @Date: 2025/08/13
 */
public class SortMapper extends Mapper<LongWritable, Text, Text, SortBean> {

    Text model = new Text();
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, SortBean>.Context context)
            throws IOException, InterruptedException {
        //一行文字を取得
        String str = value.toString();
        //文字を区切って単語数組になる
        String[] strs = str.split(" ");
        SortBean sortBean = new SortBean();
        sortBean.setId(strs[0]);
        sortBean.setModel(strs[1]);
        sortBean.setNetIp(strs[2]);
        sortBean.setUsageTime(Long.parseLong(strs[3]));
        //出力
        model.set(strs[0]);
        context.write(model, sortBean);
    }
}
