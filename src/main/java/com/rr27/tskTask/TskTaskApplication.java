package com.rr27.tskTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TskTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TskTaskApplication.class, args);
	}

	/**
	 * Ну короч накидал я два разных варика, про рест темплейт я думал в начале, но большую часть времени
	 * я зачем-то делал все руками, не используя возможности спринга
	 * И написав, решил все таки вернуться к Темплейту, контроллер вышел объемнее, но без доп лишних бинов
	 */


	/**
	 * Доработки
	 * fixme! нормальный строитель URL для API
	 * fixme! разобраться, почему приватный пропертис не подтягивается
	 * fixme! все же связать получение ответа от ЯндексAPI и парсер сразу через inputStream, а не промежуточный файл
	 */


}
