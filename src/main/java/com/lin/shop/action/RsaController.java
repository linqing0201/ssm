package com.lin.shop.action;

import java.net.URLDecoder;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.shop.common.FastJsonUtils;
import com.lin.shop.rsa.AESUtils;
import com.lin.shop.rsa.HexUtil;
import com.lin.shop.rsa.RSAUtil;

@Controller
@RequestMapping(value="/rsa")
public class RsaController {

	@RequestMapping(value="getPublicKey")
	@ResponseBody
	public Map<String,Object> getPublicKey(){
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			RSAPublicKey rsap = (RSAPublicKey) RSAUtil.getKeyPair().getPublic();
			String module = rsap.getModulus().toString(16);
			String empoent = rsap.getPublicExponent().toString(16);
			map.put("module", module);
			map.put("empoent", empoent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="decrypt")
	@ResponseBody
	public String decrypt(@RequestParam Map<String,Object> map){
		try {
			String pwd;
			String rsaToAeskey = map.get("rsaToAeskey").toString();
			byte[] en_result = HexUtil.hexStringToBytes(rsaToAeskey);
			byte[] de_result = RSAUtil.decrypt(RSAUtil.getKeyPair().getPrivate(),en_result);
			StringBuffer sb = new StringBuffer();
			sb.append(new String(de_result));
			pwd = sb.reverse().toString();
			System.out.println("=================================");
			pwd = URLDecoder.decode(pwd,"UTF-8");//
			System.out.println(pwd);
			String decryptData = AESUtils.decryptData(pwd, map.get("aesText").toString());
			List<String> result=new ArrayList<String>();
			result.add("hello");
			result.add("world");
			String jsonString = FastJsonUtils.toJSONString(result);
			System.out.println(jsonString);
			String encryptData = AESUtils.encryptData(pwd, jsonString);
			System.out.println(decryptData);
			System.out.println(encryptData);
			return jsonString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
