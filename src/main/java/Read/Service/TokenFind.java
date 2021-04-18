package Read.Service;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

public class TokenFind {

	public boolean gettoken(String Token) throws IOException {

		boolean f = false;
		int count = 0;
		
		/*
		 * String resourcePath = null; switch (System.getProperty("os.name")) { case
		 * "Linux": resourcePath = "/home/romankooo/work/txt/"; break; case
		 * "Microsoft Windows 10 Pro": resourcePath =
		 * "C:\\Users\\yousefi-pc\\eclipse-workspace\\data.txt"; break; }
		 */
		// String Token1 = Token;
		
		String resourcePath = "C:\\Users\\yousefi-pc\\eclipse-workspace\\data.txt";
		File file = new File(resourcePath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			if (Token.equals(line)) {
				count++;
				f = true;
				break;
				
			}

		}
		return f;

	}

	public boolean geturl(String host) throws Throwable,IOException {
		

		boolean f = false;
		int count = 0;
		if (host!=null)
		String resourcePathurl = "C:\\Users\\yousefi-pc\\eclipse-workspace\\url.txt";
		File file = new File(resourcePathurl);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			if (host.equals(line)) {
				count++;
				f = true;
				break;
				// System.out.println(line);
			}

		}
	}
		return f;

	}

}
