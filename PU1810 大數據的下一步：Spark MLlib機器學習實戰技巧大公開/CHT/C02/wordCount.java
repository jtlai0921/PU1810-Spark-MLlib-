import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class WordCount {

    public static class Map extends MapReduceBase implements
            Mapper<LongWritable, Text, Text, IntWritable> {				//建立固定Map格式
        private final static IntWritable one = new IntWritable(1);			//建立資料1格式
        private Text word = new Text();								//設定輸入格式
        public void map(LongWritable key, Text value,					//開始map程式
                OutputCollector<Text, IntWritable> output, Reporter reporter)
                throws IOException {			
            String line = value.toString();							//將傳入值定義為line
            StringTokenizer tokenizer = new StringTokenizer(line);			//格式化傳入值
            while (tokenizer.hasMoreTokens()) {						//開始迭代計算
                word.set(tokenizer.nextToken());						//設定輸入值
                output.collect(word, one);							//寫入輸出值
            }
        }
    }

    public static class Reduce extends MapReduceBase implements
            Reducer<Text, IntWritable, Text, IntWritable> {			//建立固定Reduce格式
        public void reduce(Text key, Iterator<IntWritable> values,		//開始Reduce程式
                OutputCollector<Text, IntWritable> output, Reporter reporter)	
                throws IOException {
            int sum = 0;											//起始化計算機
            while (values.hasNext()) {							//開始迭代計算輸入值
                sum += values.next().get();							//計數器計算
            }
            output.collect(key, new IntWritable(sum));					//建立輸出結果
        }
    }

    public static void main(String[] args) throws Exception {				//開始主程式
        JobConf conf = new JobConf(WordCount.class);					//設定主程式
        conf.setJobName("wordcount");								//設定主程式名

        conf.setOutputKeyClass(Text.class);							//設定輸出Key格式
        conf.setOutputValueClass(IntWritable.class);				//設定輸出Vlaue格式

        conf.setMapperClass(Map.class);							//設定主Map
        conf.setCombinerClass(Reduce.class);				//設定第一次Reduce方法
        conf.setReducerClass(Reduce.class); 					//設定第主Reduce方法

        conf.setInputFormat(TextInputFormat.class);				//設定輸入格式
        conf.setOutputFormat(TextOutputFormat.class);				//設定輸出格式

        FileInputFormat.setInputPaths(conf, new Path(args[0]));		//設定輸入檔案路徑
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));		//設定輸出路徑

        JobClient.runJob(conf);								//開始主程式
    }
}
