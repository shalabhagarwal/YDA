package cp;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class cm extends Mapper<LongWritable,Text,Text,IntWritable>
{
	Text category=new Text();
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String line=value.toString();
		
		String[] s=line.split("\t");
		
		if(s.length>4)
		{
			category.set(s[3]);
		}
		

		context.write(category,new IntWritable(1));
		
	}
}

