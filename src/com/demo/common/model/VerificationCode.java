package com.demo.common.model;

import com.demo.common.model.base.BaseVerificationCode;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.Date;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class VerificationCode extends BaseVerificationCode<VerificationCode> {
	public static final VerificationCode dao = new VerificationCode().dao();

	public boolean saveVerifyCode(String mobile, String code) {
		Record record = new Record().set("mobile",mobile)
				.set("code",code)
				.set("create_time",new Date());
		return Db.save("verification_code",record);
	}

	public VerificationCode verifyCode(String mobile, String code) {
		return dao.findFirst("select * from verification_code where mobile = ? and code = ?",mobile,code);
	}

}