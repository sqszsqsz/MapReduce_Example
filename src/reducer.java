/**
 * Created by SweetSoul on 3/2/2016.
 */
import java.io.IOException;
//import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context output)
            throws IOException, InterruptedException {
        int voteCount = 0;
        for (IntWritable value : values) {
            voteCount += value.get();
        }
        output.write(key, new IntWritable(voteCount));
    }

}
