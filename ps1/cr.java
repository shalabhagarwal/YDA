package cp;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import java.io.IOException;	
import java.util.Iterator;
import org.apache.hadoop.io.*;

public class cr extends Reducer<Text,IntWritable,Text,IntWritable> 
{
	public void reduce(Text t,Iterable<IntWritable> v,Context context)throws IOException,InterruptedException
	{
		int sum=0;
		for(IntWritable i:v)
		{
			sum+=i.get();
		}
		
		context.write(t, new IntWritable(sum));
		
	}
}