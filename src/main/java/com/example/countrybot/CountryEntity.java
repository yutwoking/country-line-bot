package com.example.countrybot;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class CountryEntity {

	@CsvBindByName(column = "国・地域名", required = true)
    private String japaneseName;

    @CsvBindByName(column = "ISO 3166-1に於ける英語名", required = true)
    private String englishName;

    @CsvBindByName(column = "数", required = true)
    private String codeInNumeric;

    @CsvBindByName(column = "三字", required = true)
    private String codeInAlpha3;

    @CsvBindByName(column = "二字", required = true)
    private String codeInAlpha2;

    @CsvBindByName(column = "場所", required = true)
    private String location;

    @CsvBindByName(column = "各行政区分", required = true)
    private String division;

    public String getInfoString() {
    	return "国名 : " + japaneseName + "\n" +
    			"英語名 : " + englishName + "\n" +
    			"国コード（数値） : " + codeInNumeric + "\n" +
    			"国コード（3字） : " + codeInAlpha3 + "\n" +
    			"国コード（2字） : " + codeInAlpha2 + "\n" +
    			"地域 : " + location;
    }

    public boolean equalJapaneseName(String searchString) {
    	if (japaneseName.contains("|")) {
    		String[] japaneseNames = japaneseName.split("\\|");
    		for (String name : japaneseNames) {
    			System.out.println(name);
    			if(name.equals(searchString)) {
    				return true;
    			}
    		}
    		return false;
    	} else {
    		return japaneseName.equals(searchString);
    	}
    }

}
