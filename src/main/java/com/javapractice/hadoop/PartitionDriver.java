package com.javapractice.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @ClassName: PartitionDriver
 * @Description:
 * @Author: Kanra
 * @Date: 2025/7/17
 */
public class PartitionDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //配置ファイルを設定とJobを作成
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "PartitionDriver");
        //Mapper、Reducer、Driverクラスを添加
        job.setJarByClass(PartitionDriver.class);
        job.setMapperClass(PartitionMapper.class);
        job.setReducerClass(PartitionReducer.class);
        job.setCombinerClass(PartitionCombiner.class);
        //Mapの出力値のタイプ
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(PartitionBean.class);
        //最終出力値のタイプ
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(PartitionBean.class);

        job.setPartitionerClass(CustomPartitioner.class);
        job.setNumReduceTasks(3);
        //入力と出力ファイルのアドレス
        FileInputFormat.setInputPaths(job, new Path("D:\\partition.txt"));
        FileOutputFormat.setOutputPath(job, new Path("D:\\output"));
        //タスクをコミット
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
