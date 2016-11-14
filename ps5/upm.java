package up;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import java.io.IOException;
import org.apache.hadoop.io.*;

public class upm extends Mapper<LongWritable,Text,Text,IntWritable>
{
	Text uploader=new Text();
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String line=value.toString();
		
		String[] s=line.split("\t");
		
		if(s.length>2)
			uploader.set(s[1]);

		context.write(uploader,new IntWritable(1));
		
	}
}

