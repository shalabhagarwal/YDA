package rv;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import java.io.IOException;	
import java.util.Iterator;
import org.apache.hadoop.io.*;

public class rr extends Reducer<Text,FloatWritable,Text,FloatWritable> 
{
	public void reduce(Text t,FloatWritable v,Context context)throws IOException,InterruptedException
	{
		context.write(t, v);
	}
}
