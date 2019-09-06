package com.karya.utils;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.awt.Color;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

public class PrintOfferLetter {

/**
 * Print Offer Letter
 * @param model
 */
public void printOfferLetter(HashMap<String, String> model) throws Exception {
	
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
    		cmp.text("Offer Letter").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT)).newRow()
    		.add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))
    
    // Official Data
    .title(cmp.horizontalList().add(cmp.text("Offer: " + model.get("OFFER").toString()).setStyle(boldStyle).setHorizontalAlignment(HorizontalAlignment.LEFT)))  		
    .title(cmp.horizontalList().add(cmp.text("Ref: " + model.get("REFER").toString()).setStyle(boldStyle).setHorizontalAlignment(HorizontalAlignment.LEFT)))
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
    .title(cmp.horizontalList().add(cmp.text("Thank you for exploring career opportunities with " + model.get("COMPANY").toString() + ". You have successfully "
    		+ "completed our initial selection process and we are pleased to make you an offer.")
    		.setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
    
    // Blank Space
    .title(cmp.horizontalList().add(cmp.text("")))
    
 // boldStyle   
    .title(cmp.horizontalList().add(cmp.text("This offer is based on your profile and performance in the selection process. You have been selected for the "
    		+ "position of " + model.get("POSITION").toString() + " in Grade " + model.get("GRADE").toString() + ". Your gross salary including all benefits will be Rs." + model.get("CTC").toString() + " per annum, as per the "
    				+ "terms and conditions set out herein. The gross salary mentioned above is inclusive of the Variable Allowance becoming effective upon successful completion of the initial Training Programme.")
	  		.setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
    
    // Blank Space
    .title(cmp.horizontalList().add(cmp.text("")))
    
    .title(cmp.horizontalList().add(cmp.text("Kindly confirm your acceptance of this offer online through the option 'Accept Offer Letter'. If not accepted within the " + model.get("DATE_OF_JOIN").toString() + ", it will be constructed "
    		+ "that you are not interested in this employment and this offer will be automatically withdrawn.")
	  		.setHorizontalAlignment(HorizontalAlignment.JUSTIFIED)))
    
    // Blank Space
    .title(cmp.horizontalList().add(cmp.text("")))
    
    .title(cmp.horizontalList().add(cmp.text("After you accept this offer, you will be given a joining letter indicating the details of your joining date and initial place of posting. You will also be issued a letter of appointment at the "
    		+ "time of your joining after completing joining formalities as per company policy.")
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
    
    // Save Offer Letter as PDF
    report.toPdf(new FileOutputStream("D:/" + model.get("OFFER_LETTER_NAME").toString() + ".pdf")); //export the report to a pdf file
}
}
