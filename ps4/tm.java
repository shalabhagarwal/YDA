package tp;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class tm extends Mapper<LongWritable,Text,Text,IntWritable>
{
	Text video;
	int time;
	
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String line=value.toString();
		
		String[] s=line.split("\t");
		
		if(s.length>3)
		{
			video=new Text(s[0]);
			time=Integer.parseInt(s[2]);
		}
		

		context.write(video,new IntWritable(time));
		
	}
}