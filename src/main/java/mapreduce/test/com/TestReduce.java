package mapreduce.test.com;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * Created by yexiaoxin on 2019/1/25.
 */
public class TestReduce extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable> {
    IntWritable result = new IntWritable();

    @Override
    public void reduce(Text	key, Iterable<IntWritable> values, Context context) throws IOException,InterruptedException {
        int sum = 0;
        for(IntWritable val:values) {
            sum += val.get();
        }
        result.set(sum);
        context.write(key,result);
    }
}
