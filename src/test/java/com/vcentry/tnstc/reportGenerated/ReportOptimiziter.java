package com.vcentry.tnstc.reportGenerated;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ReportOptimiziter {
public static void OptimizeReport() throws IOException
{
	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd hh-mm-ss-mmm");
	String name = df.format(date);
	File src = new File("C:\\Users\\prashakt\\workspace1\\DDDframework\\Screenshot");
	File dst = new File("C:\\Users\\prashakt\\workspace1\\DDDframework\\Old screenshot\\" + name);
	FileUtils.copyDirectoryToDirectory(src, dst);
	FileUtils.cleanDirectory(src);
	
}
}
