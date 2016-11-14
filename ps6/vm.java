package vp;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class vm extends Mapper<LongWritable,Text,Text,IntWritable>
{
	Text video;
	int view;
	
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String line=value.toString();
		
		String[] s=line.split("\t");
		
		if(s.length>6)
		{
			video=new Text(s[0]);
			view=Integer.parseInt(s[5]);
		}
		

		context.write(video,new IntWritable(view));
		
	}
}