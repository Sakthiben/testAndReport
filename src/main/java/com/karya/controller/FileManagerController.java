package com.karya.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.karya.bean.FileManagerBean;
import com.karya.bean.TaskBean;
import com.karya.model.FileManager001MB;
import com.karya.service.IFileManagerService;


@Controller
@RequestMapping(value="File")
public class FileManagerController {
	
	@Resource(name="FileService")
 	private IFileManagerService FileService;
	
	
	@RequestMapping(value = "/filemanager", method = RequestMethod.GET)
	public ModelAndView addfiles(@ModelAttribute("command") FileManagerBean filemanagerbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("files",  prepareListofBean(FileService.listFiles()));
		return new ModelAndView("filemanager", model);
	}
	
	@RequestMapping(value = "/filegetdatasaved", method = RequestMethod.POST)
	public ModelAndView filegetdata(@ModelAttribute("command") FileManagerBean filemanagerbean,
			BindingResult result) throws IOException {
		String user = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
		filemanagerbean.setLoginuser(user);
		filemanagerbean.setFilename(filemanagerbean.getFile().getOriginalFilename());
		filemanagerbean.setSize(filemanagerbean.getFile().getSize()+"Kb");
		filemanagerbean.setCreated(new Date());
		filemanagerbean.setContent(filemanagerbean.getFile().getBytes());
		filemanagerbean.setContenttype(filemanagerbean.getFile().getContentType());
		FileManager001MB file = prepareModel(filemanagerbean);
		FileService.addfiles(file);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("files",  prepareListofBean(FileService.listFiles()));
		return new ModelAndView("filemanager", model);
	}
	
	@RequestMapping("/download/{id}")
	public String download(@PathVariable("id") int id, HttpServletResponse response) {
		FileManager001MB fileManager001MB = FileService.getfile(id);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +fileManager001MB.getFilename()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(fileManager001MB.getContenttype());
			InputStream is = null;
			is = new ByteArrayInputStream(fileManager001MB.getContent());
			IOUtils.copy(is, out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deletedocument(@ModelAttribute("command") FileManagerBean fileManagerBean,
			BindingResult result) {
		FileService.deleteFiles(fileManagerBean.getId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("file", null);
		model.put("files",  prepareListofBean(FileService.listFiles()));
		return new ModelAndView("filemanager", model);	
	}
	
	
	private List<FileManagerBean> prepareListofBean(List<FileManager001MB> files ) {
		List<FileManagerBean> beans = null;
		if(files != null && !files.isEmpty()){
			beans = new ArrayList<FileManagerBean>();
			FileManagerBean bean = null;
			for(FileManager001MB file : files){
				bean = new FileManagerBean();
				bean.setLoginuser(file.getLoginuser());
				bean.setCategory(file.getCategory());
			    bean.setFilename(file.getFilename());
				bean.setId(file.getId());
				bean.setSize(file.getSize());
				bean.setCreated(file.getCreated());
				beans.add(bean);
			}
		}
		return beans;
	}
	

	private FileManager001MB prepareModel(FileManagerBean filemanagerbean) {
		FileManager001MB file = new FileManager001MB();
		file.setLoginuser(filemanagerbean.getLoginuser());
		file.setCategory(filemanagerbean.getCategory());
		file.setFilename(filemanagerbean.getFilename());
		file.setSize(filemanagerbean.getSize());
		file.setId(filemanagerbean.getId());
		file.setCreated(filemanagerbean.getCreated());
		file.setContenttype(filemanagerbean.getContenttype());
		file.setContent(filemanagerbean.getContent());
		return file;	
		
	}
				
}