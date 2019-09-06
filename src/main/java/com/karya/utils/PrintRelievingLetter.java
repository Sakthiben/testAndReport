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
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

public class PrintRelievingLetter {

	/**
	 * Print Relieving Letter
	 * @param model
	 */
	public void printRelievingLetter(HashMap<String, String> model) throws Exception {
		
		// Get Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date today = dateFormat.parse(dateFormat.format(new Date()));
		
		//ClassLoader classLoader = getClass().getClassLoader();
		StyleBuilder boldStyle = stl.style().bold();
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
	    		cmp.text("Relieving Letter").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT)).newRow()
	    		.add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))
	    
	    // Official Data
	    .title(cmp.horizontalList().add(cmp.text("Date: " + today.toString()).setStyle(boldStyle).setHorizontalAlignment(HorizontalAlignment.LEFT)))
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    // Address
	    .title(cmp.horizontalList().add(cmp.text(model.get("APPLICANT_NAME_PREFIX").toString() + ". " + model.get("APPLICANT_NAME").toString()).setHorizontalAlignment(HorizontalAlignment.LEFT)))
	    .title(cmp.horizontalList().add(cmp.text(model.get("LINE_1").toString() + ",").setHorizontalAlignment(HorizontalAlignment.LEFT)))
	    .title(cmp.horizontalList().add(cmp.text(model.get("LINE_2").toString() + ",").setHorizontalAlignment(HorizontalAlignment.LEFT)))
	    .title(cmp.horizontalList().add(cmp.text(model.get("CITY_OR_VILLAGE").toString() + " - " + model.get("POSTAL_CODE").toString()).setHorizontalAlignment(HorizontalAlignment.LEFT)))
	    .title(cmp.horizontalList().add(cmp.text(model.get("STATE_OR_TERRITORY").toString() + ", " + model.get("COUNTRY").toString()).setHorizontalAlignment(HorizontalAlignment.LEFT)))
	    .title(cmp.horizontalList().add(cmp.text("Tel# " + model.get("PHONE_NO").toString() + ", " + model.get("ALTERNATIVE_PHONE_NO").toString()).setHorizontalAlignment(HorizontalAlignment.LEFT)).newRow())
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    // Applicant Name
	    .title(cmp.horizontalList().add(cmp.text("Dear " + model.get("APPLICANT_NAME").toString() + ",").setHorizontalAlignment(HorizontalAlignment.LEFT)).newRow())
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    // Letter Body
	    .title(cmp.horizontalList().add(cmp.text("This refers to your registration letter. Your registration has been accepted by our management. You have been "
	    		+ "an integral part of " + model.get("COMPANY").toString() + " since " + model.get("DATE_OF_JOIN").toString() + " and played a "
	    				+ "key role in " + model.get("POSITION").toString() + " with grade " + model.get("GRADE").toString() + " to achive organizational goals.")
	    .setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("I am sure your deligence and hardwork will stand you in good stead in your new organization"
	    		+ " and I wish you all the best in your new assignment.")
	    		.setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
	    
	    .title(cmp.horizontalList().add(cmp.text(""))) 
	    
	    .title(cmp.horizontalList().add(cmp.text("You will be relieved from the services at the closing hours of this date - " + model.get("DATE_OF_RELIEVE").toString() + ".")
	    		.setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
	    
	    // Blank Space
	    .title(cmp.horizontalList().add(cmp.text("")))
	    .title(cmp.horizontalList().add(cmp.text("")))
	    
	    .title(cmp.horizontalList().add(cmp.text(model.get("COMPANY").toString() + " Confidential").setStyle(boldStyle)
		  		.setHorizontalAlignment(HorizontalAlignment.LEFT)))
	    
	    //shows number of page at page footer
	    .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle));
	    
	    //create and show report
	    //.show();
	    
	    // Save Relieving Letter as PDF
	    report.toPdf(new FileOutputStream("D:/" + model.get("RELIEVING_LETTER_NAME").toString() + ".pdf")); //export the report to a pdf file
	}
}
