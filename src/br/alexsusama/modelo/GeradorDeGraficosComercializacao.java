package br.alexsusama.modelo;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
//import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;


public class GeradorDeGraficosComercializacao {
	JFreeChart graficoDeBarras;

	public JFreeChart gerarGraficoDePizzaComercializacao(List<Comercializacao> lista, String titulo, String labelBottom,
			String labelLeft) throws SQLException {
		DefaultPieDataset pieData = new DefaultPieDataset();

		for (Comercializacao comercializacao : lista) {
			pieData.setValue(comercializacao.getMunicipio(), comercializacao.getDuziasTotal());
			
		}
		return graficoDeBarras = ChartFactory.createPieChart3D("Áreas de comercialização 2018", pieData, true, true,
				false);
	}

	public JFreeChart graficoDuziasVendidas(List<Comercializacao> lista, String titulo, String labelBottom,
			String labelLeft) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			for (Comercializacao formulario : lista) {
				dataset.addValue(formulario.getDuziasTotal(), "quantidade vendida", formulario.getMunicipio());

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "deu pau no grafico");
		}
 
		graficoDeBarras = ChartFactory.createBarChart(titulo, labelBottom, labelLeft, dataset, PlotOrientation.VERTICAL,
				true, true, false);

	//	CategoryItemRenderer renderer = graficoDeBarras.getCategoryPlot().getRenderer();

		CategoryPlot plot = graficoDeBarras.getCategoryPlot();

		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.GREEN);
		plot.setAxisOffset(new RectangleInsets(12.0, 12.0, 5.0, 5.0));
		plot.setRangeGridlinePaint(Color.RED);

		// legendas
		LegendItemCollection legendas = new LegendItemCollection();

		LegendItem legenda1 = new LegendItem("Duzias");
		legenda1.setSeriesIndex(0);
		legenda1.setFillPaint(Color.RED);
		legenda1.setLabelPaint(Color.BLACK);
		
		legendas.add(legenda1);

		plot.setFixedLegendItems(legendas);

		graficoDeBarras.setBorderPaint(Color.BLUE);
		graficoDeBarras.setBorderVisible(true);
		// configura apenas o padding do bloco
		graficoDeBarras.getLegend(0).setPadding(new RectangleInsets(12.0, 2.0, 10.0, 40));
		//graficoDeBarras.getLegend().setBorder(BlockBorder.NONE);
		graficoDeBarras.getLegend().setPosition(RectangleEdge.BOTTOM);
		graficoDeBarras.getLegend().setMargin(1, -100, 2, 300);
		return graficoDeBarras;

	}

	public void salvarGrafico(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, graficoDeBarras, 700, 270);
	}

	// salvarem uma versão reduzida
	public void salvarGraficoReduzido(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, graficoDeBarras, 400, 270);
	}
	// grafico da media de um periodo

}
