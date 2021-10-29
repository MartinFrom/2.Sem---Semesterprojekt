package GUI;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIHelperClass {
    public static TabPane createTabPane(Tab... tabs) {
        TabPane tabPane = new TabPane();
        // change TabClosingPolicy here
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(tabs);
        return tabPane;
    }

    public static GridPane createGridPane(int width, int height, int vGap, int hGap, int padding) {
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setHgap(vGap);
        pane.setVgap(hGap);
        pane.setPadding(new Insets(padding));
        return pane;
    }

    public static HBox createHbox(int spacing, int padding, Node... children ) {
        HBox hbox = new HBox();
        hbox.setSpacing(spacing);
        hbox.setPadding(new Insets(padding));
        hbox.getChildren().addAll(children);
        return hbox;
    }

    public static VBox createVbox(int spacing, int padding, Node... children ) {
        VBox vbox = new VBox();
        vbox.setSpacing(spacing);
        vbox.setPadding(new Insets(padding));
        vbox.getChildren().addAll(children);
        return vbox;
    }

    public static ScrollPane createScrolledGridPane(int width, int height, int vGap, int hGap, int padding) {
        ScrollPane scp = new ScrollPane();
        GridPane gp = createGridPane(width, height,vGap, vGap, padding);
        scp.setContent(gp);
        return scp;
    }

    /**
     * creates a button thats able to hide specified stage
     *
     * @param stage is the stage the button should close (hide)
     * @param pane is the pane the button should be added to
     * @param title is the title of the button
     * @param col is the collum on the pane where the button should be added
     * @param row is the row on the pane where the button should be added
     * */
    public static void StageCloseBut( Stage  stage, GridPane pane, String title, int col, int row) {
        Button closeBnt = new Button(title);
        closeBnt.setOnAction(e -> {
            stage.hide();
        });
        pane.add(closeBnt, col, row);
    }
}

