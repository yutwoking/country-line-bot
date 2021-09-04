package com.example.countrybot;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class CountryResources {

	final private static Path csvFilePath = Paths.get("src/main/resources/static/country_info.csv");

	private static CountryResources countryResources = new CountryResources();

	private static List<CountryEntity> countryInfoList = new ArrayList<>();

	public static CountryResources getInstance() {
		return countryResources;
	}

	public static void readFile() {
		try (Reader reader = Files.newBufferedReader(csvFilePath)) {
			countryInfoList = new CsvToBeanBuilder<CountryEntity>(reader).withType(CountryEntity.class).build().parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<CountryEntity> getCountryInfoList() {
		return countryInfoList;
	}

	public static CountryEntity searchCountryInfo(String serachString) {
		for (CountryEntity entity : countryInfoList) {
			if (serachString.equals(entity.getJapaneseName())
					|| serachString.equalsIgnoreCase(entity.getEnglishName())
					|| serachString.equalsIgnoreCase(entity.getCodeInAlpha2())
					|| serachString.equalsIgnoreCase(entity.getCodeInAlpha3())
					|| serachString.equalsIgnoreCase(entity.getCodeInNumeric())) {
				return entity;
			}
		}
		return null;
	}

}
