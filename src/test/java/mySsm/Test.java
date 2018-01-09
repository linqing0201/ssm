package mySsm;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Test {

	public static void main(String[] args) {
		String newPassword = new SimpleHash(
                "md5",
                "123456",
                ByteSource.Util.bytes("admin"+"84012b1f7ab582eb1a0eb46ed08fb5a9"),
                2).toHex();
		System.out.println(newPassword);
	}
}
