// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileUtils.java

package com.dtmc.server.analytics.util;

import java.io.*;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtils
{

    public FileUtils()
    {
    }

    public static int getint()
    {
        return i++;
    }

    public static void stringToFile(String data, String fileName)
        throws IOException
    {
        BufferedWriter out = null;
        out = new BufferedWriter(new FileWriter(fileName));
        out.write(data);
        out.flush();
        out.close();
        break MISSING_BLOCK_LABEL_73;
        IOException e;
        e;
        if(logger.isInfoEnabled())
            logger.info("exception:", e);
        out.close();
        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        out.close();
        throw exception;
    }

    public static String fileToString(String fileName)
        throws IOException
    {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedreader = new BufferedReader(new FileReader(fileName));
        do
        {
            if(!bufferedreader.ready())
                break;
            String s2 = bufferedreader.readLine();
            if(s2 != null)
                stringBuffer.append(s2);
        } while(true);
        return stringBuffer.toString();
    }

    public static String inputStringToString(InputStream is)
        throws IOException
    {
        String xmlresponse = null;
        StringBuffer s = new StringBuffer();
        for(xmlresponse = getLineFromURL(is); xmlresponse != null; xmlresponse = getLineFromURL(is))
            s.append((new StringBuilder()).append(xmlresponse).append("\n").toString());

        return s.toString();
    }

    public static void deleteFile(String fileName)
        throws IOException
    {
        File file = new File(fileName);
        file.delete();
    }

    public static PrintWriter createFile(String filename)
        throws FileNotFoundException
    {
        FileOutputStream fileoutputstream = null;
        fileoutputstream = new FileOutputStream(filename);
        return new PrintWriter(fileoutputstream);
    }

    public static void deletefiles(String directory)
    {
        File dir = new File(directory);
        String children[] = dir.list();
        if(children != null)
        {
            for(int i = 0; i < children.length; i++)
            {
                String filename = children[i];
                File child = new File(filename);
                child.delete();
            }

        }
    }

    public static File openFile(String Name, boolean Create)
        throws IOException
    {
        File file = null;
        String FileName = Name;
        String FileFullName = FileName;
        file = new File(FileFullName);
        if(!file.exists() && !Create)
        {
            return null;
        } else
        {
            deleteFile(FileFullName);
            file = new File(FileFullName);
            return file;
        }
    }

    public static boolean exists(String Name)
    {
        File file = null;
        String FileName = Name;
        file = new File(FileName);
        return file.exists();
    }

    public void close(PrintWriter p)
    {
        p.close();
    }

    public static void print(PrintWriter p, int s)
    {
        p.print(s);
    }

    public static void print(PrintWriter p, String s)
    {
        p.print(s);
    }

    public static void println(PrintWriter p, int s)
    {
        p.println(s);
    }

    public static void println(PrintWriter p, String s)
    {
        p.println(s);
    }

    public static void makeDirectory(String dir)
    {
        File file = new File(dir);
        if(file.exists())
        {
            return;
        } else
        {
            file.mkdirs();
            return;
        }
    }

    public static String openDirectory(String dir)
    {
        File file = new File(dir);
        if(!file.isDirectory() || !file.exists())
            throw new IllegalArgumentException("directory does not exists");
        else
            return dir;
    }

    public static void deleteDirectory(String dir)
    {
        File file;
        file = new File(dir);
        if(!file.exists())
            return;
        try
        {
            if(file.isFile())
                file.delete();
            else
            if(file.isDirectory())
            {
                File fileList[] = file.listFiles();
                for(int i = 0; i < fileList.length; i++)
                    deleteDirectory(fileList[i].getAbsolutePath());

                file.delete();
            }
        }
        catch(Exception e)
        {
            if(logger.isInfoEnabled())
                logger.info("exception:", e);
        }
        return;
    }

    public static File renameFile(File file, String suffix)
    {
        String filename = file.getName();
        String newFilename = (new StringBuilder()).append(filename).append(suffix).toString();
        File renamedFile = new File(file.getParentFile(), newFilename);
        boolean renamed = file.renameTo(renamedFile);
        if(!renamed)
            return null;
        else
            return renamedFile;
    }

    public static void copyStream(InputStream in, Writer out)
        throws IOException
    {
        byte buf1[] = new byte[4096];
        char buf2[] = new char[4096];
        int len;
        while((len = in.read(buf1)) != -1) 
        {
            for(int i = 0; i < len; i++)
                buf2[i] = (char)buf1[i];

            out.write(buf2, 0, len);
        }
    }

    public String slurp(InputStream in)
        throws IOException
    {
        StringBuffer out = new StringBuffer();
        byte b[] = new byte[4096];
        int n;
        while((n = in.read(b)) != -1) 
            out.append(new String(b, 0, n));
        return out.toString();
    }

    public static int count(InputStream in)
        throws IOException
    {
        byte buf1[] = new byte[4096];
        int total = 0;
        int len;
        while((len = in.read(buf1)) != -1) 
        {
            int i = 0;
            while(i < len) 
            {
                total++;
                i++;
            }
        }
        return total;
    }

    public static void copyStream(Reader in, OutputStream out)
        throws IOException
    {
        char buf1[] = new char[4096];
        byte buf2[] = new byte[4096];
        int len;
        while((len = in.read(buf1)) != -1) 
        {
            for(int i = 0; i < len; i++)
                buf2[i] = (byte)buf1[i];

            out.write(buf2, 0, len);
        }
    }

    public static String[] getDirectoryContent(String dir)
    {
        File file = new File(dir);
        if(!file.isDirectory() || !file.exists())
            throw new IllegalArgumentException((new StringBuilder()).append("Unable to open : ").append(dir).toString());
        File fileList[] = file.listFiles();
        String filesList[] = new String[fileList.length];
        for(int i = 0; i < fileList.length; i++)
            filesList[i] = fileList[i].getAbsolutePath();

        return filesList;
    }

    public static Vector printSubdirectories(String dir)
    {
        File file = new File(dir);
        if(!file.isDirectory() || !file.exists())
            throw new IllegalArgumentException((new StringBuilder()).append("Unable to open : ").append(dir).toString());
        File fileList[] = file.listFiles();
        Vector filesList = new Vector();
        for(int i = 0; i < fileList.length; i++)
            if(fileList[i].isDirectory())
                filesList.add(fileList[i].getPath());

        return filesList;
    }

    public static void printDirectory(String dir)
    {
        File file;
        file = new File(dir);
        if(!file.exists())
            return;
        try
        {
            if(file.isFile())
                throw new IllegalArgumentException(file.getAbsolutePath());
            if(file.isDirectory())
            {
                File fileList[] = file.listFiles();
                for(int i = 0; i < fileList.length; i++)
                    printDirectory(fileList[i].getAbsolutePath());

            }
        }
        catch(Exception e)
        {
            if(logger.isInfoEnabled())
                logger.info("exception:", e);
        }
        return;
    }

    public static String generateTigraTree(String dir, String orig, String uri)
    {
        File file = new File(dir);
        if(!file.exists())
            return "";
        if(file.isFile())
        {
            String p = file.getAbsolutePath().replace('\\', '/').replaceAll(orig, uri);
            return (new StringBuilder()).append("['").append(file.getName()).append("','").append(p.replace('\\', '/')).append("'],\n").toString();
        }
        if(file.isDirectory())
        {
            File fileList[] = file.listFiles();
            StringBuffer sb = new StringBuffer();
            String p = file.getAbsolutePath().replace('\\', '/').replaceAll(orig, uri);
            sb.append((new StringBuilder()).append("['").append(file.getName()).append("','").append(p.replace('\\', '/')).append("',\n").toString());
            for(int i = 0; i < fileList.length; i++)
            {
                String childString = generateTigraTree(fileList[i].getPath(), orig, uri);
                sb.append(childString);
            }

            sb.append("],");
            return sb.toString();
        } else
        {
            return "";
        }
    }

    public static void generateTree(String destFile, String dir, String webappDir, String uri)
        throws FileNotFoundException
    {
        PrintWriter pwr = new PrintWriter(new FileOutputStream((new StringBuilder()).append(destFile).append("/treeitems.js").toString()));
        StringBuffer sb = new StringBuffer();
        sb.append((new StringBuilder()).append("var TREE_ITEMS = [").append(generateTigraTree(dir, webappDir, uri)).append("];").toString());
        pwr.println(sb.toString());
        pwr.flush();
        pwr.close();
    }

    public static void main(String args[])
        throws FileNotFoundException
    {
        generateTree("C:/velocitek/java/dist/finance4j.signore/grid", "C:/velocitek/java/dist/finance4j.signore/data", "C:/velocitek/java/dist/finance4j.signore", "http://www.finance4j.com");
    }

    public static Properties readProperties(String filename)
        throws IOException
    {
        if(filename == null)
            throw new InternalError((new StringBuilder()).append("properties file:").append(filename).append(" cannot be null").toString());
        File cfgFile = new File(filename);
        if(cfgFile.exists() && cfgFile.isFile() && cfgFile.canRead())
        {
            FileInputStream inFile = new FileInputStream(cfgFile);
            Properties newProps = new Properties();
            newProps.load(inFile);
            return newProps;
        } else
        {
            return null;
        }
    }

    public static void saveProperties(Properties props, String filename)
        throws IOException
    {
        props.store(new FileOutputStream(filename), "Properties file");
    }

    public static long getLastModified(String filename)
    {
        File cfgFile = new File(filename);
        return cfgFile.lastModified();
    }

    public static synchronized String getLineFromURL(InputStream myInputStream)
    {
        int ch = -1;
        StringBuffer sb = new StringBuffer();
        do
        {
            try
            {
                ch = myInputStream.read();
            }
            catch(IOException e)
            {
                return null;
            }
            if(ch == -1)
                if(sb.length() == 0)
                    return null;
                else
                    return sb.toString();
            if(ch == 10 || ch == 13)
            {
                if(sb.length() > 0)
                    return sb.toString();
            } else
            {
                sb.append((char)ch);
            }
        } while(true);
    }

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/FileUtils);
    private static int i = 0;

}
