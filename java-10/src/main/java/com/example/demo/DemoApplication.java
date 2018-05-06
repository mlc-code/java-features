package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



    @Override
    public void run(String... args) throws Exception {
        example();
    }


	private void example(){
	    var numer = getInt();
	    var caracteres = getString();
	    var flag = getBoolean();
	    System.out.println("caracteres =>" + caracteres);
        System.out.println("integer =>" + numer);
        System.out.println("boolean =>" + flag);
    }

    private int getInt(){
	    var resultado =1;
	    return  resultado;
    }

    private String getString(){
        var resultado ="hola mundo";
        return  resultado;
    }

    private boolean getBoolean(){
        var resultado =true;
        return  resultado;
    }

}
