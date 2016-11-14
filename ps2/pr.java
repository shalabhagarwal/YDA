package pp;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import java.io.IOException;	
import java.util.Iterator;
import org.apache.hadoop.io.*;

public class pr extends Reducer<Text,FloatWritable,Text,FloatWritable> 
{
	public void reduce(Text t,FloatWritable v,Context context)throws IOException,InterruptedException
	{		
		context.write(t, v);
	}
}
