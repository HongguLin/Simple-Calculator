
/*
 * SimpleTokenizer
 * Eric McCreath 2017
 */

public class SimpleTokenizer extends Tokenizer {

	String text; // the text to be tokenizer
	int pos; // position the tokenizer is currently pointing at.
	Object current; // the current token that has just been tokenized, noting
					// the "pos" will point just after the text of this token

	public SimpleTokenizer(String text) {
		this.text = text;
		pos = 0;
		next();
	}

	@Override
	boolean hasNext() {
		return current != null;
	}

	@Override
	Object current() {
		return current;
	}

	@Override
	void next() {
		char c = 0;
		int textlen = text.length();

		consumewhite();
		if (pos < textlen)
			c = text.charAt(pos);
		
		
		// consume the white space

	
		
		// modify this code
		

		if (pos >= textlen) {
			current = null;
			return;
		} else if (c == '(') {
			pos++;
			current = "(";
			return;
		} else if (c == ')'){
			pos++;
			current = ")";
			return;
		} else if (c == '+'){
			pos++;
			current = "+";
			return;
		} else if (c == '-'){
			pos++;
			current = "-";
			return;
		} else if (c == '*'){
			pos++;
			current = "*";
			return;
		} else if (c == '/'){
			pos++;
			current = "/";
			return;
		} else if (c == ','){
			pos++;
			current = ",";
			return;
		} else if (c == 'X'){
			pos++;
			current = "X";
			return;
		} else if (Character.isDigit(c)) {
			String res = "" + c;
			pos++;
			c = text.charAt(pos);
			while (pos < textlen && Character.isDigit(c)) {
				res += c;
				pos++;
				c = text.charAt(pos);
			}
			Integer x = Integer.valueOf(res);
			current = x;
			return;
		}

	}

	private void consumewhite() {
		while (pos < text.length() && (text.charAt(pos) == ' ' || text.charAt(pos) == '\n'))
			pos++;
	}

}
