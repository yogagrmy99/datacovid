/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiCovid;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jfree.chart.plot.PiePlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author Ramadhani BSN
 */
public class PieChart extends JFrame {
    double covid1=0,covid2=0,covid3=0,covid4=0;
    public void setNilai(String nilai1, String nilai2, String nilai3, String nilai4){
        try {
            covid1 = Double.parseDouble(nilai1);
            } catch (NumberFormatException ex){}
            try {
            covid2 = Double.parseDouble(nilai2);
            } catch (NumberFormatException ex){}
            try {
            covid3 = Double.parseDouble(nilai3);
            } catch (NumberFormatException ex){}
            try {
            covid4 = Double.parseDouble(nilai4);
            } catch (NumberFormatException ex){}
            
            this.setSize(800,700);
        JPanel covidPanel = new JPanel(new GridLayout(2, 2));
        
        DefaultPieDataset covidDataset1 = new DefaultPieDataset();
        covidDataset1.setValue("Positif = "+covid1,covid1);
        covidDataset1.setValue("PDP = "+covid2,covid2);
        covidDataset1.setValue("ODP = "+covid3,covid3);
        
//        int n5 = (int) elang1;
        
        double jml = covid1+covid2+covid3;


        DefaultPieDataset covidDataset2 = new DefaultPieDataset();
        covidDataset2.setValue("Data Termasuk : Positif, PDP, ODP = "+jml,jml);
        covidDataset2.setValue("Kematian = "+covid4,covid4);        
        JFreeChart covidChart1 = ChartFactory.createPieChart3D("Data Penduduk Yang Terkena COVID-19", covidDataset1, false, false, false);
        PiePlot3D cvdPlot1 = (PiePlot3D) covidChart1.getPlot();
        cvdPlot1.setForegroundAlpha(0.6f);
        cvdPlot1.setCircular(true);
        JFreeChart covidChart2 = ChartFactory.createPieChart3D("Perbandingan Data Keselamatan", covidDataset2, false, false, false);
        PiePlot3D cvdPlot2 = (PiePlot3D) covidChart2.getPlot();
        cvdPlot2.setForegroundAlpha(0.6f);
        cvdPlot2.setCircular(true);


        covidPanel.add(new ChartPanel(covidChart1));
        covidPanel.add(new ChartPanel(covidChart2));


        covidPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(covidPanel);

        }
}