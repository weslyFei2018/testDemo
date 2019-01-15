//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.KeyStore;
//import java.util.List;
//import java.util.logging.Logger;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.Header;
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ssl.DefaultHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContexts;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.StringUtils;
//
///**
// * 封装Http请求
// *
// * @author WuShuang
// * @version 1.0
// */
//public class HttpUtil {
//
//	private static Logger log = LoggerFactory.getLogger(HttpUtil.class);
//
//	/**
//	 * 发送get请求
//	 *
//	 * @param url
//	 *            需要转义过的URL
//	 * @param charset
//	 *            返回内容的编码字符集(填写charset后,头信息参数中不要重复设置)
//	 * @param headerParam
//	 *            头信息
//	 **/
//	public static String sendGet(String url, String charset, List<NameValuePair> headerParam) {
//		String result = "";
//		BufferedReader in = null;
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		try {
//			HttpGet httpGet = new HttpGet(url);
//			if (null != headerParam && headerParam.size() != 0) {
//				for (NameValuePair nameValuePair : headerParam) {
//					httpGet.addHeader(nameValuePair.getName(), nameValuePair.getValue());
//				}
//			}
//			if (StringUtils.hasLength(charset)) {
//				httpGet.addHeader("Content-Type", charset);
//			}
//
//			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//			try {
//				Header[] headerList = httpResponse.getAllHeaders();
//				for (Header header : headerList) {
//					StringBuffer sb = new StringBuffer();
//					sb.append(header.getName());
//					sb.append(":");
//					sb.append(header.getValue());
//					System.out.println(sb.toString());
//				}
//				HttpEntity entity = httpResponse.getEntity();
//				if (null != entity) {
//
//					InputStream instream = entity.getContent();
//					try {
//						entity.isChunked();
//						in = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
//						String line;
//						while ((line = in.readLine()) != null) {
//							result += line;
//						}
//					} finally {
//						instream.close();
//					}
//				}
//			} finally {
//				httpResponse.close();
//			}
//		} catch (Exception e) {
//			log.error("发送GET请求出现异常！" + e);
//			e.printStackTrace();
//			return null;
//		} finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//				httpClient.close();
//			} catch (IOException e) {
//				log.error("关闭资源时出现IO异常！" + e);
//				e.printStackTrace();
//				return null;
//			} catch (Exception ex) {
//				log.error("出现异常！" + ex);
//				ex.printStackTrace();
//				return null;
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * 发送post请求
//	 *
//	 * @param url
//	 *            需要转义过的URL
//	 * @param charset
//	 *            返回内容的编码字符集(填写charset后,头信息参数中不要重复设置)
//	 * @param headerParam
//	 *            设置头信息
//	 * @param params
//	 *            设置post的实体参数
//	 **/
//	public static String sendPost(String url, String charset, List<NameValuePair> headerParam, String param) {
//		String result = "";
//		BufferedReader in = null;
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		try {
//			HttpPost httpPost = new HttpPost(url);
//			// 设置头信息
//			if (null != headerParam && headerParam.size() != 0) {
//				for (NameValuePair nameValuePair : headerParam) {
//					httpPost.addHeader(nameValuePair.getName(), nameValuePair.getValue());
//				}
//			}
//			if (StringUtils.hasLength(charset)) {
//				httpPost.addHeader("Content-Type", charset);
//			}
//
//			if (null != param && !"".equals(param)) {
//				StringEntity se = new StringEntity(param, charset);
//				httpPost.setEntity(se);
//			}
//			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//			try {
//				Header[] headerList = httpResponse.getAllHeaders();
//				for (Header header : headerList) {
//					StringBuffer sb = new StringBuffer();
//					sb.append(header.getName());
//					sb.append(":");
//					sb.append(header.getValue());
//					System.out.println(sb.toString());
//				}
//				HttpEntity entity = httpResponse.getEntity();
//				if (null != entity) {
//
//					InputStream instream = entity.getContent();
//					try {
//						entity.isChunked();
//						in = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
//						String line;
//						while ((line = in.readLine()) != null) {
//							result += line;
//						}
//					} finally {
//						instream.close();
//					}
//				}
//			} finally {
//				httpResponse.close();
//			}
//		} catch (Exception e) {
//			log.error("发送POST请求出现异常！" + e);
//			e.printStackTrace();
//			return null;
//		} finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//				httpClient.close();
//			} catch (IOException e) {
//				log.error("关闭资源时出现IO异常！" + e);
//				e.printStackTrace();
//				return null;
//			} catch (Exception ex) {
//				log.error("出现异常！" + ex);
//				ex.printStackTrace();
//				return null;
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * 发送post请求
//	 *
//	 * @param url
//	 *            需要转义过的URL
//	 * @param charset
//	 *            返回内容的编码字符集(填写charset后,头信息参数中不要重复设置)
//	 * @param headerParam
//	 *            设置头信息
//	 * @param params
//	 *            设置post的实体参数
//	 **/
//	public static String sendPost(String url, String charset, List<NameValuePair> headerParam, String param,
//			String mchId, InputStream certInstream) {
//		SSLConnectionSocketFactory sslConnectionSocketFactory = null;
//		// 加载证书
//		try {
//			sslConnectionSocketFactory = initCert(mchId, certInstream);
//		} catch (Exception e) {
//			log.error("加载证书出现异常:{}", e == null ? null : e.getMessage());
//			e.printStackTrace();
//		}
//
//		String result = "";
//		BufferedReader in = null;
//		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
//		try {
//			HttpPost httpPost = new HttpPost(url);
//			// 设置头信息
//			if (null != headerParam && headerParam.size() != 0) {
//				for (NameValuePair nameValuePair : headerParam) {
//					httpPost.addHeader(nameValuePair.getName(), nameValuePair.getValue());
//				}
//			}
//			if (StringUtils.hasLength(charset)) {
//				httpPost.addHeader("Content-Type", charset);
//			}
//
//			if (null != param && !"".equals(param)) {
//				StringEntity se = new StringEntity(param, charset);
//				httpPost.setEntity(se);
//			}
//			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//			try {
//				Header[] headerList = httpResponse.getAllHeaders();
//				for (Header header : headerList) {
//					StringBuffer sb = new StringBuffer();
//					sb.append(header.getName());
//					sb.append(":");
//					sb.append(header.getValue());
//					System.out.println(sb.toString());
//				}
//				HttpEntity entity = httpResponse.getEntity();
//				if (null != entity) {
//
//					InputStream instream = entity.getContent();
//					try {
//						entity.isChunked();
//						in = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
//						String line;
//						while ((line = in.readLine()) != null) {
//							result += line;
//						}
//					} finally {
//						instream.close();
//					}
//				}
//			} finally {
//				httpResponse.close();
//			}
//		} catch (Exception e) {
//			log.error("发送POST请求出现异常！" + e);
//			e.printStackTrace();
//			return null;
//		} finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//				httpClient.close();
//			} catch (IOException e) {
//				log.error("关闭资源时出现IO异常！" + e);
//				e.printStackTrace();
//				return null;
//			} catch (Exception ex) {
//				log.error("出现异常！" + ex);
//				ex.printStackTrace();
//				return null;
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * 加载证书
//	 *
//	 * @param mchId
//	 *            商户ID
//	 * @param certPath
//	 *            证书位置
//	 * @throws Exception
//	 */
//	private static SSLConnectionSocketFactory initCert(String mchId, InputStream instream) throws Exception {
//		// 证书密码，默认为商户ID
//		String key = mchId;
//		// 指定读取证书格式为PKCS12
//		KeyStore keyStore = KeyStore.getInstance("PKCS12");
//		// 读取本机存放的PKCS12证书文件
//		try {
//			// 指定PKCS12的密码(商户ID)
//			keyStore.load(instream, key.toCharArray());
//		} finally {
//			instream.close();
//		}
//		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, key.toCharArray()).build();
//		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
//				new DefaultHostnameVerifier());
//		return sslsf;
//	}
//
//}
