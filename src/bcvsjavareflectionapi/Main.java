/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcvsjavareflectionapi;

import java.lang.reflect.Method;

/**
 *
 * @author bcipriano@gmail.com
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Method[] methods = Main.class.getMethods();
        
        for(Method m : methods) {
            System.out.println(m.getName());
        }
    }
    
    // pedido: static int retornarZero()
    // o aluno enganou-se e escreveu retornarZer0 em vez de retornarZero
    public static int retornarZer0() {
        return 0;
    }
    
    // pedido: static int dobro(int n)
    // neste caso o aluno nao meteu o atributo "int n" na propria funcao
    public static int dobro(int m) {
        int n = 0;
        return n * 2;
    }
    
    // pedido: static int dobro(int n)
    // neste caso esta tudo OK com o protocolo
    // mas a implementacao tem um erro
    public static int somarDoisNumeros(int a, int b) {
        return a + b + 1;
    }
    
}
