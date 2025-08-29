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
 * @ClassName: SortDriver
 * @Description:
 * @Author: Kanra
 * @Date: 2025/08/13
 */
public class SortDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //配置ファイルを設定とJobを作成
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "SortDriver");
        //Mapper、Reducer、Driverクラスを添加
        job.setJarByClass(SortDriver.class);
        job.setMapperClass(SortMapper.class);
        job.setReducerClass(SortReducer.class);
        //Mapの出力値のタイプ
        job.setMapOutputKeyClass(SortBean.class);
        job.setMapOutputValueClass(NullWritable.class);
        //最終出力値のタイプ
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(SortBean.class);

        job.setNumReduceTasks(0);
        //入力と出力ファイルのアドレス
        FileInputFormat.setInputPaths(job, new Path("D:\\intput.txt"));
        FileOutputFormat.setOutputPath(job, new Path("D:\\output"));
        //タスクをコミット
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
