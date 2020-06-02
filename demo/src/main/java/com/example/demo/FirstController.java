package com.example.demo;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Row;
import java.io.*;
import java.util.Arrays;
import org.apache.spark.sql.Dataset;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FirstController {
    @RequestMapping("/")
    public String index () {
        return "Hello";
    }

    @RequestMapping(value="/submitQuery", method= RequestMethod.POST)
    public String submitQuery(@RequestBody String query) throws IOException {
            /*SparkSession ss = SparkSession.builder().config("spark.sql.warehouse.dir", "file:///tmp/spark-warehouse").master("local").getOrCreate();
            //JavaSparkContext sc = new JavaSparkContext(conf);
            ss.sparkContext().setLogLevel("ERROR");
            Logger root = Logger.getRootLogger();
            root.setLevel(Level.ERROR);

            String path1 = "C:/Users/Administrator/Desktop/Logssprak/clg_details.json";
            String path2 = "C:/Users/Administrator/Desktop/Logssprak/student_details.json";
            String uri = "hdfs://hadoop1.example.com:9000/tmp";
            //Configuration conf = new Configuration();

            //FileSystem fs = FileSystem.get(URI.create(uri),conf);
            //fs.copyFromLocalFile(new Path(path1),new Path(uri));

            // read text file to RDD
            Dataset<Row> lines = ss.read().json(path1);

            lines.show();
            lines.createOrReplaceTempView("A");

            Dataset<Row> lines1 = ss.read().json(path2);
            lines1.show();
            lines1.createOrReplaceTempView("B");
            Dataset<Row> record = ss.sql(query);
            record.explain(true);
            record.show();
            //record.take(30);
            //record.show();
            // collect RDD for printing
            //lines.foreach(item -> {System.out.println(item);});*/
        //SparkConf conf1 = new SparkConf().setAppName("firstProgram").setMaster("local");
        PrintWriter writer = new PrintWriter("C:/Users/Administrator/myapp/DB-Project-UI-master/Spark-Execution-Monitor/output.txt");
        writer.print("");
        writer.close();
        String sf="";
        if(query.charAt(query.length()-1)=='=')
        {
            sf = query.substring(0,query.length()-1);
        }
        else
        {
            sf = query;
        }
        String g = sf.replace('+',' ');
        /*String g = "\\+";
        sf.replaceAll(g,"\\s");*/
        System.out.println(sf);
        System.out.println(g);
       SparkSession ss = SparkSession.builder().config("spark.sql.warehouse.dir","file:///tmp/spark-warehouse").master("local").getOrCreate();
        //JavaSparkContext sc = new JavaSparkContext(conf1);
        System.out.println(ss.sparkContext().applicationId());
       System.setProperty("Hadoop.home.dir","C:/Users/Administrator/Downloads/winutils-master/hadoop-2.7.1");
        //ss.sparkContext().setLogLevel("ERROR");
        //Logger root = Logger.getRootLogger();
        //root.setLevel(Level.ERROR);
        String path1 = "C:/Users/Administrator/Desktop/demo/clg_details.json";
        String path2 = "C:/Users/Administrator/Desktop/demo/student_details.json";
        String uri = "hdfs://hadoop1.example.com:9000/tmp";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        fs.copyFromLocalFile(new Path(path1),new Path(uri));
        fs.copyFromLocalFile(new Path(path2),new Path(uri));
        String path3 = "hdfs://hadoop1.example.com:9000/tmp/clg_details.json";
        String path4 = "hdfs://hadoop1.example.com:9000/tmp/student_details.json";
        Dataset<Row> lines = ss.read().json(path3);
        lines.repartition(10);
        //lines.show();
        lines.createOrReplaceTempView("A");
        Dataset<Row> lines1 = ss.read().json(path4);
        //lines1.show();
        lines1.repartition(10);
        lines1.createOrReplaceTempView("B");
        Dataset<Row> record = ss.sql(g);
        record.explain(true);
        //System.out.println(123456);

        //record.show();
        //record.take(30);
        //record.show();
        // collect RDD for printing
        //lines.foreach(item -> {System.out.println(item);});

        String f1 = "C:/Users/Administrator/myapp/DB-Project-UI-master/Spark-Execution-Monitor/f1.txt";
        String f2 = "C:/Users/Administrator/myapp/DB-Project-UI-master/Spark-Execution-Monitor/f2.txt";
        String f3 = "C:/Users/Administrator/myapp/DB-Project-UI-master/Spark-Execution-Monitor/f3.txt";
        String f4 = "C:/Users/Administrator/myapp/DB-Project-UI-master/Spark-Execution-Monitor/f4.txt";

        String[] f = new String[4];
        f[0]=f1;
        f[1]=f2;
        f[2]=f3;
        f[3]=f4;

        for(int i=0; i<4; i++) {
            try {
                new FileWriter(f[i], false).close();
            }
            catch (java.io.IOException e)
            {
                System.out.println("An error occurred.");
            }
        }
        int ind=-1;
        try {

            File myObj = new File("C:/Users/Administrator/myapp/DB-Project-UI-master/Spark-Execution-Monitor/output.txt");
            Scanner myReader = new Scanner(myObj);
            int flag=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equals("== Parsed Logical Plan =="))
                {
                    ind=0;
                }
                else if(data.equals("== Analyzed Logical Plan =="))
                {
                    ind=1;
                }
                else if(data.equals("== Optimized Logical Plan =="))
                {
                    ind=2;
                }
                else if(data.equals("== Physical Plan =="))
                {
                    ind=3;
                }
                String dataa = data+"\n";
                if (data.trim().length()>0) {
                    if (ind!=-1) {
                        try {
                            BufferedWriter out = new BufferedWriter(
                                    new FileWriter(f[ind], true));
                            out.write(dataa);
                            out.close();
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }
                        flag = 1;
                    }
                }
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.trim().length()>0) {
                    if (data.charAt(0) == '=' && data.charAt(1) == '=' || flag == 1) {
                        try {
                            BufferedWriter out = new BufferedWriter(
                                    new FileWriter(f2, true));
                            out.write(data);
                            out.close();
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }
                        flag = 1;
                    }
                }
                else {
                    try {
                        BufferedWriter out = new BufferedWriter(
                                new FileWriter(f2, true));
                        out.write(data);
                        out.close();
                    } catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //ss.stop();
        return ("Hello" + query);

    }

}
