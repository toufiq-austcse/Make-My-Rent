package security;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordHash {
	
	public String getHashPassword(String password) {
		return BCrypt.withDefaults().hashToString(12, password.toCharArray());
	}
	
	public Boolean verifyPassword(String password,String bcryptHashString) {
		return BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString).verified;
	}
}
