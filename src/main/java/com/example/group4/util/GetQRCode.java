package com.example.group4.util;

import com.example.group4.bean.student.ex.BookEX;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.bouncycastle.jcajce.provider.digest.MD2;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import static com.google.zxing.client.j2se.MatrixToImageWriter.toBufferedImage;

public class GetQRCode {
    public void getQRCodePicture(BookEX bookEX,HttpServletResponse response){
        int width=600;
        int height=600;
       // String type="png";
        String content="书的Id:"+bookEX.getId()+"  书名:"+bookEX.getName()+"  书的作者:"+bookEX.getAuthor()+"  书的出版社:"+bookEX.getPublisher()+"  书的出版时间:"+bookEX.getPublish_time()+"  书的所在位置:"+bookEX.getAddress()+"  书是否被借出:"+bookEX.getStatus()+"  书的价格:"+bookEX.getPrice();
        HashMap hints=new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");//设置字符集
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);//设置容错等级
        hints.put(EncodeHintType.MARGIN,2);//设置二维码边距
        try {//生成二维码，传入各种属性
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width,height,hints);
            BufferedImage image = toBufferedImage(bitMatrix);
            //转换成png格式的IO流
            try {
                ImageIO.write(image, "png", response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (WriterException e) {
            e.printStackTrace();
        }


    }

}
