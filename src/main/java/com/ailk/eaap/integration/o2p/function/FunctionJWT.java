package com.ailk.eaap.integration.o2p.function;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import com.ailk.eaap.op2.serviceagent.auth.bo.JsonObject;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.greenpineyu.fel.function.CommonFunction;

public class FunctionJWT extends CommonFunction {

	private static final Logger LOG = Logger.getLog(FunctionJWT.class);
	private static final String ALG_256 = "256";
	private static final String ALG_384 = "384";
	private static final String ALG_512 = "512";
	private static final String ALG = "alg";
	private static final String TYP = "typ";
	private static final String JWT = "JWT";
	
	@Override
	public String getName() {
		return "jwt";
	}

	@Override
	public Object call(Object[] args) {
		
		if (args != null && args.length == 3) {
			
			String alg = args[0].toString();
			String secretKey = "";
			if(args[1] != null) {
				
				secretKey =  args[1].toString();
			}
			String payload = args[2].toString();
			
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("input param, SignatureAlgorithm:{0}, secretk:{1}, payload:{2}", alg, secretKey, payload);
			}
			
			String jwtResult = getJwt(alg, secretKey, payload);
			
			return jwtResult;
		} else {
			throw new BusinessException(9999, "fn:jwt function format error, " + args.toString());
		}
	}

	//payload 通过jsonObject传进来已经压缩过了
	private String getJwt(String alg, String secretKey, String payload) {

		Map<String, Object> header = new HashMap<String, Object>();

	    if(LOG.isDebugEnabled()) {
	    	
	    	LOG.debug("final payload {0}",payload);
	    }
	    String jwt = "";
	    SignatureAlgorithm sg = null;
	    
	    if(alg.toUpperCase().startsWith("HS")) {
	    	
	    	jwt = hsSign(alg, secretKey, payload, header, sg);
	    } else if(alg.toUpperCase().startsWith("RS")) {
	    	
	    	jwt = rsSign(alg, secretKey, payload, header, sg);
	    }
	    
		return jwt;
	}


	private String rsSign(String alg, String secretKey, String payload,
			Map<String, Object> header, SignatureAlgorithm sg) {
		String jwt;
		if(alg.contains(ALG_256)) {
			
			sg = SignatureAlgorithm.RS256;
		} else if(alg.contains(ALG_384)) {
			
			sg = SignatureAlgorithm.RS384;
		} else if(alg.contains(ALG_512)) {
			
			sg = SignatureAlgorithm.RS512;
		}
		Key key = getPrivateKeyByStr(secretKey);
		
		header.put(ALG, sg);
		header.put(TYP, JWT);
		jwt = Jwts.builder().setHeader(header).setPayload(payload)
				.signWith(SignatureAlgorithm.RS256, key).compact();
		return jwt;
	}

	private String hsSign(String alg, String secretKey, String payload,
			Map<String, Object> header, SignatureAlgorithm sg) {
		String jwt;
		if(alg.contains(ALG_256)) {
			
			sg = SignatureAlgorithm.HS256;
		} else if(alg.contains(ALG_384)) {
			
			sg = SignatureAlgorithm.HS384;
		} else if(alg.contains(ALG_512)) {
			
			sg = SignatureAlgorithm.HS512;
		}
		
		header.put(ALG, sg);
		header.put(TYP, JWT);
		
		jwt = Jwts.builder().setHeader(header).setPayload(payload)
				.signWith(sg, TextCodec.BASE64.encode(secretKey)).compact();
		return jwt;
	}
	
	public PrivateKey getPrivateKeyByStr(String privateKeyStr)  {
		
		PrivateKey privateKey = null;
		PKCS8EncodedKeySpec priPKCS8;
		try {
			
			priPKCS8 = new PKCS8EncodedKeySpec(TextCodec.BASE64URL.decode(privateKeyStr));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			privateKey = keyf.generatePrivate(priPKCS8);
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			
			e.printStackTrace();
		}
		
		return privateKey;
	}
}