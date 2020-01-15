package com.rr27.tskTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TskTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TskTaskApplication.class, args);
	}

	/**
	 * Доработки
	 * fixme! нормальный строитель URL для API
	 * fixme! разобраться, почему приватный пропертис не подтягивается
	 * fixme! все же связать получение ответа от ЯндексAPI и парсер сразу через inputStream, а не промежуточный файл
	 */


}
