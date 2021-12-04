package gr.codelearn.core.showcase.oop.collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.util.Arrays.sort;

public class Main {

	public static void main(String[] args) {

		String[] appsArray = new String[5];
		appsArray[0] = "word";
		appsArray[1] = "excel";
		appsArray[2] = "PowerPoint";
		appsArray[3] = "MS Team";
		appsArray[4] = "SharePoint";

		//        for (int i = 0; i < appsArray.length; i++) {
		//            System.out.println(appsArray[i]);
		//        }
		//
		//        System.out.println(appsArray[1]);
		//
		//        for(String s : appsArray){
		//            System.out.println(s);
		//        }

		//        float[] arr = new float[3];
		//        arr[0] = 3.2f;

		System.out.println(Arrays.toString(appsArray));
		sort(appsArray);
		System.out.println(Arrays.toString(appsArray));

		// ArrayList
		//        ArrayList appList = new ArrayList(); // Object
		//        ArrayList<String> appList = new ArrayList<>();
		//        appList.add("word");
		//        appList.add("excel");
		//        appList.add("powerpoint");
		//        appList.add(5);
		//        String ls = (String) appList.get(0);
		//        System.out.println(appList.get(0));
		//        System.out.println(appList.get(1));

		//        for (int i = 0; i < appList.size(); i++) {
		//            System.out.println(appList.get(i));
		//        }
		//
		//        for (String s : appList) {
		//            System.out.println(s);
		//        }

		//        System.out.println(appList);
		//        appList.remove("word");
		//        appList.remove(0);
		//        System.out.println(appList);
		//        System.out.println(appsArray);

		//        ArrayList<Float> alFloat = new ArrayList<>();
		//        alFloat.add(12.7f);
		//        float f = alFloat.get(0);

		//        String s = new String("Hello");
		//        Double d = 3.6;
		//        Double d1 = new Double(5.2);

		//        HashMap<String, String> appMap = new HashMap<>();
		//        appMap.put("first", "word");
		//        appMap.put("second", "excel");
		//        appMap.put("third", "powerpoint");
		//        appMap.put("first", "powerpoint");
		//
		//        System.out.println(appMap);
		//        System.out.println(appMap.get("second"));
		//
		//        for (String key : appMap.keySet()) {
		//            System.out.println(appMap.get(key));
		//        }
		//
		//        for(String value : appMap.values()){
		//            System.out.println(value);
		//        }
	}
}
