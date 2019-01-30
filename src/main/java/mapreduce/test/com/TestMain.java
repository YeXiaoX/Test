package mapreduce.test.com;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * Created by yexiaoxin on 2019/1/25.
 */
public class TestMain {
    public static void main(String[] args) {
        String[] inPath = new String[]{"hdfs://master:9000/test/input/"};
        String outPath = "hdfs://master:9000/test/output1";
        Configuration conf = new Configuration();
        String jobName = "time-pv";

        JobInitModel job = new JobInitModel(inPath, outPath, conf, null, jobName
                , TestMain.class, null, TestMapper.class, Text.class, IntWritable.class, null, null, TestReduce.class
                , Text.class, IntWritable.class);

        JobInitModel sortJob = new JobInitModel(new String[]{outPath }, "/tt" , conf
                , null, jobName + "sort", TestMain.class, null, TestMapper.class, Text.class, IntWritable.class, null, null, null, null, null);

        try {
            BaseDriver.initJob(new JobInitModel[]{job, sortJob});
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
