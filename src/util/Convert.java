package util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Convert {
    /**
     * 定义一个转换中文字符编码方法，以解决提交表单中可能产生的中文乱码
     */
    public static String toChinese(String str){
        if(str==null) str="";
        else
            try{
                str=new String(str.getBytes("ISO-8859-1"),"utf-8");
            }catch(UnsupportedEncodingException e){
                str="";
                e.printStackTrace();
            }
        return str;
    }

    /**
     * 将String型数据转换为int型数据的方法
     */
    public static int strToint(String str){
        if(str==null||str.equals(""))
            str="0";
        int i=0;
        try{
            i=Integer.parseInt(str);
        }catch(NumberFormatException e){
            i=0;
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 将String型数据转换为URL型数据的方法
     */
    public static String StrtoURL(String str){
        if(str==null||str.equals("")){
            str="";
        }
        else{
            try {
                str=URLEncoder.encode(str,"utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }//解URL编码
            str=toChinese(str);//转换编码，解决中文乱码问题
        }
        return str;
    }
    /**
     * 将URL型数据转换为String型数据的方法
     */
    public static String URLtoStr(String str){
        if(str==null||str.equals("")){
            str="";
        }
        else{
            try {
                str=URLDecoder.decode(str,"utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }//解URL编码
            str=toChinese(str);//转换编码，解决中文乱码问题
        }
        return str;
    }



}

