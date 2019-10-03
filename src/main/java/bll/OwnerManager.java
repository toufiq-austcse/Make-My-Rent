package bll;

import java.security.MessageDigest;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dao.OwnerDao;
import models.Owner;
import security.PasswordHash;

public class OwnerManager {
	private OwnerDao ownerDao = new OwnerDao();
	private PasswordHash passwordHash = new PasswordHash();
	
	public boolean insertOwner(Owner owner) {
		owner.setPassword(passwordHash.getHashPassword(owner.getPassword()));
		return this.ownerDao.insertOwner(owner) == 1;
	}
	public Owner getOwner(Owner owner) {
		return this.ownerDao.getOwner(owner);
	}
	



}
