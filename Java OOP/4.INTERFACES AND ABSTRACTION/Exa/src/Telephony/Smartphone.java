package Telephony;

import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Callable,Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        Pattern regex = Pattern.compile("\\d");
        StringBuilder builder=new StringBuilder();
        for (String url:urls
        ) {
            if (regex.matcher(url).find()) {
                builder.append("Invalid URL!");
            }else{
                builder.append("Browsing: "+url+"!");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public String call() {
        StringBuilder builder=new StringBuilder();
        Pattern regex = Pattern.compile("\\D");
        for (String number:numbers
        ) {
            if (regex.matcher(number).find()){
                builder.append("Invalid number!");
            }else{
                builder.append("Calling... "+number);
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
