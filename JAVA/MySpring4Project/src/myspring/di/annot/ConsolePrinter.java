package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter") //id=consolePrinter
public class ConsolePrinter implements Printer {
	public void print(String message) {
		System.out.println(message);
	}
}
