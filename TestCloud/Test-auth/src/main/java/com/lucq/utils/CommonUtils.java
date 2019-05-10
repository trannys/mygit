package com.lucq.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CommonUtils {

    private final static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    public static String encodeImageData(byte[] by) throws Exception {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(by);
    }

    public static byte[] decodeImageData(String imageData) throws Exception {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] by = decoder.decodeBuffer(imageData.replaceAll(" ", "+"));
        for (int i = 0; i < by.length; i++) {
            if (by[i] < 0) {
                int tmp96_94 = i;
                byte[] tmp96_92 = by;
                tmp96_92[tmp96_94] = ((byte) (tmp96_92[tmp96_94] + 256));
            }
        }
        return by;
    }

    public static byte[] decodeByteData(String data)
            throws UnsupportedEncodingException {
        return org.apache.commons.codec.binary.Base64.decodeBase64(data);
    }

    public static String decodeData(String data)
            throws UnsupportedEncodingException {
        byte[] textByte = org.apache.commons.codec.binary.Base64.decodeBase64(data);
        String decodeText = new String(textByte, "UTF-8");
        return decodeText;
    }

    public static String encodeData(byte[] data)
            throws UnsupportedEncodingException {
        byte[] textByte = org.apache.commons.codec.binary.Base64.encodeBase64(data);
        String encodeText = new String(textByte, "UTF-8");
        return encodeText;
    }

    public static String bytesToHexString(byte[] b) {
        StringBuilder stringBuilder = new StringBuilder("");
        if ((b == null) || (b.length <= 0)) {
            return null;
        }
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static boolean isExistInArray(Object[] arr, Object... targetValue) {
        for (Object obj : arr) {
            for (Object tar : targetValue) {
                if (obj.equals(tar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static boolean isNumericDecimal(String str) {
        if (isEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*.[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static double convertSourData(String dataStr)
            throws Exception {
        if ((dataStr != null) && (!"".equals(dataStr))) {
            return Double.valueOf(dataStr).doubleValue();
        }
        throw new NumberFormatException("convert error!");
    }

    public static boolean isEmpty(String s) {
        if ((null == s) || ("".equals(s)) || ("".equals(s.trim())) || ("null".equalsIgnoreCase(s))) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Integer s) {
        if ((null == s) || (s.intValue() == 0)) {
            return true;
        }
        return false;
    }

    public static List<String> removeSameItem(List<String> list) {
        List<String> difList = new ArrayList();
        for (String t : list) {
            if ((t != null) && (!difList.contains(t))) {
                difList.add(t);
            }
        }
        return difList;
    }

    public static String getFileNameWithoutExt(String fileName) {
        int position = fileName.lastIndexOf(".");
        return fileName.substring(0, position);
    }

    public static String getFileDotExt(String fileName) {
        int position = fileName.lastIndexOf(".");
        return fileName.substring(position);
    }

    public static String getFileExt(String fileName) {
        if (".".equals(fileName)) {
            return fileName;
        }
        int position = fileName.lastIndexOf(".");
        return fileName.substring(position + 1);
    }

    public static String getInputHtmlUTF8(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
            HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setConnectTimeout(5000);
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                String data = readHtml(inputStream, "UTF-8");
                inputStream.close();
                return data;
            }
        } catch (Exception e) {
            logger.error("The Exception is {}", e);
        }
        return null;
    }

    public static String readNativeFile(String myurl)
            throws IOException {
        BufferedReader in = null;
        in = new BufferedReader(new FileReader(myurl));
        StringBuffer buffer = new StringBuffer();
        String line = " ";
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    public static String getInputHtmlGBK(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
            HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setConnectTimeout(5000);
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                String data = readHtml(inputStream, "GBK");
                inputStream.close();
                return data;
            }
        } catch (Exception e) {
            logger.error("The error is {}", e);
        }
        return null;
    }

    public static String readHtml(InputStream inputStream, String uncode)
            throws Exception {
        InputStreamReader input = new InputStreamReader(inputStream, uncode);
        BufferedReader bufReader = new BufferedReader(input);
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            contentBuf.append(line);
        }
        return contentBuf.toString();
    }

    public static byte[] readInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] by = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(by)) != -1) {
                byteArrayOutputStream.write(by, 0, len);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            logger.error("The error is {}", e);
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                logger.error("The error is {}", e);
            }
        }
        return null;
    }

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    public static BigDecimal plus(double v1, double v2, double v3) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        BigDecimal b3 = new BigDecimal(Double.toString(v3));
        return b1.add(b2).add(b3);
    }

    public static double mul(double v1, double v2) {
        if ((v1 == 0.0D) || (v2 == 0.0D)) {
            return 0.0D;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    public static double scale(double dou) {
        BigDecimal bg = new BigDecimal(dou);
        double f1 = bg.setScale(4, 4).doubleValue();
        return f1;
    }

    public static double scale(double dou, int num) {
        BigDecimal bg = new BigDecimal(dou);
        double f1 = bg.setScale(num, 4).doubleValue();
        return f1;
    }

    public static double div(double v1, double v2) {
        return div(v1, v2, 10);
    }

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, 4).doubleValue();
    }

    public static int randomInt() {
        return new Random().nextInt();
    }

    public static String cutOutString(String str) {
        str = str.replaceAll("<p>", "").replaceAll("</p>", "").replaceAll("&nbsp;", " ").replaceAll("\n", "").replaceAll("\t", "");
        String regex = "images/0x(.{4,5}).png";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            str = str.replaceAll(matcher.group(1), String.valueOf(Character.toChars(Integer.valueOf(matcher.group(1), 16).intValue())));
        }
        String regex1 = "<img(.{50,110})images/0x";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(str);
        while (matcher1.find()) {
            str = str.replaceAll(matcher1.group(1), "").replaceAll("<img", "").replaceAll("images/0x", "");
        }
        String regex2 = ".png(.{15,50})/>";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(str);
        while (matcher2.find()) {
            str = str.replaceAll(matcher2.group(1), "").replaceAll(".png", "").replaceAll("/>", "");
        }
        return str;
    }

    public static Double calculateDistance(Double long1, Double lat1, Double long2, Double lat2) {
        if ((long1 != null) && (lat1 != null) && (long2 != null) && (lat2 != null)) {
            double R = 6378137.0D;
            lat1 = Double.valueOf(lat1.doubleValue() * 3.141592653589793D / 180.0D);
            lat2 = Double.valueOf(lat2.doubleValue() * 3.141592653589793D / 180.0D);
            double a = lat1.doubleValue() - lat2.doubleValue();
            double b = (long1.doubleValue() - long2.doubleValue()) * 3.141592653589793D / 180.0D;

            double sa2 = Math.sin(a / 2.0D);
            double sb2 = Math.sin(b / 2.0D);
            double d = 2.0D * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1.doubleValue()) * Math.cos(lat2.doubleValue()) * sb2 * sb2));

            return Double.valueOf(Math.round(d));
        }
        return null;
    }

    public static List<Map<String, Object>> calculateDistance(List<Map<String, Object>> list, double long1, double lat1) {
        for (Map<String, Object> map : list) {
            Double distance = calculateDistance(Double.valueOf(long1), Double.valueOf(lat1), Double.valueOf(map.get("glon").toString()), Double.valueOf(map.get("glat").toString()));
            map.put("distance", distance);
        }
        return list;
    }

    public static String stringFilter(String str)
            throws PatternSyntaxException {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static String substringReplace(String str) {
        String string = stringFilter(str);
        return string.length() > 128 ? string.substring(string.length() - 128, string.length()) : string;
    }

    public static Date stringToDate(String stringtime) {
        Date datetime = null;
        if (!isEmpty(stringtime)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                datetime = sdf.parse(stringtime);
            } catch (ParseException e) {
                logger.error("The stringToDate is error:{}", e);
            }
        }
        return datetime;
    }

    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }

    public static String cutStartEndComma(String targetStr) {
        if (!isEmpty(targetStr)) {
            String result = targetStr;
            if (result.length() >= 1) {
                if (result.startsWith(",")) {
                    result = result.substring(1);
                }
                if (result.endsWith(",")) {
                    result = result.substring(0, result.length() - 1);
                }
                return result;
            }
            return "";
        }
        return "";
    }

    public static Object getValueByFieldName(Object obj, String fieldName)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method m = obj.getClass().getMethod("get" + getMethodName(fieldName), new Class[0]);
        return m.invoke(obj, new Object[0]);
    }

    public static void setVauleByFieldName(Object obj, String fieldName, Object value)
            throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method m = obj.getClass().getMethod("set" + getMethodName(fieldName), new Class[]{obj.getClass().getDeclaredField(fieldName).getType()});

        Class<?> c = obj.getClass().getDeclaredField(fieldName).getType();
        Object lastValue = value;
        try {
            lastValue = c.getDeclaredMethod("valueOf", new Class[]{String.class}).invoke(c, new Object[]{value});
        } catch (NoSuchMethodException e) {
            lastValue = value;
        }
        m.invoke(obj, new Object[]{lastValue});
    }

    private static String getMethodName(String fieldName) {
        byte[] items = fieldName.getBytes();
        if ((items[0] >= 97) && (items[0] <= 122)) {
            int tmp23_22 = 0;
            byte[] tmp23_21 = items;
            tmp23_21[tmp23_22] = ((byte) (tmp23_21[tmp23_22] - 32));
        }
        return new String(items);
    }

    public static String distinctStrWithComma(String rawStr) {
        String newStr = null;
        if (!isEmpty(rawStr)) {
            newStr = "";
            Set<String> set = new LinkedHashSet();
            String[] array = rawStr.split(",");
            for (String item : array) {
                set.add(item);
            }
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                newStr = newStr + (String) it.next() + ",";
            }
            if (newStr.endsWith(",")) {
                newStr = newStr.substring(0, newStr.length() - 1);
            }
        }
        return newStr;
    }

    public static String getBaseURL(HttpServletRequest request) {
        int endIndex = request.getRequestURL().length() - request.getRequestURI().length() + 1;
        String url = request.getRequestURL().substring(0, endIndex);
        return url;
    }

    public static String randomStr(int length) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int ran = random.nextInt(10);
            if ((i == 0) && (ran == 0)) {
                i--;
            } else {
                str.append(ran);
            }
        }
        return str.toString();
    }

    public static String addStartEndPercentSymbol(String target) {
        if (isEmpty(target)) {
            return null;
        }
        return "%" + target + "%";
    }

    public static String joinSingleQuotesIntoStrWithComma(String str) {
        String result = "";
        if (!isEmpty(str)) {
            String[] array = str.split(",");
            for (int i = 0; i < array.length; i++) {
                result = result + "'" + array[i] + "'";
                if (i < array.length - 1) {
                    result = result + ",";
                }
            }
        }
        return result;
    }

    public static Date change8ClockToZero(Date date) {
        if (date != null) {
            date.setTime(date.getTime() - 28800000L);
            return date;
        }
        return null;
    }

    public static Date change8ClockToMax(Date date) {
        if (date != null) {
            date.setTime(date.getTime() + 57599000L);
            return date;
        }
        return null;
    }

    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap();
        BeanMap beanMap;
        if (bean != null) {
            beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }


    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = new ArrayList();
        if ((objList != null) && (objList.size() > 0)) {
            Map<String, Object> map = null;
            T bean = null;
            int i = 0;
            for (int size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps, Class<T> clazz)
            throws InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList();
        if ((maps != null) && (maps.size() > 0)) {
            Map<String, Object> map = null;
            T bean = null;
            int i = 0;
            for (int size = maps.size(); i < size; i++) {
                map = (Map) maps.get(i);
                bean = clazz.newInstance();
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }


    public static Map bean2Map(Object bean) {
        try {
            Class type = bean.getClass();
            Map returnMap = new HashMap();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }
            return returnMap;
        } catch (Exception e) {
            logger.error("The error is {}", e);
        }
        return null;
    }


    private static Object convertMap(Class type, Map map) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            Object obj = type.newInstance();
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (map.containsKey(propertyName)) {
                    try {
                        Object value = map.get(propertyName);
                        Object[] args = new Object[1];
                        args[0] = value;
                        descriptor.getWriteMethod().invoke(obj, args);
                    } catch (Exception e) {
                        logger.error("The error is {}", e);
                    }
                }
            }
            return obj;
        } catch (Exception e) {
            logger.error("The error is {}", e);
        }
        return null;
    }

    private static TreeMap convertBean(Object bean) {
        Class type = bean.getClass();
        TreeMap returnMap = new TreeMap();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    try {
                        Method readMethod = descriptor.getReadMethod();
                        Object result = readMethod.invoke(bean, new Object[0]);
                        if (result != null) {
                            returnMap.put(propertyName, result);
                        } else {
                            returnMap.put(propertyName, "");
                        }
                    } catch (Exception e) {
                        logger.error("The error is {}", e);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("The error is {}", e);
        }
        return returnMap;
    }


    /**
     * 生成n位随机数字和字母组合序号
     * @param length 生成随机数的长度
     * @return
     */
    public static String generateLetterDigitOrder(int length) {
        String order = "";
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            for (int i = 0; i < length; i++) {
                // 判断输出字母还是数字
                String char_num_const = random.nextInt(2) % 2 == 0 ? "char" : "num";
                if ("char".equalsIgnoreCase(char_num_const)) { // 字符串
                    // 获取大写字母还是小写字母
                    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    order += (char) (choice + random.nextInt(26));
                } else if ("num".equalsIgnoreCase(char_num_const)) { // 数字
                    order += String.valueOf(random.nextInt(10));
                }
            }
        } catch (Exception e) {
            logger.error("The error is {}", e);
        }
        return order;
    }

    /**
     * 生成n位随机数字序号
     * @param length 生成随机数的长度
     * @return
     */
    public static String generateDigitOrder(int length) {
        StringBuffer order = new StringBuffer();
        for (int i = 0; i < length; i++) {
            long randomNum = Math.round(Math.floor(Math.random() * 10.0D));
            order.append(randomNum);
        }
        return order.toString();
    }

    /**
     * 生成n位随机数字和字母组合 + 指定位数随机数 序号
     * @param length 生成随机数的长度
     * @return
     */
    public static String generateComplexOrder(int length, int scale, boolean upperCase, boolean slowerCase) {
        String order = generateLetterDigitOrder(length) + generateDigitOrder(scale);
        if (upperCase) {
            order = StringUtils.isEmpty(order) ? "" : order.toUpperCase();
        }
        if (slowerCase) {
            order = StringUtils.isEmpty(order) ? "" : order.toLowerCase();
        }
        return order;
    }
}