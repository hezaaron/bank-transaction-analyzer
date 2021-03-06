/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package statement.analyzer;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import statement.analyzer.model.SummaryStatistics;
import statement.analyzer.service.Statement;
import statement.analyzer.service.StatementAnalyzer;

public class MainApplication extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Pane root = createNodeHierarchy();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Bank Statement Analyzer");
        primaryStage.show();
    }
    
    private Pane createNodeHierarchy() {
        final Label title = new Label("Bank Statement Summary Statistics");
        final double size = title.getFont().getSize();
        title.setFont(new Font(size * 1.5));
        title.setTextFill(Color.GREEN);
        
        final ObservableList<String> summaries = FXCollections.observableArrayList(summaryStatistics());
        final ListView<String> summaryView = new ListView<>(summaries);
        
        VBox vbox = new VBox(8);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(title, summaryView);
        
        return vbox;
    }
    
    private List<String> summaryStatistics() {
        final DecimalFormat df = new DecimalFormat("0.0");
        final StatementAnalyzer statementAnalyzer = new StatementAnalyzer(new Statement());
        final SummaryStatistics summary = statementAnalyzer.analyzeTransactions();
        return Arrays.asList("Total transactions\t\t $" + summary.getSum(), "Max transaction\t\t $" + summary.getMax(),
                             "Min transaction\t\t $" + summary.getMin(), "Average transaction \t $" + df.format(summary.getAverage()));
    }
 }
