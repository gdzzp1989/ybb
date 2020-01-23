package ybb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoupTest1 {
	public static List<Score> getList(){
		List<Score> list = new ArrayList<>();
		try{
			Document doc = Jsoup.connect("https://www.eol.cn/e_html/gk/fsx/index.shtml").get();
			Elements cityEles = doc.getElementsByClass("fsshowli");
			for (Element cityEle : cityEles) {
				String cityName = cityEle.select(".city").text();
				Elements yearsEles = cityEle.getElementsByClass("year");
				for (int i =0;i<yearsEles.size();i++) {
					Element yearsEle = yearsEles.get(i);
					String yearName = yearsEle.text();
					Element tabletEles = cityEle.select("table").get(i);

					//读取表格抬头
					Elements titleEles = tabletEles.select("tr").get(0).select("td");
					List<String> courses = new ArrayList<>();
					for(int j=0;j<titleEles.size();j++){
						courses.add(titleEles.get(j).text());
					}
					//读取数据
					Elements trEles = tabletEles.select("tr");
					for(int k=0;k<trEles.size();k++){
						if(k!=0){
							Elements tdsEles = trEles.get(k).select("td");
							String batch="";
							for(int m=0;m<tdsEles.size();m++){
								if(m==0){
									batch=tdsEles.get(m).text();
								}else{
									Score score = new Score();
									score.setCity(cityName);
									score.setYear(yearName);
									score.setBatch(batch);
									score.setCourse(courses.get(m));
									score.setScore(tdsEles.get(m).text());
									list.add(score);
								}
							}
						}
					}
				}
			}
			for(Score score:list){
				System.out.println(score);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
