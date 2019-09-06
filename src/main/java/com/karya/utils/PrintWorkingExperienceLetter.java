package com.karya.utils;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

import java.awt.Color;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

public class PrintWorkingExperienceLetter {

	/**
	 * Print Experience Letter
	 * @param model
	 */
	public void printWorkingExperienceLetter(HashMap<String, String> model) throws Exception {
		
		// Get Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date today = dateFormat.parse(dateFormat.format(new Date()));
		
		// Set Gender
		String gender_format_1 = "";
		String gender_format_2 = "";
		if(model.get("APPLICANT_NAME_PREFIX").toString().equalsIgnoreCase("Mr") || model.get("APPLICANT_NAME_PREFIX").toString().equalsIgnoreCase("Other")) {
			gender_format_1 = "his";
			gender_format_2 = "him";
		}
		
		if(model.get("APPLICANT_NAME_PREFIX").toString().equalsIgnoreCase("Mrs") || model.get("APPLICANT_NAME_PREFIX").toString().equalsIgnoreCase("Ms")) {
			gender_format_1 = "her";
			gender_format_2 = "her";
		}
		
		FontBuilder font = stl.fontArial();
		StyleBuilder boldStyle = stl.style().bold();
		StyleBuilder underLine = stl.style(boldStyle).underline().setFontSize(12);
		StyleBuilder subjectStyle = stl.style(boldStyle).underline().setFontSize(12);
		
		StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder columnTitleStyle  = stl.style(boldCenteredStyle).setBorder(stl.pen1Point())
				.setBackgroundColor(Color.LIGHT_GRAY);
		StyleBuilder titleStyle = stl.style(boldCenteredStyle).setVerticalAlignment(VerticalAlignment.MIDDLE)
				.setFontSize(15);
		JasperReportBuilder report = DynamicReports.report();
		
		//create new report design
	    report.setColumnTitleStyle(columnTitleStyle).setSubtotalStyle(boldStyle).highlightDetailEvenRows()
	    
	    //shows report title
	    .title(cmp.horizontalList().add(
	    		cmp.image(getClass().getClassLoader().getResourceAsStream("document/image/karya_logo.png")).setFixedDimension(120, 50),
	    		cmp.text("Experience Letter").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT)).newRow()
	    		.add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))
	    
	    // Official Data
	    .title(cmp.horizontalList().add(cmp.text("Date: " + today.toString()).setStyle(boldStyle).setHorizontalAlignment(HorizontalAlignment.LEFT)))
	     
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    // Subject
	    .title(cmp.horizontalList().add(cmp.text("Experience Certificate").setStyle(subjectStyle).setHorizontalAlignment(HorizontalAlignment.CENTER)))
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    // Letter Body
	    .title(cmp.horizontalList().add(cmp.text("It is certified that " + model.get("APPLICANT_NAME_PREFIX").toString() + ". " + model.get("APPLICANT_NAME").toString() + " was "
	    		+ "under the employer of " + model.get("COMPANY").toString() + " as a " + model.get("POSITION").toString() + " with grade " + model.get("GRADE").toString() + " from "
	    				+ model.get("DATE_OF_JOIN").toString() + " to " + model.get("DATE_OF_RELIEVE").toString() + ".")
	    		.setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    // Letter Body
	    .title(cmp.horizontalList().add(cmp.text("During " + gender_format_1 + " stay we observe " + gender_format_2 + " obedient, honest and dedicated to " + gender_format_1 + " assignment.")
	    .setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    // Letter Body
	    .title(cmp.horizontalList().add(cmp.text("We hope and pray bright future in " + gender_format_1 + " life.")
	    		.setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    .title(cmp.horizontalList().add(cmp.text("Senior HR.").setStyle(boldStyle)
		  		.setHorizontalAlignment(HorizontalAlignment.RIGHT)))
	    .title(cmp.horizontalList().add(cmp.text(model.get("COMPANY").toString()).setStyle(boldStyle)
		  		.setHorizontalAlignment(HorizontalAlignment.RIGHT)))
	    
	    //shows number of page at page footer
	    .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle));
	    
	    //create and show report
	    //.show();
	    
	    // Save Relieving Letter as PDF
	    report.toPdf(new FileOutputStream("E:/" + model.get("WORKING_EXPERIENCE_LETTER_NAME").toString() + ".pdf")); //export the report to a pdf file
	}
}
