package com.caohongtao301.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/** 
* @ClassName: CheckCodeServlet 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:19:06 
*  
*/
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int width = 100;
        int height = 50;

        //1.����һ�������ڴ���ͼƬ(��֤��ͼƬ����)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);


        //2.����ͼƬ
        //2.1 ��䱳��ɫ
        Graphics g = image.getGraphics();//���ʶ���
        g.setColor(Color.PINK);//���û�����ɫ
        g.fillRect(0,0,width,height);

        //2.2���߿�
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1,height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //��������Ǳ�
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //��ȡ�ַ�
            char ch = str.charAt(index);//����ַ�
            sb.append(ch);

            //2.3д��֤��
            g.drawString(ch+"",width/5*i,height/2);
        }
        String checkCode_session = sb.toString();
        //����֤�����session
        request.getSession().setAttribute("checkCode_session",checkCode_session);

        //2.4��������
        g.setColor(Color.GREEN);

        //������������

        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }


        //3.��ͼƬ�����ҳ��չʾ
        ImageIO.write(image,"jpg",response.getOutputStream());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}