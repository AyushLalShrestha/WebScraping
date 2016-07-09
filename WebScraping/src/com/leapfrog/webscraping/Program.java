package com.leapfrog.webscraping;

import com.leapfrog.webscraping.util.Grabber;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is Instagram user account's photo downloader");
        System.out.println("Please enter the complete user-ID, for eg. ayush_stha : ");
        String userName = sc.nextLine();
        String userPage = Grabber.get("https://www.instagram.com/" + userName + "/");
        String regEx = "https://igcdn-photos-\\w-\\w.akamaihd.net/hphotos-ak-\\w+/(.*?).jpg";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(userPage);
        while (matcher.find()) {
            String[] data = matcher.group().split("/");
            String fileNm = data[data.length - 1];
            String fileName = fileNm.replace(".jpg", "");
            System.out.println("downloading : " + fileName + ".jpg");
            Grabber.downloadImage(matcher.group(0), fileName);
        }
    }
}
