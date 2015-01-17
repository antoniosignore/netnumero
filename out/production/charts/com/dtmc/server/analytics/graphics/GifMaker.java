// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GifMaker.java

package com.dtmc.server.analytics.graphics;

import java.awt.*;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GifMaker
{

    public GifMaker()
    {
        this(null, null);
    }

    public GifMaker(OutputStream outputStream, Image image)
    {
        setOutputStream(outputStream);
        setImage(image);
    }

    private void cflush(int n)
    {
        WriteByte(n);
        for(int i = 0; i < n; i++)
            WriteByte(code_buffer[i]);

    }

    private void compressImage(int data[], int min_code_size, int nbits)
    {
        int newcode[] = new int[5003];
        int oldcode[] = new int[5003];
        if(min_code_size == 1)
            min_code_size = 2;
        WriteByte(min_code_size);
        int i;
        curbit = i = 0;
        initLZW(min_code_size);
        write_code(clear_code);
        int suffix_char;
        int prefix_code = suffix_char = data[i++];
label0:
        do
        {
            if(i < nbits)
            {
                if(i % 1000 == 0)
                    progressBar("compressing image", nbits, i, Color.green);
                suffix_char = data[i++];
                int hx = (prefix_code ^ suffix_char << 5) % 5003;
                int d = 1;
                do
                {
                    if(stack[hx] == 0)
                    {
                        write_code(prefix_code);
                        d = free_code;
                        if(free_code <= 4095)
                        {
                            oldcode[hx] = prefix_code;
                            newcode[hx] = suffix_char;
                            stack[hx] = free_code;
                            free_code++;
                        }
                        if(d == max_code)
                            if(code_size < 12)
                            {
                                code_size++;
                                max_code <<= 1;
                            } else
                            {
                                write_code(clear_code);
                                initLZW(min_code_size);
                            }
                        prefix_code = suffix_char;
                        continue label0;
                    }
                    if(oldcode[hx] == prefix_code && newcode[hx] == suffix_char)
                    {
                        prefix_code = stack[hx];
                        continue label0;
                    }
                    if(++hx >= 5003)
                        hx -= 5003;
                } while(true);
            }
            write_code(prefix_code);
            write_code(eof_code);
            if(curbit > 0)
                cflush((curbit + 7) / 8);
            cflush(0);
            return;
        } while(true);
    }

    private void dither(int p32[], int p8[], int rmap[], int gmap[], int bmap[], int w, int h)
    {
        int ip = 0;
        int op = 0;
        int pwide3 = w * 3;
        int imax = h - 1;
        int jmax = w - 1;
        for(int i = 0; i < 256; i++)
        {
            rmap[i] = ((i << 0 & 0xe0) * 255 + 112) / 224;
            gmap[i] = ((i << 3 & 0xe0) * 255 + 112) / 224;
            bmap[i] = ((i << 6 & 0xc0) * 255 + 96) / 192;
        }

        int thisline[] = new int[pwide3];
        int nextline[] = new int[pwide3];
        for(int j = 0; j < pwide3; j += 3)
        {
            nextline[j + 0] = (p32[ip] & 0xff0000) >> 16;
            nextline[j + 1] = (p32[ip] & 0xff00) >> 8;
            nextline[j + 2] = p32[ip] & 0xff;
            ip++;
        }

        for(int i = 0; i < h; i++)
        {
            if(i % 100 == 0)
                progressBar("Dithering HTMLImage", h, i, Color.blue);
            int tmpptr[] = thisline;
            thisline = nextline;
            nextline = tmpptr;
            int j;
            if(i != imax)
                for(j = 0; j < pwide3; j += 3)
                {
                    nextline[j + 0] = (p32[ip] & 0xff0000) >> 16;
                    nextline[j + 1] = (p32[ip] & 0xff00) >> 8;
                    nextline[j + 2] = p32[ip] & 0xff;
                    ip++;
                }

            j = 0;
            int thisptr = 0;
            int nextptr = 0;
            for(; j < w; j++)
            {
                int r1 = thisline[thisptr++];
                int g1 = thisline[thisptr++];
                int b1 = thisline[thisptr++];
                if(r1 < 0)
                    r1 = 0;
                if(r1 > 255)
                    r1 = 255;
                if(g1 < 0)
                    g1 = 0;
                if(g1 > 255)
                    g1 = 255;
                if(b1 < 0)
                    b1 = 0;
                if(b1 > 255)
                    b1 = 255;
                int val = (r1 & 0xe0) >> 0 | (g1 & 0xe0) >> 3 | (b1 & 0xc0) >> 6;
                p8[op] = val;
                op++;
                r1 -= rmap[val];
                g1 -= gmap[val];
                b1 -= bmap[val];
                if(j != jmax)
                {
                    thisline[thisptr + 0] += (r1 * 7) / 16;
                    thisline[thisptr + 1] += (g1 * 7) / 16;
                    thisline[thisptr + 2] += (b1 * 7) / 16;
                }
                if(i == imax)
                    continue;
                nextline[nextptr + 0] += (r1 * 5) / 16;
                nextline[nextptr + 1] += (g1 * 5) / 16;
                nextline[nextptr + 2] += (b1 * 5) / 16;
                if(j > 0)
                {
                    nextline[nextptr - 3] += (r1 * 3) / 16;
                    nextline[nextptr - 2] += (g1 * 3) / 16;
                    nextline[nextptr - 1] += (b1 * 3) / 16;
                }
                if(j != jmax)
                {
                    nextline[nextptr + 3] += r1 / 16;
                    nextline[nextptr + 4] += g1 / 16;
                    nextline[nextptr + 5] += b1 / 16;
                }
                nextptr += 3;
            }

        }

    }

    public void generate()
    {
        if(myImage == null)
        {
            return;
        } else
        {
            save(myImage);
            return;
        }
    }

    public void generate(int data[], int width, int height)
    {
        if(myImage == null)
        {
            return;
        } else
        {
            save(data, width, height);
            return;
        }
    }

    public byte[] getByteArray()
    {
        if(myImage == null)
            return (byte[])null;
        if(bytesInArray == 0)
            generate();
        byte newBytes[] = new byte[bytesInArray];
        for(int i = 0; i < bytesInArray; i++)
            newBytes[i] = byteArray[i];

        return newBytes;
    }

    public Image getImage()
    {
        return myImage;
    }

    public OutputStream getOutputStream()
    {
        return myOutputStream;
    }

    public int getSize()
    {
        if(myImage == null)
            return 0;
        if(bytesInArray == 0)
            generate();
        return bytesInArray;
    }

    private void initLZW(int input_code_size)
    {
        stack = new int[8192];
        set_code_size = input_code_size;
        code_size = set_code_size + 1;
        clear_code = 1 << set_code_size;
        eof_code = clear_code + 1;
        free_code = clear_code + 2;
        max_code = 1 << code_size;
        max_code_size = 2 * clear_code;
        for(int i = 0; i < 5003; i++)
            stack[i] = 0;

    }

    private void progressBar(String msg, int total, int soFar, Color c)
    {
        if(myProgressBar == null)
        {
            return;
        } else
        {
            Graphics g = myProgressBar.getGraphics();
            g.setColor(c);
            g.fillRect(0, 0, (myProgressBar.getSize().width * soFar) / total, myProgressBar.getSize().height);
            return;
        }
    }

    private void save(int dat8[], int red[], int grn[], int blu[], int w, int h)
    {
        byteArray = new byte[w * h];
        code_buffer = new byte[260];
        outpol = new byte[1];
        int nc = 255;
        WriteByte(71);
        WriteByte(73);
        WriteByte(70);
        WriteByte(56);
        WriteByte(55);
        WriteByte(97);
        WriteByte(w & 0xff);
        WriteByte(w >> 8 & 0xff);
        WriteByte(h & 0xff);
        WriteByte(h >> 8 & 0xff);
        WriteByte(nc);
        WriteByte(0);
        WriteByte(0);
        for(int i = 0; i < 256; i++)
        {
            WriteByte(red[i]);
            WriteByte(grn[i]);
            WriteByte(blu[i]);
        }

        WriteByte(44);
        WriteByte(0);
        WriteByte(0);
        WriteByte(0);
        WriteByte(0);
        WriteByte(w & 0xff);
        WriteByte(w >> 8 & 0xff);
        WriteByte(h & 0xff);
        WriteByte(h >> 8 & 0xff);
        WriteByte(nc & 7);
        compressImage(dat8, (nc & 7) + 1, w * h);
        WriteByte(59);
    }

    private void save(int dat32[], int w, int h)
    {
        int dat8[] = new int[w * h];
        int red[] = new int[256];
        int grn[] = new int[256];
        int blu[] = new int[256];
        byte c[] = new byte[1];
        dither(dat32, dat8, red, grn, blu, w, h);
        save(dat8, red, grn, blu, w, h);
    }

    private void save(Image img)
    {
        int imgW = img.getWidth(null);
        int imgH = img.getHeight(null);
        int dat32[] = new int[imgW * imgH];
        PixelGrabber grab = new PixelGrabber(img, 0, 0, imgW, imgH, dat32, 0, imgW);
        try
        {
            grab.grabPixels();
        }
        catch(InterruptedException e)
        {
            if(logger.isInfoEnabled())
                logger.info("exception:", e);
        }
        save(dat32, imgW, imgH);
    }

    public void setImage(Image image)
    {
        myImage = image;
        bytesInArray = 0;
    }

    public void setOutputStream(OutputStream outputStream)
    {
        myOutputStream = outputStream;
    }

    public void setProgressBar(Component p)
    {
        myProgressBar = p;
    }

    public void write()
        throws IOException
    {
        if(myOutputStream == null)
            return;
        if(myImage == null)
            return;
        if(bytesInArray == 0)
            generate();
        myOutputStream.write(byteArray, 0, bytesInArray);
        myOutputStream.flush();
    }

    private void write_code(int code)
    {
        last_byte = curbit >> 3;
        lastbit = curbit & 7;
        if(last_byte >= 254)
        {
            cflush(last_byte);
            code_buffer[0] = code_buffer[last_byte];
            curbit = lastbit;
            last_byte = 0;
        }
        if(lastbit > 0)
        {
            long temp = (long)code << lastbit | (long)code_buffer[last_byte];
            code_buffer[last_byte] = (byte)(int)temp;
            code_buffer[last_byte + 1] = (byte)(int)(temp >> 8);
            code_buffer[last_byte + 2] = (byte)(int)(temp >> 16);
        } else
        {
            code_buffer[last_byte] = (byte)code;
            code_buffer[last_byte + 1] = (byte)(code >> 8);
        }
        curbit += code_size;
    }

    private void WriteByte(int v)
    {
        byteArray[bytesInArray] = (byte)v;
        bytesInArray++;
    }

    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/graphics/GifMaker);
    OutputStream myOutputStream;
    Image myImage;
    byte byteArray[];
    int bytesInArray;
    Component myProgressBar;
    static final int RMASK = 224;
    static final int RSHIFT = 0;
    static final int GMASK = 224;
    static final int GSHIFT = 3;
    static final int BMASK = 192;
    static final int BSHIFT = 6;
    static final int MAX_LZW_BITS = 12;
    static final int TABLE_SIZE = 5003;
    static final int LARGEST_CODE = 4095;
    byte code_buffer[];
    int stack[];
    int code_size;
    int set_code_size;
    int free_code;
    int max_code;
    int max_code_size;
    int clear_code;
    int eof_code;
    int curbit;
    int lastbit;
    int get_done;
    int last_byte;
    int return_clear;
    byte outpol[];

}
