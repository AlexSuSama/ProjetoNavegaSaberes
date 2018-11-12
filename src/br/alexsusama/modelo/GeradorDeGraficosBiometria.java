package br.alexsusama.modelo;

import java.awt.BasicStroke;
import java.awt.Color;
//import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
//import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
//import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class GeradorDeGraficosBiometria {

	float dash[] = { 10.f };

	JFreeChart graficoPizza;
	JFreeChart graficoDeLinha;
	int armazenarValores = 0;

	public JFreeChart graficoPeriodoDeCrescimento(List<Biometria> lista, String titulo, String labelBottom,
			String labelLeft) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			for (Biometria formulario : lista) {
				dataset.addValue(formulario.getMediaCrescimento(), "Média", formulario.getDataInicial());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "deu pau no grafico");
		}

		graficoDeLinha = ChartFactory.createLineChart(titulo, labelBottom, labelLeft, dataset, PlotOrientation.VERTICAL,
				true, true, false);

		// fonte
		// Font fonteNova = new Font("TimesRoman", Font.PLAIN, 18);

		CategoryItemRenderer renderer = graficoDeLinha.getCategoryPlot().getRenderer();

		CategoryPlot plot = graficoDeLinha.getCategoryPlot();

		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.GREEN);
		plot.setAxisOffset(new RectangleInsets(12.0, 12.0, 5.0, 5.0));
		plot.setRangeGridlinePaint(Color.RED);
		// cor e linha das séries
		renderer.setSeriesPaint(0, Color.BLUE);
		/*
		 * renderer.setSeriesStroke(0, new BasicStroke(1.0f,
		 * BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.f, dash, 0.0f));
		 * renderer.setSeriesPositiveItemLabelPosition(0, new
		 * ItemLabelPosition(ItemLabelAnchor.CENTER,
		 * TextAnchor.BASELINE_CENTER)); renderer.setSeriesOutlineStroke(0, new
		 * BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.f,
		 * dash, 0.0f)); renderer.setSeriesOutlinePaint(0, Color.GREEN);
		 */

		// legendas
		LegendItemCollection legendas = new LegendItemCollection();

		LegendItem legenda1 = new LegendItem("Crescimento");
		legenda1.setSeriesIndex(0);
		legenda1.setFillPaint(Color.BLUE);
		legenda1.setLabelPaint(Color.BLACK);
		// legenda1.setLabelFont(fonteNova);
		legendas.add(legenda1);

		plot.setFixedLegendItems(legendas);

		graficoDeLinha.setBorderPaint(Color.BLUE);
		graficoDeLinha.setBorderVisible(true);
		// configura apenas o padding do bloco
		graficoDeLinha.getLegend(0).setPadding(new RectangleInsets(12.0, 2.0, 10.0, 40));
		//graficoDeLinha.getLegend().setBorder(BlockBorder.NONE);
		graficoDeLinha.getLegend().setPosition(RectangleEdge.BOTTOM);
		graficoDeLinha.getLegend().setMargin(1, -100, 2, 300);
		return graficoDeLinha;

	}

	public JFreeChart graficoTotalDeOstras(List<Biometria> lista, String titulo, String labelBottom, String labelLeft) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			for (Biometria formulario : lista) {
				dataset.addValue(formulario.getQtTotal(), "Total", formulario.getDataInicial());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "deu pau no grafico");
		}

		graficoDeLinha = ChartFactory.createLineChart(titulo, labelBottom, labelLeft, dataset, PlotOrientation.VERTICAL,
				true, true, false);

		// fonte
		// Font fonteNova = new Font("TimesRoman", Font.PLAIN, 18);

		CategoryItemRenderer renderer = graficoDeLinha.getCategoryPlot().getRenderer();

		CategoryPlot plot = graficoDeLinha.getCategoryPlot();

		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.GREEN);
		plot.setAxisOffset(new RectangleInsets(12.0, 12.0, 5.0, 5.0));
		plot.setRangeGridlinePaint(Color.RED);
		// cor e linha das séries
		renderer.setSeriesPaint(0, Color.BLUE);
		/*
		 * renderer.setSeriesStroke(0, new BasicStroke(1.0f,
		 * BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.f, dash, 0.0f));
		 * renderer.setSeriesPositiveItemLabelPosition(0, new
		 * ItemLabelPosition(ItemLabelAnchor.CENTER,
		 * TextAnchor.BASELINE_CENTER)); renderer.setSeriesOutlineStroke(0, new
		 * BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.f,
		 * dash, 0.0f)); renderer.setSeriesOutlinePaint(0, Color.GREEN);
		 */

		// legendas
		LegendItemCollection legendas = new LegendItemCollection();

		LegendItem legenda1 = new LegendItem("Ostra");
		legenda1.setSeriesIndex(0);
		legenda1.setFillPaint(Color.BLUE);
		legenda1.setLabelPaint(Color.BLACK);
		// legenda1.setLabelFont(fonteNova);
		legendas.add(legenda1);

		plot.setFixedLegendItems(legendas);

		graficoDeLinha.setBorderPaint(Color.BLUE);
		graficoDeLinha.setBorderVisible(true);
		// configura apenas o padding do bloco
		graficoDeLinha.getLegend(0).setPadding(new RectangleInsets(12.0, 2.0, 10.0, 40));
		//graficoDeLinha.getLegend().setBorder(BlockBorder.NONE);
		graficoDeLinha.getLegend().setPosition(RectangleEdge.BOTTOM);
		graficoDeLinha.getLegend().setMargin(1, -100, 2, 300);
		return graficoDeLinha;

	}

	public JFreeChart graficoPeriodoSalinidadeTemperatura(List<Biometria> lista, String titulo, String labelBottom,
			String labelLeft) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			for (Biometria formulario : lista) {
				dataset.addValue(formulario.getSalinidade(), "Salinidade", formulario.getDataInicial());
				dataset.addValue(formulario.getTemperatura(), "tempetarura", formulario.getDataInicial());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "deu pau no grafico");
		}

		graficoDeLinha = ChartFactory.createLineChart(titulo, labelBottom, labelLeft, dataset, PlotOrientation.VERTICAL,
				true, true, false);

		// Font fonteNova = new Font("TimesRoman", Font.PLAIN, 18);

		CategoryItemRenderer renderer = graficoDeLinha.getCategoryPlot().getRenderer();

		CategoryPlot plot = graficoDeLinha.getCategoryPlot();

		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.GREEN);
		plot.setAxisOffset(new RectangleInsets(12.0, 12.0, 5.0, 5.0));
		plot.setRangeGridlinePaint(Color.RED);
		// cor e linha das séries
		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesStroke(0,
				new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.f, dash, 0.0f));
		renderer.setSeriesPositiveItemLabelPosition(0,
				new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BASELINE_CENTER));
		renderer.setSeriesOutlineStroke(0,
				new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.f, dash, 0.0f));
		renderer.setSeriesOutlinePaint(0, Color.GREEN);

		// bordas
		graficoDeLinha.setBorderPaint(Color.BLUE);
		graficoDeLinha.setBorderVisible(true);

		// legendas
		LegendItemCollection legendas = new LegendItemCollection();
		LegendItem legendaTemperatura = new LegendItem("Temperatura");
		legendaTemperatura.setSeriesIndex(1);
		legendaTemperatura.setFillPaint(Color.BLUE);
		// legendaMortalidade.setLabelPaint(Color.BLUE);
		// legendaMortalidade.setLabelFont(fonteNova);

		LegendItem legendaSalinidade = new LegendItem("Salinidade");
		legendaSalinidade.setSeriesIndex(2);
		legendaSalinidade.setFillPaint(Color.RED);
		// legendaSobrevivencia.setLabelPaint(Color.RED);
		// legendaSobrevivencia.setLabelFont(fonteNova);

		legendas.add(legendaTemperatura);
		legendas.add(legendaSalinidade);

		plot.setFixedLegendItems(legendas);

		return graficoDeLinha;

	}

	public JFreeChart graficoPeriodoTemperatura(List<Biometria> lista, String titulo, String labelBottom,
			String labelLeft) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			for (Biometria formulario : lista) {
				dataset.addValue(formulario.getTemperatura(), "tempetarura", formulario.getDataInicial());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "deu pau no grafico");
		}

		graficoDeLinha = ChartFactory.createLineChart(titulo, labelBottom, labelLeft, dataset, PlotOrientation.VERTICAL,
				true, true, false); 

		// Font fonteNova = new Font("TimesRoman", Font.PLAIN, 18);

		CategoryItemRenderer renderer = graficoDeLinha.getCategoryPlot().getRenderer();

		CategoryPlot plot = graficoDeLinha.getCategoryPlot();

		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.GREEN);
		plot.setAxisOffset(new RectangleInsets(12.0, 12.0, 5.0, 5.0));
		plot.setRangeGridlinePaint(Color.RED);
		// cor e linha das séries
		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesStroke(0,
				new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.f, dash, 0.0f));
		renderer.setSeriesPositiveItemLabelPosition(0,
				new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BASELINE_CENTER));
		renderer.setSeriesOutlineStroke(0,
				new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.f, dash, 0.0f));
		renderer.setSeriesOutlinePaint(0, Color.GREEN);

		// bordas
		graficoDeLinha.setBorderPaint(Color.BLUE);
		graficoDeLinha.setBorderVisible(true);

		// legendas
		LegendItemCollection legendas = new LegendItemCollection();
		LegendItem legendaMortalidade = new LegendItem("Temperatura");
		legendaMortalidade.setSeriesIndex(2);
		legendaMortalidade.setFillPaint(Color.BLUE);
		legendas.add(legendaMortalidade);

		plot.setFixedLegendItems(legendas);

		return graficoDeLinha;
	}

	public JFreeChart graficoPeriodoSalinidade(List<Biometria> lista, String titulo, String labelBottom,
			String labelLeft) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			for (Biometria formulario : lista) {
				dataset.addValue(formulario.getSalinidade(), "salinidade", formulario.getDataInicial());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "deu pau no grafico");
		}

		graficoDeLinha = ChartFactory.createLineChart(titulo, labelBottom, labelLeft, dataset, PlotOrientation.VERTICAL,
				true, true, false);

		// Font fonteNova = new Font("TimesRoman", Font.PLAIN, 18);

		CategoryItemRenderer renderer = graficoDeLinha.getCategoryPlot().getRenderer();

		CategoryPlot plot = graficoDeLinha.getCategoryPlot();

		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.GREEN);
		plot.setAxisOffset(new RectangleInsets(12.0, 12.0, 5.0, 5.0));
		plot.setRangeGridlinePaint(Color.RED);
		// cor e linha das séries
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0,
				new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.f, dash, 0.0f));
		renderer.setSeriesPositiveItemLabelPosition(0,
				new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BASELINE_CENTER));
		renderer.setSeriesOutlineStroke(0,
				new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.f, dash, 0.0f));
		renderer.setSeriesOutlinePaint(0, Color.GREEN);

		// bordas
		graficoDeLinha.setBorderPaint(Color.BLUE);
		graficoDeLinha.setBorderVisible(true);

		// legendas
		LegendItemCollection legendas = new LegendItemCollection();
		LegendItem legendaMortalidade = new LegendItem("Salinidade");
		legendaMortalidade.setSeriesIndex(2);
		legendaMortalidade.setFillPaint(Color.RED);

		legendas.add(legendaMortalidade);

		plot.setFixedLegendItems(legendas);

		return graficoDeLinha;
	}

	public JFreeChart graficoPeriodoMortalidadeSobrevivencia(List<Biometria> lista, String titulo, String labelBottom,
			String labelLeft) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {
			for (Biometria formulario : lista) {
				dataset.addValue(formulario.getMortalidade(), "mortalidade", formulario.getDataInicial());
				dataset.addValue(formulario.getSobrevivencia(), "sobrevivência", formulario.getDataInicial());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "deu pau no grafico");
		}

		graficoDeLinha = ChartFactory.createLineChart(titulo, labelBottom, labelLeft, dataset, PlotOrientation.VERTICAL,
				true, true, false);

		// Font fonteNova = new Font("TimesRoman", Font.PLAIN, 18);

		CategoryItemRenderer renderer = graficoDeLinha.getCategoryPlot().getRenderer();

		CategoryPlot plot = graficoDeLinha.getCategoryPlot();

		plot.setBackgroundPaint(Color.WHITE);
		plot.setDomainGridlinePaint(Color.GREEN);
		plot.setAxisOffset(new RectangleInsets(12.0, 12.0, 5.0, 5.0));
		plot.setRangeGridlinePaint(Color.RED);
		// cor e linha das séries
		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesStroke(0,
				new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.f, dash, 0.0f));
		renderer.setSeriesPositiveItemLabelPosition(0,
				new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BASELINE_CENTER));
		renderer.setSeriesOutlineStroke(0,
				new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.f, dash, 0.0f));
		renderer.setSeriesOutlinePaint(0, Color.GREEN);

		// bordas
		graficoDeLinha.setBorderPaint(Color.BLUE);
		graficoDeLinha.setBorderVisible(true);

		// legendas
		LegendItemCollection legendas = new LegendItemCollection();
		LegendItem legendaMortalidade = new LegendItem("mortalidade");
		legendaMortalidade.setSeriesIndex(2);
		legendaMortalidade.setFillPaint(Color.BLUE);
		// legendaMortalidade.setLabelPaint(Color.BLUE);
		// legendaMortalidade.setLabelFont(fonteNova);

		LegendItem legendaSobrevivencia = new LegendItem("sobrevivência");
		legendaSobrevivencia.setSeriesIndex(1);
		legendaSobrevivencia.setFillPaint(Color.RED);
		// legendaSobrevivencia.setLabelPaint(Color.RED);
		// legendaSobrevivencia.setLabelFont(fonteNova);

		legendas.add(legendaMortalidade);
		legendas.add(legendaSobrevivencia);

		plot.setFixedLegendItems(legendas);

		return graficoDeLinha;

	}

	public void salvarGrafico(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, graficoDeLinha, 700, 270);
	}

	// salvarem uma versão reduzida
	public void salvarGraficoReduzido(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, graficoDeLinha, 400, 270);
	}
	// grafico da media de um periodo

}
