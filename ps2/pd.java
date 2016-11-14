package pp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class pd
{
	public static void main(String[] args) throws Exception
	{
		Configuration conf = new Configuration();
		String[] programArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		
		if (programArgs.length != 2)
		{
			System.err.println("Error Occur");
			System.exit(2);
		}
	
		Job job = new Job(conf, "---");
		job.setJarByClass(pd.class);
		job.setMapperClass(pm.class);
		job.setReducerClass(pr.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		FileInputFormat.addInputPath(job, new Path(programArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(programArgs[1]));
		// Submit the job and wait for it to finish.
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}