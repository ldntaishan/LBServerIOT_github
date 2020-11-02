package com.cn.httpsms.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * 中行提供访问加密机方法
 */
public class SocketIO
{
    private Socket h;
    private InputStream is;
    private BufferedOutputStream os;
    public boolean ok;
    public String conerrmsg;
    private int maxSize = 1000;

    public SocketIO()
    {
        ok = false;
        conerrmsg = null;
    }

    /**
     * 连接加密机
     * @param ip
     * @param port
     * @param timeOut
     * @return
     * @throws Exception
     */
    public boolean connectHSM(String ip, int port,int timeOut) throws Exception
    {
        try
        {
            h = new Socket();
            h.connect(new InetSocketAddress(ip, port), 500);
//            h.setSoLinger(true, 0);
            h.setSoTimeout(timeOut);
            is =h.getInputStream();

            os = new BufferedOutputStream(h.getOutputStream());
            ok = true;
        }
        catch(SocketException e)
        {
            ok = false;
            conerrmsg = (new StringBuilder("Possible Reason\uFF1A")).append(e.getMessage()).toString();
            throw e;
        }
        return true;
    }

    public byte[] HSMCmd(byte in[]) throws Exception
    {
//        String outstr = null;
        byte [] outstr;
        //System.out.println("in:"+new String(in)+" length"+in.length);
        SendToHSM(in);
        System.out.println(in.length);
        try
        {
            outstr = ReceFromHSM();
        }
        catch(SocketException e)
        {
            throw e;
        }
        catch(Exception e)
        {
            throw new SocketException("\u901A\u8BAF\u5931\u8D25!");
        }
        //System.out.println(outstr);
        return outstr;
    }
    /**
     * 发送消息
     * @param str
     * @throws IOException
     */
    private void SendToHSM(byte str[]) throws IOException
    {
        os.write(str);
        os.flush();
    }
    /**
     * 字节组转16进制字符串
     * @param b
     *
     * @return
     *
     */

    public static   String byte2hex(byte[] b)
    {
        String hs = "";

        String stmp = "";

        for (int n = 0; n < b.length; n++)
        {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

            if (stmp.length() == 1)
            {
                hs = hs + "0" + stmp;
            }
            else
            {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
    /**
     * 接收消息
     * @return
     * @throws Exception
     */
    private byte[] ReceFromHSM() throws Exception
    {
        //int i = 0;
        String outStr = "";
        byte[] tmp;
        try
        {
            byte out1[] = new byte[2];
            is.read(out1);
            System.out.println(out1[0]);
            System.out.println(out1[1]);
            int len=Integer.parseInt(byte2hex(out1),16);
            System.out.println(len);
//            String[] tmp = this.longDataDeal(len);
            tmp = this.longDataDeal(len);
//            for(int i = 0;tmp[i]!= null;i++)
//            {
//            	outStr += tmp[i];
//            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new SocketException("\u63A5\u6536\u6570\u636E\u5931\u8D25!");
        }
        return tmp;
    }
    private byte[] longDataDeal(int len) throws IOException
    {
//    	String[] tmp = new String[maxSize];
//    	int i = 0;
//    	boolean flag = (len > maxSize);
//    	while(flag)
//    	{
//    		byte out[] = new byte[maxSize];
//    		is.read(out);
//    		tmp[i] = new String(out,"GBK");
//    		len = len - maxSize;
//    		i = i + 1;
//    		flag = (len > maxSize);
//    	}
        byte out[] = new byte[len];
        is.read(out);
//		tmp[i] = new String(out,"GBK");
        return out;
    }
    public void allClose() throws IOException
    {
        try
        {
            is.close();
            os.close();
            h.close();
        } catch (IOException e)
        {
            throw e;
        }
    }
}
