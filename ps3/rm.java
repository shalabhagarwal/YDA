package rv;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class rm extends Mapper<LongWritable,Text,Text,FloatWritable>
{
	Text video;
	float rating;
	
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String line=value.toString();
		
		String[] s=line.split("\t");
		
		if(s.length>7)
		{
			video=new Text(s[0]);
			rating=Float.parseFloat(s[6]);
		}
		

		context.write(video,new FloatWritable(rating));
		
	}
}