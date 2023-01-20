package view;
import model.Histogram;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    private final Histogram<String> histogram;
    public HistogramDisplay(Histogram<String> histogram, String title) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
        
    }
    
    public void execute(){
        this.setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("Histogram",
                                                        "Dominios emails",
                                                        "Nº emails",
                                                        dataset,
                                                        PlotOrientation.VERTICAL,
                                                        false, 
                                                        false,
                                                        rootPaneCheckingEnabled);
        return chart;
    
    }
    
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for (String key : this.histogram.keySet()) {
            dataSet.addValue(this.histogram.get(key), "", key);
        }

        return dataSet;
    }
}
