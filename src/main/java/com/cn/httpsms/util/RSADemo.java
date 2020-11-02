package com.cn.httpsms.util;

import org.apache.geronimo.mail.util.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSADemo {

	public static void createRSA(){//创建公私钥
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(1408);
			KeyPair keyPair=keyPairGenerator.generateKeyPair();
			RSAPublicKey rsaPublicKey=(RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey rsaPrivateKey=(RSAPrivateKey) keyPair.getPrivate();
			//公钥写入文件
			byte[] pub=rsaPublicKey.getEncoded();
			File file=new File("F:/pub.der");
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream pubOut=new FileOutputStream(file);
			pubOut.write(pub, 0, pub.length);
			pubOut.flush();
			pubOut.close();
			//私钥自己选择方式存放，跟加密机没关系
			File file2=new File("F:/pri.der");
			if(!file2.exists()){
				file2.createNewFile();
			}
			ObjectOutputStream ois=new ObjectOutputStream(new FileOutputStream(file2));
			ois.writeObject(rsaPrivateKey);
			ois.close();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 公钥加密
	 * @param data 明文
	 * @return
	 */
	public static String encode(String data){
		String outStr=null;
//		File a = new File("D:/IdeaProjects/storage_box/加密所需/中行实时接口密钥/pub.der");
		File a = new File("D:/pub.der");
//		File a = new File("/home/apay/tomcat8_8180/webapps/ROOT/pub.der");//生产
//		File a = new File("/home/tomcat/tomcat_8280/webapps/ROOT/pub.der");//测试
		byte[] der = new byte[210];//长度是文件大小
		byte[] cer;
		// 从文件读取加密机产生的公钥数据 Der
					
					try {
						FileInputStream ro= new FileInputStream(a);
						ro.read(der);
						ro.close();			
						
						KeyPairGenerator rsa= KeyPairGenerator.getInstance("RSA");
						
						rsa.initialize(1408);
						KeyPair rsak = rsa.generateKeyPair();
						//使用产生的 密钥公钥格式
						cer = rsak.getPublic().getEncoded();
						//将我们读取到的公钥值覆盖到产生的公钥值（也就是保留对应的格式头）
						if((cer.length - der.length)<0){
							//保证
							throw new IllegalArgumentException("软件产生的密钥长度和文件密钥的长度不一致");
						}
						System.arraycopy(der, 0, cer, cer.length - der.length, der.length);
						X509EncodedKeySpec keySpec= new X509EncodedKeySpec(cer);
						KeyFactory keyFactory = KeyFactory.getInstance("RSA");
						PublicKey pk = keyFactory.generatePublic(keySpec);
						System.out.println("pk"+pk);
						// 获取公钥后加密
						Cipher cipher = Cipher.getInstance("RSA");
					    cipher.init(Cipher.ENCRYPT_MODE, pk);
					    byte[] enc = cipher.doFinal(data.getBytes("UTF-8"));
					    outStr=new String(Hex.encode(enc),"ISO-8859-1").toUpperCase();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeySpecException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalBlockSizeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BadPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		return outStr;
	}
	/**
	 * 私钥解密
	 * @data 密文
	 * @return
	 */
	public static String decode(String data){
		String outStr=null;
		File a = new File("D:/pri.der");
//		File a = new File("/home/apay/tomcat8_8180/webapps/ROOT/pri.der");//生产
//		File a = new File("/home/tomcat/tomcat_8280/webapps/ROOT/pri.der");//测试
					try {
						RSAPrivateKey pri=null;
						ObjectInputStream in=null;
						in=new ObjectInputStream(new FileInputStream(a));
						pri=(RSAPrivateKey)in.readObject();
						PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(pri.getEncoded());
						KeyFactory keyFactory=KeyFactory.getInstance("RSA");
						PrivateKey privateKey=keyFactory.generatePrivate(pkcs8EncodedKeySpec);
						Cipher cipher=Cipher.getInstance("RSA");
						cipher.init(Cipher.DECRYPT_MODE,privateKey);
					    byte[] enc = cipher.doFinal(Hex.decode(data));
					    outStr=new String(enc,"UTF-8");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeySpecException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalBlockSizeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BadPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		return outStr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		createRSA();
//		Scanner sc=new Scanner(System.in);

//		String str=sc.next();
		String str = "abcdefghig";
//		String afterEncode=encode(str);
		String afterEncode="05B3EFAC133F5FE406E3F4464FD0DA643C34E9CDA58179F12B4AD4A89CE08304800C757FBBE0E3F3FFF6DFC3052A9F01106A65DEA30ECD436198AFF00DFE7D709D16640E5BC863748303A9CA15EC6D6C7DF551D46A4926B68C7EC055204F28E957B074FA6065B7F9828842E6E363212F0EF252B7E3BF0E2FC100AD3A94BA3F6F6E0DF8BC1F05390518C107F6177B6C83439DF52569E010B20297C025519925B35091083F335E4183A014B747F4587152";
		System.out.println("加密后数据："+afterEncode);
		String afterDecode=decode(afterEncode);
		System.out.println("解密后数据:"+afterDecode);
	}

	/**
	 * 把16进制字符串转换成字节数组
	 * @param hex
	 * @return byte[]
	 */
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}
	private static int toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

}
