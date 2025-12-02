/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {

    // Hash a password
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12)); // cost factor 12
    }

    // Verify password against stored hash
    public static boolean checkPassword(String password, String hash) {
        if (hash == null || !hash.startsWith("$2a$")) {
            throw new IllegalArgumentException("Invalid hash provided");
        }
        return BCrypt.checkpw(password, hash);
    }
}
