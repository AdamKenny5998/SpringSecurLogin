/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springsecurity.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adam
 */
public class DBUtil {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("com.mycompany_SpringSecurity_war_1.0-SNAPSHOTPU");
    
    public static EntityManagerFactory getEMF() {return EMF;}
}
