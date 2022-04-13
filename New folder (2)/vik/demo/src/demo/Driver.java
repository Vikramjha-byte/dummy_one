package demo;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 10; // primitive
		Integer value = i; // auto boxing
		int data = value; // auto unboxing
		Double num = 100.5;
		Float fl = 100.5f;
		Character character = 'A';
		System.out.println(character);
		String name = "ABZaz09";

		System.out.println(name);
		System.out.println(name.codePointAt(0));
		System.out.println(name.codePointAt(1));
		System.out.println(name.codePointAt(2));
		System.out.println("code point of 'a':" + name.codePointAt(3));
		System.out.println("code point of 'z':" + name.codePointAt(4));

		System.out.println("code point of '0':" + name.codePointAt(5));
		System.out.println("code point of '9':" + name.codePointAt(6));
		String name2 = "Capgemini"; // immutable string
		name2 = name2 + " India"; // new memory will be allocated to store new string
		System.out.println("name2:" + name2);
		System.out.println(name2.charAt(1));
		System.out.println(name2.length());
		String str = new String("Hello");
		String str2 = "Hello";
		System.out.println("Hello".compareTo("hello"));
		name2 = "hello";
		System.out.println(name2.compareToIgnoreCase("Hello"));
		System.out.println(name2.toUpperCase());
		name2 = name2.toUpperCase();
		System.out.println(name2);

		System.out.println(name2 + " every one !");
		System.out.println(name2.concat("Every one !"));
		System.out.println(name2);
		name = "Hello world java !";
		name2 = "!";
		System.out.println(name.contains(name2));
		name = "India";
		name2 = "india";
		System.out.println("name2 hash code:" + name2.hashCode());

		System.out.println("name hash code:" + name.hashCode());
		int position = name2.indexOf('i');
		System.out.println(position);
		int nextPOsition = name2.indexOf('i', position + 1);
		System.out.println(nextPOsition);
		name2 = "";
		System.out.println(name2.isEmpty());
		System.out.println(name2.isBlank());
		name2 = "india";
		int lastPosition = name2.lastIndexOf('i');
		System.out.println(lastPosition);
		name = "Hello.world.Java";
		name2 = "world";
		System.out.println(name.indexOf(name2));
		System.out.println(name.replace('l', 'z'));

		System.out.println(name.replace("world", "India"));
		name = name.replace('.', ',');
		String[] strings = name.split(",");// yaha pr hmne name ko comma se separate kiya hai and then strings name ke array mein store kiya
			// abhi strings array is trh se hai [hello][world][java]
		for (String splitString : strings) {// yaha pr aise read kro for every element in strings array as splitString variable
			System.out.println(splitString.trim());// print each element.
		}
		String email = "SomeName@capgemini.com";
		String[] splitNames = email.split("@");
		String empName = splitNames[0];
		String domainName = splitNames[1];
		for (String splitString : splitNames) {
			System.out.println(splitString.trim());
		}
		System.out.println("Nme of employee:" + empName);

		String[] splitDomain = domainName.split(".com");
		String companyName = splitDomain[0];
		System.out.println("Company name:" + companyName);
		splitDomain = domainName.split("\\.");
		companyName = splitDomain[0];
		System.out.println("Company name:" + companyName);

		name = "Hello Java world";
		System.out.println(name.substring(6));
		System.out.println(name.substring(6, 9));
		Long longNum = 123456789L;
		String phoneNumber = String.valueOf(longNum);

		System.out.println(phoneNumber.contains("123"));

		Integer dataOne = 0_123_456;
		Float forData;
		Integer sample = 1234789;
		Integer digit = sample % 10; // extraxt last digit
		int intData = (int) 7.5F;
		sample = sample / 10; // drop last digit

		System.out.println(sample);
		System.out.println(digit);

		sample = 10;
		System.out.println(sample++); // post increment
		System.out.println(sample);
		sample = 10;
		System.out.println(sample--); // post increment
		System.out.println(sample);
		sample = 10;
		sample += 10; // sample = sample +10;
		System.out.println(sample);
		sample *= 5; // sample = sample * 5;
		System.out.println(sample);
		System.out.println((10 + 5) * 20);
		int aByte = 0b0110;// 8421
		int bByte = 0b0101;// 8421
		// & 0100
		// | 0111
		// ^ 0011
		int cByte = aByte & bByte;// 8421
		System.out.println(cByte);
		sample = 10;
		System.out.println(sample >> 1);// 1010 >>1 = 0101 divide by 2
		System.out.println(sample);
		System.out.println(sample << 2);// 1010 << 1 = 0001 0100 multiply by 2
		// 0001 <<1 = 0010 (2) // 0011<<1 = 0110 (6)
		int a = 10;
		int b = 20;
		System.out.println(a != b);
		// == reference check, .equals to check equality
		String s1 = "Hello";
		String s2 = "hello";
		System.out.println(s1.equals(s2));

		a = 10;
		b = 20;
		int value1 = (a < b) ? a : b;
		int value2 = (a > b) ? a : b;
		System.out.println(value1);
		System.out.println(value2);

		System.out.println();
		int time = 20;
		if (time >= 0 && time < 12) {
			System.out.println("Good morning");
		} else if (time >= 12 && time < 16) {
			System.out.println("Good Afternoon");
		} else if (time >= 16 && time < 21) {
			System.out.println("Good Evening");

		} else if (time > 21 && time <= 24) {
			System.out.println("Good Night");

		} else {
			System.out.println("Not valid time");
		}
		int month = 3;
		switch (month) {
		case 1:
			System.out.println("Jan");
			break;
		case 2:
			System.out.println("Feb");
			break;
		case 3:
			System.out.println("Mar");
			break;
		default:
			System.out.println("Not a vlid month");
		}

		System.out.println("---END---");
	}

}
