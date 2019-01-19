package com.bhaiti.kela.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseAuthors {
	private static List<Author> authorRecords;
	private static List<Articles> articleRecords;

	private HashMap<String, String> map = new HashMap();

	public List<Author> getAuthors() {
		// System.out.println("zfnjkdgndjn-----vdfdgdf-gfd-gfdg-");
		collectAuthorData();

		return authorRecords;
	}

	public static void main(String a[]) {
		ParseAuthors p = new ParseAuthors();
		p.collectAuthorData();
	}

	public void collectAuthorData() {
		Document doc;
		authorRecords = new ArrayList<>();
		try {
			doc = Jsoup.connect("https://www.thehindu.com/profile/").get();

			Elements links = doc.select("a");
			// JSONArray data = new JSONArray();

			for (Element link : links) {
				// System.out.println(link);
				String name = link.select("a.auth-nm").html();
				String url;
				if (name != null && !name.isEmpty()) {
					url = link.attr("href");
					Author a1 = new Author(name, url);
					authorRecords.add(a1);
					map.put(name, url);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Articles> getData(String name) {
		// TODO Auto-generated method stub
		Document doc;
		String authUrl;
		articleRecords = new ArrayList<>();
		if (map.isEmpty())
			collectAuthorData();

		System.out.println(name);
		System.out.println(map);
		authUrl = map.get(name);
System.out.println(authUrl+"--------------");

		try {
			doc = Jsoup.connect(authUrl).get();
			articleRecords.add(new Articles(doc.html(), doc.html()));
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articleRecords;

	}
}
