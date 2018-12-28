package org.wulfnoth.gadus.service;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.wulfnoth.gadus.ui.custom.RatioPane;

public class Main extends Application {

//	private static final int WIDTH = 800;
//	private static final int HEIGHT = 600;
	private static final String url = "http://www.baidu.com";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMaximized(true);

		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		webEngine.load("http://www.baidu.com");

//		StackPane pane = new StackPane();
		TextArea field = new TextArea();
		field.setPrefHeight(Double.MAX_VALUE);
		field.setScrollLeft(1);

		field.setFont(new Font(18));
		RatioPane root = new RatioPane(50, 50);
//		root.getChildren().add(webView);
		root.add(field, 0, 0);
		root.add(webView, 1, 0);
//		root.getChildren().add(field);
//		root.getChildren().add(webView);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

		Region region = (Region) field.lookup(".content");
		region.setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
		region.setStyle("-fx-background-color: darkgray");
	}
}
