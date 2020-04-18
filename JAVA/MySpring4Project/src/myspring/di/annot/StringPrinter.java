package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component // bean id="stringPrinter" class="" ¿Í °°´Ù.
public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();

	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
