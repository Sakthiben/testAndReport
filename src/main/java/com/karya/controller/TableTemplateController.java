package com.karya.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.TableTemplateBean;
import com.karya.bean.UploadTemplateBean;
import com.karya.model.UploadTemplate001MB;
import com.karya.service.ITableTemplateService;
import com.karya.utils.DownloadTemplate;

@Controller
@RequestMapping(value="UploadandDownload")
public class TableTemplateController extends BaseController {
	
	@Resource(name="tabletemplateservice")
	private ITableTemplateService tabletemplateservice;
	
	@RequestMapping(value = "/UploadandDownload", method = RequestMethod.GET)
	public ModelAndView tabletemplate(@ModelAttribute("command") TableTemplateBean tabletemplatebean, String mode) throws SQLException {
		Map<String, Object> model = new HashMap<String, Object>();
		List<String> tableList = new ArrayList<String>();
		tableList = tabletemplateservice.getAllTables();
		model.put("tableList", tableList);
		if(mode != null) {
			if(mode.equals("New")) {
				model.put("msg", submitSuccess); 
			} else if(mode.equals("Old")) {
				model.put("msg", updateSuccess);
			} else if(mode.equals("Delete")) {
				model.put("msg", deleteSuccess);
			}
		}
		return new ModelAndView("UploadandDownload",model);
    }
	
	@RequestMapping(value = "/downloadtemplate", method = RequestMethod.POST)
	public void downloadtemplate(@ModelAttribute("command") @Valid TableTemplateBean tabletemplatebean,
			HttpServletRequest request, HttpServletResponse response) {
		OutputStream out = null;
		response.setContentType("application/xls");
		response.addHeader("Content-Disposition", "attachment; filename="+tabletemplatebean.getTablename()+".xls");
		DownloadTemplate downloadTemplate = new DownloadTemplate();
		List<String> tableColumnList = new ArrayList<String>();
		try {
			tableColumnList = tabletemplateservice.downloadtemplate(tabletemplatebean.getTablename());
			Workbook workbook = downloadTemplate.ProcessExcelFormat(tableColumnList);
			out = response.getOutputStream();
			workbook.write(out);
			out.flush();
			out.close();
		} catch(Exception ex) {} 
    }
	
	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public void uploadfile(@ModelAttribute("command") UploadTemplateBean uploadtemplatebean,
			BindingResult result, String mode) throws IOException {
		uploadtemplatebean.setFilename(uploadtemplatebean.getFile().getOriginalFilename());
		uploadtemplatebean.setContent(uploadtemplatebean.getFile().getBytes());
		UploadTemplate001MB file = prepareModel(uploadtemplatebean);
		tabletemplateservice.uploadfile(file);
	}
	
	private UploadTemplate001MB prepareModel(UploadTemplateBean uploadtemplatebean) {
		UploadTemplate001MB file = new UploadTemplate001MB();
		file.setId(uploadtemplatebean.getId());
		file.setContent(uploadtemplatebean.getContent());
		file.setFilename(uploadtemplatebean.getFilename());
		return file;	
	}
}
