package pp;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class pm extends Mapper<LongWritable,Text,Text,FloatWritable>
{
	Text video;
	float rating;
	float p;
	int views,n;
	
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String line=value.toString();
		
		String[] s=line.split("\t");
		
		if(s.length>8)
		{
			video=new Text(s[0]);
			views=Integer.parseInt(s[5]);
			rating=Float.parseFloat(s[6]);
			n=Integer.parseInt(s[7]);
			p=(n*rating)/(views*5);			
		}
		

		context.write(video,new FloatWritable(p));
		
	}
}