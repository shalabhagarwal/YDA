package vp;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import java.io.IOException;	
import java.util.Iterator;
import org.apache.hadoop.io.*;

public class vr extends Reducer<Text,IntWritable,Text,IntWritable> 
{
	public void reduce(Text t,IntWritable v,Context context)throws IOException,InterruptedException
	{
		
		context.write(t,v);
	}
}