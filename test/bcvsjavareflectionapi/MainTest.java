/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcvsjavareflectionapi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    public boolean findMethodInClass(String methodName, Class c) {
        boolean found = true;
        try {
            // procurar o methodName, sem argumentos
            Method m = c.getMethod(methodName, (Class<?>[]) null);
        }
        catch(NoSuchMethodException e) {
            found = false;
        }
        return found;
    }
    
    @Test
    public void test_MainMethod() {
        Class c = Main.class;
        // getMethod() -> inclui os metodos herdados
        // getDeclaredMethods() -> apenas os que sao declarados nesta classe
        // nota: ambas apenas dao os metodos public!
        Method[] methods = c.getDeclaredMethods();
        if(methods.length < 4) {
            fail("Ainda nao implementou todas as funcoes pedidas.");
        }
    }
    
    @Test
    public void test_RetornarZero() {
        boolean found = true;
        Method m = null;
        Class c = Main.class;
        try {
            // procurar o methodName, com 1 argumento int n
            m = c.getDeclaredMethod("retornarZero", (Class<?>[]) null);
        }
        catch(NoSuchMethodException e) {
            found = false;
        }
        
        if(!found) {
            fail("O metodo retornarZero() nao foi encontrado na sua classe Main.");
        }
        
        // De seguida vem o codigo para chamar o metodo
        // (quando existente)
        // e verificar o valor retornado
        
        try {
            
            m.setAccessible(true); // hack
            
            Object o = m.invoke(Main.class.newInstance()); // = retornarZero()
            
            int res = Integer.parseInt(o.toString());

            assertEquals(0, res);
            
            //System.out.println("Res: " + o);
        }
        catch(IllegalAccessException | InvocationTargetException | InstantiationException e) {
            fail("REVER");
        }
        
    }
    
    @Test
    public void test_Dobro() {
        Class c = Main.class;
        boolean found = true;
        Method m = null;
        try {
            // procurar o methodName, com 1 argumento int n
            m = c.getDeclaredMethod("dobro", int.class);
        }
        catch(NoSuchMethodException e) {
            found = false;
        }
        
        if(!found) {
            fail("O metodo dobro(int n) nao foi encontrado na sua classe Main.");
        }
        
        // De seguida vem o codigo para chamar o metodo
        // (quando existente)
        // e verificar o valor retornado
        
        try {
            
            m.setAccessible(true); // hack
            Object o = m.invoke(Main.class.newInstance(), 1); // dobro de 1
            
            int res = Integer.parseInt(o.toString());

            assertEquals(2, res);
            
            //System.out.println("Res: " + o);
        }
        catch(IllegalAccessException e) {
            fail("REVER");
        }
        catch(InvocationTargetException e) {
            fail("REVER");
        }
        catch(InstantiationException e) {
            fail("REVER");
        }
    }
    
    @Test
    public void test_SomarDoisNumeros() {
        Class c = Main.class;
        boolean found = true;
        Method m = null;
        try {
            // procurar o methodName, com 1 argumento int n
            m = c.getDeclaredMethod("somarDoisNumeros", int.class, int.class);
        }
        catch(NoSuchMethodException e) {
            found = false;
        }
        
        if(!found) {
            fail("Nao foi encontrado o metodo somarDoisNumeros(int a, int b)");
        }
        
        // De seguida vem o codigo para chamar o metodo
        // (quando existente)
        // e verificar o valor retornado
     
        try {
            
            m.setAccessible(true); // hack
            Object o = m.invoke(Main.class.newInstance(), 1, 3); // somarDoisNumeros(1, 3)

            int res = Integer.parseInt(o.toString());

            assertEquals(4, res);
            
            // System.out.println("Res: " + o);
        }
        catch(IllegalAccessException e) {
            fail("REVER");
        }
        catch(InvocationTargetException e) {
            fail("REVER");
        }
        catch(InstantiationException e) {
            fail("REVER");
        }
    }
}
